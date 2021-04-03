package com.example.recyview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.view_rv);

        adapter = new MahasiswaAdapter(mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("nama 1", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 2", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 3", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 4", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 5", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 6", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 7", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 8", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 9", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 10", "123", "123"));
        mahasiswaArrayList.add(new Mahasiswa("nama 11", "123", "123"));
    }
}