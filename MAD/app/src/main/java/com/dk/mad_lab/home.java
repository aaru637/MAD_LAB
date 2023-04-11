package com.dk.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dk.mad_lab.eigth.Experiment_8;
import com.dk.mad_lab.eleventh.Experiment_11;
import com.dk.mad_lab.fifth.Experiment_5;
import com.dk.mad_lab.first.Experiment_1;
import com.dk.mad_lab.fourth.Experiment_4;
import com.dk.mad_lab.nineth.Experiment_9;
import com.dk.mad_lab.second.Experiment_2;
import com.dk.mad_lab.seventh.Experiment_7;
import com.dk.mad_lab.sixth.Experiment_6;
import com.dk.mad_lab.tenth.Experiment_10;
import com.dk.mad_lab.third.Experiment3;
import com.dk.mad_lab.twelfth.Experiment_12;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView one = findViewById(R.id.one);
        TextView two = findViewById(R.id.two);
        TextView three = findViewById(R.id.three);
        TextView four = findViewById(R.id.four);
        TextView five = findViewById(R.id.five);
        TextView six = findViewById(R.id.six);
        TextView seven = findViewById(R.id.seven);
        TextView eight = findViewById(R.id.eight);
        TextView nine = findViewById(R.id.nine);
        TextView ten = findViewById(R.id.ten);
        TextView eleven = findViewById(R.id.eleven);
        TextView twelve = findViewById(R.id.twelve);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_1.class));
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_2.class));
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment3.class));
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_4.class));
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_5.class));
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_6.class));
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_7.class));
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_8.class));
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_9.class));
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_10.class));
            }
        });

        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_11.class));
            }
        });

        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Experiment_12.class));
            }
        });
    }
}