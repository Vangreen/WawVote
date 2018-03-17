package com.wawvote.wawvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class reczne extends AppCompatActivity {
    private static ImageView imageview_pesel;
    private static ImageView imageview_numer;
    private static Button button;
    private int current_image;
    int[] images = {R.drawable.checked, R.drawable.wrong};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reczne);
    }

    public void buttonOnClick(View v){
        String numer1, numer2, pesel;
        EditText text = (EditText) findViewById(R.id.numer1);
        EditText text1 = (EditText) findViewById(R.id.numer2);
        EditText text2 = (EditText) findViewById(R.id.pesel);
        numer1 = text1.getText().toString();
        pesel = text2.getText().toString();
        numer2 = text.getText().toString();
        button = (Button) findViewById(R.id.check);
        imageview_numer = (ImageView) findViewById(R.id.check1);
        imageview_pesel = (ImageView) findViewById(R.id.check2);
        if (pesel.length()==11){

            imageview_pesel.setImageResource(R.drawable.checked);
        }else{
            imageview_pesel.setImageResource(R.drawable.wrong);
        }
        if (numer1.length()==6 && numer2.length()==3  ){

            imageview_numer.setImageResource(R.drawable.checked);
        }else{
            imageview_numer.setImageResource(R.drawable.wrong);
        }


        //Button button =(Button) v;







    }
}