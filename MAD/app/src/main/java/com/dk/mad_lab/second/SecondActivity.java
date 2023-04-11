package com.dk.mad_lab.second;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.dk.mad_lab.R;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView name = findViewById(R.id.name);
        TextView name1 = findViewById(R.id.name1);
        TextView mobile = findViewById(R.id.mobile);
        Button back = findViewById(R.id.back);

        Intent intent = getIntent();
        String name2 = intent.getStringExtra("Name");
        String mobile1 = intent.getStringExtra("Mobile");
        name.setText(name2);
        name1.setText(name2);
        mobile.setText(mobile1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SecondActivity.this, Experiment_2.class);
                startActivity(intent1);
                finish();}});
    }
}