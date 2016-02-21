package com.martynaskairys.wallpee;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.martynaskairys.wallpee.testing.Alarm;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton();

    }


    private void setupButton() {
        Button button = (Button) findViewById(R.id.button_for_choosing_pic_folders);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, R.string.toast_message_superstar, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, ChoosingFolderActivity.class);
                startActivity(intent);
            }
        });
    }


}




