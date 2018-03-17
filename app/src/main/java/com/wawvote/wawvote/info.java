package com.wawvote.wawvote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            txtInfo.setText(info);
        }

        TextView nazwa = (TextView)findViewById(R.id.nazwa);
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("nazwa");
            nazwa.setText(info);
        }


    }
}
