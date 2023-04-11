package com.dk.mad_lab.fifth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.dk.mad_lab.R;

public class Experiment_5 extends AppCompatActivity {

    private static final String CHANNEL_ID = "Notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment5);

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "MAD LAB EXPERIMENTS", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        EditText title = findViewById(R.id.title);
        EditText desc = findViewById(R.id.description);
        Button btn = findViewById(R.id.notification);
        CheckBox check = findViewById(R.id.check);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleText = title.getText().toString().trim();
                String descText = desc.getText().toString().trim();
                if(titleText.isEmpty() || descText.isEmpty())
                    Toast.makeText(Experiment_5.this, "Please Fill all fields.", Toast.LENGTH_SHORT).show();

                else if(descText.length() > 20)
                    showNotification(titleText, descText, check.isChecked(), true);

                else
                    showNotification(titleText, descText, check.isChecked(), false);
            }});
    }

    private void showNotification(String title, String desc, boolean isImage, boolean isBigText){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.india);
        NotificationCompat.Builder builder = new NotificationCompat
                .Builder(Experiment_5.this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(desc)
                .setSmallIcon(R.drawable.logo)
                .setLargeIcon(bitmap)
                .setAutoCancel(true);
        builder.setStyle(isImage ? (new NotificationCompat.BigPictureStyle().bigPicture(bitmap)) : null);
        builder.setStyle(isBigText ? (new NotificationCompat.BigTextStyle().bigText(desc)) : null);

        NotificationManagerCompat compat = NotificationManagerCompat.from(Experiment_5.this);
        compat.notify(1, builder.build());
    }

}