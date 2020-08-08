package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;


    private static final String CHANEL_ID = "Chanell_id";
    private static final String CHANEL_NAME= "Chanell_name";
    private static final String CHANEL_DES = "Chanell_des";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.b1);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel creatChannel = new NotificationChannel(CHANEL_ID,CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            creatChannel.setDescription(CHANEL_DES);

            NotificationManager NoManager = getSystemService(NotificationManager.class);
            NoManager.createNotificationChannel(creatChannel);

        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this,CHANEL_ID);
                notificationBuilder.setContentTitle("Message")
                                   .setContentText("Hello thupten ")
                                   .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                                   .setSmallIcon(R.drawable.ic_launcher_foreground);

                NotificationManagerCompat notficationManager = NotificationManagerCompat.from(MainActivity.this);
                                         notficationManager.notify(1,notificationBuilder.build());


            }
        });

    }



}