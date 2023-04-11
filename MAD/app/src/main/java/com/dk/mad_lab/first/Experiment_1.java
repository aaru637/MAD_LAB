package com.dk.mad_lab.first;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dk.mad_lab.R;

public class Experiment_1 extends AppCompatActivity {
    private TextView name, textsize;
    private int size = 10, ch = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.name);
        Button increasefontsize = findViewById(R.id.increasefontsize);
        Button decreasefontsize = findViewById(R.id.decreasefontsize);
        Button changecolor = findViewById(R.id.changecolor);
        Button previouscolor = findViewById(R.id.previouscolor);
        textsize = findViewById(R.id.size);

        increasefontsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size++;
                name.setTextSize(size);
                textsize.setText("Size : " + size);
                if (size == 40){
                    size = 10;
                }}});

        decreasefontsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(size <= 10){
                    size = 10;
                    Toast.makeText(Experiment_1.this, "You reached the minimum Text Size", Toast.LENGTH_SHORT).show();}
                else{
                    size--;
                    name.setTextSize(size);
                    textsize.setText("Size : " + size);
                }}});

        changecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {ch++;
                switch (ch){
                    case 1:
                        name.setTextColor(Color.BLUE);
                        break;
                    case 2:
                        name.setTextColor(Color.RED);
                        break;
                    case 3:
                        name.setTextColor(Color.GRAY);
                        break;
                    case 4:
                        name.setTextColor(Color.GREEN);
                        break;
                    case 5:
                        name.setTextColor(Color.YELLOW);
                        break;
                    case 6:
                        name.setTextColor(Color.BLACK);
                        break;}
                if(ch > 6){
                    ch = 1;
                    name.setTextColor(Color.BLUE);
                }}});

        previouscolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {ch--;
                switch (ch){
                    case 1:
                        name.setTextColor(Color.BLUE);
                        break;
                    case 2:
                        name.setTextColor(Color.RED);
                        break;
                    case 3:
                        name.setTextColor(Color.GRAY);
                        break;
                    case 4:
                        name.setTextColor(Color.GREEN);
                        break;
                    case 5:
                        name.setTextColor(Color.YELLOW);
                        break;}
                if(ch < 1){
                    ch = 6;
                    name.setTextColor(Color.BLACK);}}});
    }
}