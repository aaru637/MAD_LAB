package com.dk.mad_lab.sixth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.dk.mad_lab.R;

public class Experiment_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment6);

        ImageView image = findViewById(R.id.image);
        Button india = findViewById(R.id.india);
        Button tamilnadu = findViewById(R.id.tamilnadu);

        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                            image.post(new Runnable() {
                                @Override
                                public void run() {
                                    image.setImageResource(R.drawable.india);
                                }
                            });
                    }
                }).start();
            }
        });

        tamilnadu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        image.post(new Runnable() {
                            @Override
                            public void run() {
                                image.setImageResource(R.drawable.tamilnadu);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}