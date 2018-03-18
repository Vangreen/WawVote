package com.wawvote.wawvote;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class info extends AppCompatActivity {
    private static ImageView foto;
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
            int getPath = Integer.parseInt(getIntent().getStringExtra("imagePath"));
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
}
