package com.wawvote.wawvote;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URI;

public class info extends AppCompatActivity {
    private static ImageView foto;
    private final String SERVER_URL = "http://192.168.137.127:8080";
    private int getPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        foto = (ImageView) findViewById(R.id.imageView);
        foto.setImageResource(R.drawable.kandydat1);

        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
        if(getIntent() != null)
        {
            String candidateName = getIntent().getStringExtra("candidateName");
            getPath = Integer.parseInt(getIntent().getStringExtra("imagePath"));
            try{
                txtInfo.setText(candidateName);
                foto.setImageResource(R.drawable.kandydat1+getPath);
            }catch (NullPointerException e){

            }

        }

        TextView nazwa = (TextView)findViewById(R.id.nazwa);
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("nazwa");
            nazwa.setText(info);
        }


    }

    protected void makeVote(int vote){
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVER_URL+"/candidates/?id="+vote,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            requestQueue.stop();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    requestQueue.stop();
                }
            });
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(100000, 2, (float) 2.0));
            requestQueue.add(stringRequest);
    }

    public void voteOnClick(View view) {
        makeVote(getPath);
        startActivity(new Intent(getApplicationContext(), end_screen.class));
    }
}
