package com.dk.mad_lab.eleventh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.dk.mad_lab.R;

public class Experiment_11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment11);

        EditText to = findViewById(R.id.to);
        EditText subject = findViewById(R.id.subject);
        EditText message = findViewById(R.id.message);
        Button send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String To, Subject, Message ;
                To = to.getText().toString().trim();
                Subject = subject.getText().toString().trim();
                Message = message.getText().toString().trim();

                if(To.isEmpty())
                    Toast.makeText(Experiment_11.this, "To Address not must be Empty.", Toast.LENGTH_LONG).show();
                else{
                    if(Message.isEmpty())
                        Toast.makeText(Experiment_11.this, "Message is not must be Empty.", Toast.LENGTH_LONG).show();
                    else{
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{To});
                        intent.putExtra(Intent.EXTRA_SUBJECT, Subject);
                        intent.putExtra(Intent.EXTRA_TEXT, Message);
                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent, "Choose Mail"));
                        to.setText("");
                        subject.setText("");
                        message.setText("");
                    }
                }
            }
        });
    }
}