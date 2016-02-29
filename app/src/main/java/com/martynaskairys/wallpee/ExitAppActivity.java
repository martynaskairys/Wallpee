package com.martynaskairys.wallpee;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


public class ExitAppActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_app);

        getRandomPictureUrl();

         /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(ExitAppActivity.this, Alarm.class);
        pendingIntent = PendingIntent.getBroadcast(ExitAppActivity.this, 0, alarmIntent, 0);

        SetWallpapersToWork();

        findViewById(R.id.buttonExitApp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(ExitAppActivity.this, "Have a nice day", Toast.LENGTH_LONG).show();
            }
        });

    }

    public String getRandomPictureUrl() {

        String[] IMAGE_URLS = getIntent().getStringArrayExtra("images");

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(IMAGE_URLS.length);

        return IMAGE_URLS[randomNumber];
    }

    public void SetWallpapersToWork() {

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 60000; // minimum value (at least 1 minute repeating time. Android system forces that)
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);

        Intent intent = new Intent();
        intent.setAction("Alarm");
        sendBroadcast(intent);

    }

}



