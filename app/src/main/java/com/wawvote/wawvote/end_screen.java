package com.wawvote.wawvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class end_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
    }
    public void wynikiOnClick(View v) {

            startActivity(new Intent(getApplicationContext(), Wyniki.class));

    }
}
