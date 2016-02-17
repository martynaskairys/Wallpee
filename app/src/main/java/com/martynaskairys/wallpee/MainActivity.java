package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

