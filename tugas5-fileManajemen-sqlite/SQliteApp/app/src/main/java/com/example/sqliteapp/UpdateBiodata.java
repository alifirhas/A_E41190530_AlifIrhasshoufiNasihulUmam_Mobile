package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;
    Button btn1, btn2;
    EditText editText1, editText2, editText3, editText4, editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dataHelper = new DataHelper(this);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);

        SQLiteDatabase db = dataHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama =  '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            editText1.setText(cursor.getString(0).toString());
            editText2.setText(cursor.getString(1).toString());
            editText3.setText(cursor.getString(2).toString());
            editText4.setText(cursor.getString(3).toString());
            editText5.setText(cursor.getString(4).toString());
        }

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dataHelper.getWritableDatabase();
                db.execSQL("UPDATE biodata SET nama = '"+
                        editText2.getText().toString()+"', tgl='"+
                        editText3.getText().toString()+"', jk='"+
                        editText4.getText().toString()+"', alamat='"+
                        editText5.getText().toString()+"' where no='"+
                        editText1.getText().toString()+"'");

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.man.RefereshList();
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}