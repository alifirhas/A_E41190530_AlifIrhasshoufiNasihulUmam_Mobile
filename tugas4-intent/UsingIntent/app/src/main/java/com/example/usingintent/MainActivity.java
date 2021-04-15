package com.example.usingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnImplicit, btnExplicit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImplicit = findViewById(R.id.btnImplicit);
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImplicit();
            }
        });

        btnExplicit = findViewById(R.id.btnExplicit);
        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExplicit();
            }
        });
    }

    public void openImplicit(){
        Intent intent = new Intent(this, ImplicitIntent.class);
        startActivity(intent);
    }

    public void openExplicit(){
        Intent intent = new Intent(this, ExplicitIntent.class);
        startActivity(intent);
    }
}