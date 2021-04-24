package com.example.manajemenfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    private int STORAGE_PERMISSION_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editTextText);
    }
    public void next(View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    public void savePublic(View view){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        String info = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File myFile = new File(folder, "myPublicData.txt");
        writeData(myFile, info);
        editText.setText("");

    }

    public void savePrivate(View view){
        String info = editText.getText().toString();
        File folder = getExternalFilesDir("privateFile");
        File myFile = new File(folder, "myPrivateData.txt");
        writeData(myFile, info);
        editText.setText("");

    }

    public void writeData(File myFile, String data){
        FileOutputStream fileOutputStream = null;

        try {
            System.out.println("TES");
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this, "Done" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "There is some thing wrong catch 1", Toast.LENGTH_SHORT).show();
        }finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                    Toast.makeText(this, "There is some thing wrong catch 2", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}