package com.example.layouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_linear, btn_relative, btn_constraint, btn_frame, btn_table, btn_material, btn_scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_linear = (Button) findViewById(R.id.btn_linear);
        btn_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinearLayout();
            }
        });

        Button btn_relative = (Button) findViewById(R.id.btn_relative);
        btn_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRelativeLayout();
            }
        });

        Button btn_constraint = (Button) findViewById(R.id.btn_constraint);
        btn_constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConstraintLayout();
            }
        });

        Button btn_frame = (Button) findViewById(R.id.btn_frame);
        btn_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFrameLayout();
            }
        });

        Button btn_table = (Button) findViewById(R.id.btn_table);
        btn_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTableLayout();
            }
        });

        Button btn_material = (Button) findViewById(R.id.btn_material);
        btn_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaterialDesign();
            }
        });

        Button btn_scroll = (Button) findViewById(R.id.btn_scrool);
        btn_scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScrollView();
            }
        });
    }

    public void openLinearLayout(){
        Intent intent;
        intent = new Intent(this, LayoutLinear.class);
        startActivity(intent);
    }

    public void openRelativeLayout(){
        Intent intent;
        intent = new Intent(this, LayoutRelative.class);
        startActivity(intent);
    }

    public void openConstraintLayout(){
        Intent intent;
        intent = new Intent(this, LayoutConstraint.class);
        startActivity(intent);
    }

    public void openFrameLayout(){
        Intent intent;
        intent = new Intent(this, LayoutFrame.class);
        startActivity(intent);
    }

    public  void openTableLayout(){
        Intent intent;
        intent = new Intent(this, LayoutTable.class);
        startActivity(intent);
    }

    public  void openMaterialDesign(){
        Intent intent;
        intent = new Intent(this, MaterialDesign.class);
        startActivity(intent);
    }

    public  void openScrollView(){
        Intent intent;
        intent = new Intent(this, ScrollView.class);
        startActivity(intent);
    }
}