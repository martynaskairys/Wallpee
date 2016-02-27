package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/** Activity for user to choose which folder he/she wants Pictures from */
public class ChoosingFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_folder);

		setupFolderAButton();
		setupFolderBButton();
		setupFolderCButton();
    }

	private void setupFolderAButton() {
		Button buttonA = (Button) findViewById(R.id.button_folder_a);
		buttonA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String folderA = getString(R.string.text_explaining_folder_content_a);
				Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
				intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderA);
				startActivity(intent);
			}
		});
	}

	private void setupFolderBButton() {
		Button buttonB = (Button) findViewById(R.id.button_folder_b);
		buttonB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String folderB = getString(R.string.text_explaining_folder_content_b);
				Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
				intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderB);
				startActivity(intent);
			}
		});
	}

	private void setupFolderCButton() {
		Button buttonC = (Button) findViewById(R.id.button_folder_c);
		buttonC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String folderC = getString(R.string.text_explaining_folder_content_c);
				Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
				intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderC);
				startActivity(intent);
			}
		});
	}

}
