package com.wawvote.wawvote;

import android.content.Context;
import android.os.AsyncTask;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ecosse on 18.03.2018.
 */

public class PobierzWyniki {


    protected String getData(Context  contexts) {
             final String SERVER_URL = "http://192.168.137.127:8080/candidates";
            final RequestQueue requestQueue = Volley.newRequestQueue(contexts);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_URL,

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
            return stringRequest.toString();
    }

}
