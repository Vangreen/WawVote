package com.wawvote.wawvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class save_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_screen);
    }
    public void buttonOnClick_kandydaci(View v) {
        //Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(), kandydaci.class));

    }
}
