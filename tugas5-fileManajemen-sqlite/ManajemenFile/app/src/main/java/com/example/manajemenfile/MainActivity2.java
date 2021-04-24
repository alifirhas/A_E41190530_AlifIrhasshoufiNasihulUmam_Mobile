package com.example.manajemenfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class MainActivity2 extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE = 23;
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showText = (TextView) findViewById(R.id.textView);
    }

    public void back(){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);;
        startActivity(intent);
    }

    public void getPublic(View view){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File myFile = new File(folder, "myPublicData.txt");
        String text = getData(myFile);
        if (text != null){
            showText.setText(text);
        } else{
            showText.setText("No Data");
        }
    }

    public void getPrivate(View view){
        File folder = getExternalFilesDir("privateFile");
        File myFile = new File(folder, "myPrivateData.txt");
        String text = getData(myFile);
        if (text != null){
            showText.setText(text);
        } else{
            showText.setText("No Data");
        }
    }

    public String getData(File myFile){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myFile);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1 ){
                buffer.append((char) i);
            }
            return buffer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}