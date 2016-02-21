package com.martynaskairys.wallpee;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ExplainingChosenFolderActivity extends AppCompatActivity {

	public static final String EXPLANATION = "explanation";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaining_chosen_folder);

		setExplanation();
		setConfirmationButton();

		findViewById(R.id.buttonSettingContinousWallpaperChange).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ExplainingChosenFolderActivity.this, ExitAppActivity.class);
						startActivity(intent);
			}
		});
    }

	private void setConfirmationButton() {
		Button buttonF = (Button) findViewById(R.id.button_ok);
		buttonF.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ExplainingChosenFolderActivity.this, ThumbnailActivity.class);
				startActivity(intent);

			}
		});
	}

	private void setExplanation() {
		TextView textExplainingFolderChoice = (TextView) findViewById(R.id.text_explaining_folder_content);

		Intent intent = getIntent();
		Bundle b = intent.getExtras();

		if (b != null) {
			String j = (String) b.get(EXPLANATION);
			textExplainingFolderChoice.setText(j);
		}
	}
}
