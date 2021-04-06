package com.example.fragmenting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnFragOne, btnFragTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragOne = (Button) findViewById(R.id.button);
        btnFragTwo = (Button) findViewById(R.id.button2);

        openFragmentTwo();

        btnFragOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragmentOne();
            }
        });
        btnFragTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragmentTwo();
            }
        });
    }

    public void openFragmentOne(){
        //mulai transaksi fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ganti kontent fragment di main layout
        ft.replace(R.id.fragment_placeholder, new FragmentOne());
        //selesai
        ft.commit();
    }
    public void openFragmentTwo(){
        //mulai transaksi fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ganti kontent fragment di main layout
        ft.replace(R.id.fragment_placeholder, new FragmentTwo());
        //selesai
        ft.commit();
    }

}