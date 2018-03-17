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
    int try1, try2;
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

    public void buttonOnClick(View v) {

        String numer1_str, numer2_str, pesel_str;
        EditText text = (EditText) findViewById(R.id.numer1);
        EditText text1 = (EditText) findViewById(R.id.numer2);
        EditText text2 = (EditText) findViewById(R.id.pesel);
        numer1_str = text1.getText().toString();
        pesel_str = text2.getText().toString();
        numer2_str = text.getText().toString();
        button = (Button) findViewById(R.id.check);
        imageview_numer = (ImageView) findViewById(R.id.check1);
        imageview_pesel = (ImageView) findViewById(R.id.check2);
        if (pesel_str.length() == 11) {

            imageview_pesel.setImageResource(R.drawable.checked);
            try1=1;
        } else {
            imageview_pesel.setImageResource(R.drawable.wrong);
            try1=0;
        }
        if (numer1_str.length() == 6 && numer2_str.length() == 3) {

            imageview_numer.setImageResource(R.drawable.checked);
            try2=1;
        } else {
            imageview_numer.setImageResource(R.drawable.wrong);
            try2=0;
        }
    }
    public void buttonOnClick2(View v) {
        TextView text = (TextView) findViewById(R.id.text_blad);
        if (try1==1 && try2==1){
            startActivity(new Intent(getApplicationContext(), save_screen.class));
        }else{
            text.setText("Popraw dane");
        }
    }


        //Button button =(Button) v;







    }
