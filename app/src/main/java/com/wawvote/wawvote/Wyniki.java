package com.wawvote.wawvote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class Wyniki extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyniki);

        barChart = (BarChart) findViewById(R.id.bargraph);
        barChart.setNoDataText("Proszę czekać, trwa ładowanie wyników");
        PobierzWyniki pobierzWyniki = new PobierzWyniki();
        Gson gson = new Gson();
        getData();
//        ArrayList<BarEntry> barEntries = new ArrayList<>();
//        barEntries.add(new BarEntry(44f,0));
//        barEntries.add(new BarEntry(84f,1));
//        barEntries.add(new BarEntry(60f,2));
//        barEntries.add(new BarEntry(10f,3));
//        BarDataSet barDataSet = new BarDataSet(barEntries,"Imiona");
//
//        ArrayList<String> theNames = new ArrayList<>();
//        theNames.add("Test");
//        theNames.add("Test");
//        theNames.add("Test");
//        theNames.add("Test");
//
//        BarData theData = new BarData(theNames, barDataSet);
//        barChart.setData(theData);
//
//        barChart.setEnabled(false);
    }
    protected void getData() {
        final String SERVER_URL = "http://192.168.137.127:8080/candidates";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATA: ", response);
                        Gson gson = new Gson();
                        Map<Integer, Double> map = (Map<Integer, Double>) gson.fromJson(response, Map.class);
                        ArrayList<BarEntry> barEntries = new ArrayList<>();
                        System.out.println(map.get("1").getClass());
                        for(int i = 0; i < 6; i++){
                            float aDouble =  Float.parseFloat(map.get(i + "").toString()) ;
                            barEntries.add(new BarEntry(aDouble,i));
                        }
                        BarDataSet barDataSet = new BarDataSet(barEntries,"");

                        ArrayList<String> theNames = new ArrayList<>();
                        theNames.add("Paweł Rabiej");
                        theNames.add("Rafał Trzaskowski");
                        theNames.add("Piotr Leroy-Marzec");
                        theNames.add("Jarosław Krajewski");
                        theNames.add("Paweł Tanajno");
                        theNames.add("Hanna Gronkiewicz-Waltz");

                        BarData theData = new BarData(theNames, barDataSet);
                        barChart.setData(theData);
                        
                        barChart.setDescription("");

                        //System.out.println(map.toString());
                        View view = findViewById(R.id.wizard);
                        view.performClick();
                        requestQueue.stop();
                        //finish();
                        //startActivity(getIntent());


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

}