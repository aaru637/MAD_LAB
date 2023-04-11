package com.dk.mad_lab.nineth;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.dk.mad_lab.R;

public class Experiment_9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment9);

        EditText title = findViewById(R.id.title);
        EditText desc = findViewById(R.id.description);
        Button btn = findViewById(R.id.notification);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleText = title.getText().toString().trim();
                String descText = desc.getText().toString().trim();
                if(titleText.isEmpty() || descText.isEmpty()){
                    Toast.makeText(Experiment_9.this, "Please Fill all fields.", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(Experiment_9.this, Message_View.class);
                    intent.putExtra("Title", titleText);
                    intent.putExtra("Desc", descText);
                    startActivity(intent);
                }
            }
        });
    }
}