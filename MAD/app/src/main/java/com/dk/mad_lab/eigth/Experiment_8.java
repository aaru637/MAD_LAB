package com.dk.mad_lab.eigth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.dk.mad_lab.R;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Experiment_8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment8);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, PackageManager.PERMISSION_GRANTED);

        Button write = findViewById(R.id.write);
        Button read = findViewById(R.id.read);
        EditText fileName = findViewById(R.id.fileName);
        EditText content = findViewById(R.id.data);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = content.getText().toString().trim();
                String name = fileName.getText().toString().trim();
                if(name.isEmpty()) {
                    Toast.makeText(Experiment_8.this, "File Name not must be Empty.", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (data.isEmpty())
                        Toast.makeText(Experiment_8.this, "Content not must be Empty.", Toast.LENGTH_LONG).show();
                    else
                        writeData(name, data, content);
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fileName.getText().toString().trim();
                if(name.isEmpty())
                    Toast.makeText(Experiment_8.this, "File Name not must be Empty.", Toast.LENGTH_SHORT).show();
                else
                    readData(name, content);
            }
        });
    }

    private void readData(String name, EditText content) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        path += "/Download/".concat(name.concat(".txt"));
        try{
            String data = "";
            FileInputStream fileIn = new FileInputStream(path);
            int i = -1;
            while((i = fileIn.read()) != -1){
                data += (char)i;
            }
            content.setText(data);
            fileIn.close();
        }
        catch (Exception e){
            Toast.makeText(this, "File Not Found.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void writeData(String fileName, String data, EditText content){
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        path += "/Download/".concat(fileName.concat(".txt"));
        try{
            FileOutputStream fileOut = new FileOutputStream(path);
            fileOut.write(data.getBytes());
            fileOut.close();
            Toast.makeText(this, "File Writed Successfully on ".concat(path), Toast.LENGTH_LONG).show();
            content.setText("");
            fileOut.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}