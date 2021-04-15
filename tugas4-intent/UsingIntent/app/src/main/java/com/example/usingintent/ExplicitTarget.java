package com.example.usingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ExplicitTarget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_target);

        Intent intent = getIntent();
        String text = intent.getStringExtra(ExplicitIntent.EXTRA_TEXT);
        int number = intent.getIntExtra(ExplicitIntent.EXTRA_NUMBER, 0);

        TextView textView1 = (TextView) findViewById(R.id.textView2);
        TextView textView2 = (TextView) findViewById(R.id.textView3);

        textView1.setText(text);
        textView2.setText(""+number);
    }
}