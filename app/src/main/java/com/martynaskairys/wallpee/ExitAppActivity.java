package com.martynaskairys.wallpee;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class ExitAppActivity extends AppCompatActivity {

	public static final String CHOSEN_FOLDER_URLS = "chosen_folder_urls";
	public static final String STANDARD = "standard";
	private PendingIntent pendingIntent;
	private String[] imageUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_app);

        saveUrls();
        getRandomPictureUrl();
        setWallpapersToWork();

         /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(ExitAppActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(ExitAppActivity.this, 0, alarmIntent, 0);


        findViewById(R.id.buttonExitApp).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				Toast.makeText(ExitAppActivity.this, R.string.exit_app_button_message, Toast.LENGTH_LONG).show();
			}
		});

	}

	private void saveUrls() {
		Set<String> urlsSet = new HashSet<>();
		Collections.addAll(urlsSet, imageUrls);

		SharedPreferences preferences = getSharedPreferences(STANDARD, Context.MODE_PRIVATE);
		SharedPreferences.Editor edit = preferences.edit();
		edit.putStringSet(CHOSEN_FOLDER_URLS, urlsSet);
		edit.commit();
	}

	public String getRandomPictureUrl() {

        imageUrls = getIntent().getStringArrayExtra("images");
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(imageUrls.length);
        return imageUrls[randomNumber];
    }

    public void setWallpapersToWork() {

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 60000; // minimum value (at least 1 minute repeating time. Android system forces that)
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);

        Intent intent = new Intent();
        intent.setAction("AlarmReceiver");
        sendBroadcast(intent);

    }

}



