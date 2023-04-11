package com.dk.mad_lab.second;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.dk.mad_lab.R;

public class Experiment_2 extends AppCompatActivity {
    private EditText name, mobile ;
    private String Name, Mobile ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment2);

        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = name.getText().toString();
                Mobile = mobile.getText().toString();

                if(Name.isEmpty()){
                    Toast.makeText(Experiment_2.this, "Name is Empty", Toast.LENGTH_SHORT).show();}
                else if (Mobile.isEmpty()) {
                    Toast.makeText(Experiment_2.this, "Mobile is Empty", Toast.LENGTH_SHORT).show();}
                else{
                    Intent intent = new Intent(Experiment_2.this, SecondActivity.class);
                    intent.putExtra("Name",Name);
                    intent.putExtra("Mobile",Mobile);
                    startActivity(intent);}}});
    }
}