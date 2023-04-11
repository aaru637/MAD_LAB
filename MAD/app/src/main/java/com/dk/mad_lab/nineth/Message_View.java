package com.dk.mad_lab.nineth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.dk.mad_lab.R;

public class Message_View extends AppCompatActivity {

    private static final String CHANNEL_ID = "Notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_view);

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "MAD LAB EXPERIMENTS", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String desc = intent.getStringExtra("Desc");
        Toast.makeText(this, "Title : "+title+" Description : " + desc, Toast.LENGTH_LONG).show();
        showNotification(title, desc);
    }

    private void showNotification(String title, String desc){
        NotificationCompat.Builder builder = new NotificationCompat
                .Builder(Message_View.this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(desc)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(desc))
                .setSmallIcon(R.drawable.logo)
                .setAutoCancel(true);

        NotificationManagerCompat compat = NotificationManagerCompat.from(Message_View.this);
        compat.notify(1, builder.build());
    }

}