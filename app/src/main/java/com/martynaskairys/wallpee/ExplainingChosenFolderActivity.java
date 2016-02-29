package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ExplainingChosenFolderActivity extends AppCompatActivity {

    public static final String EXPLANATION = "explanation";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaining_chosen_folder);

        setExplanationText();
        setTakeAPeakAtWallpapersFirstButton();
        setStartChangingWallpapersButton();

    }

    private void setExplanationText() {
        TextView textExplainingFolderChoice = (TextView) findViewById(R.id.text_explaining_folder_content);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            String j = (String) b.get(EXPLANATION);
            textExplainingFolderChoice.setText(j);
        }
    }

    private void setTakeAPeakAtWallpapersFirstButton() {
        Button buttonF = (Button) findViewById(R.id.button_ok);

        final String[] IMAGE_URLS = getIntent().getStringArrayExtra("images");

        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ExplainingChosenFolderActivity.this, ThumbnailActivity.class);
                i.putExtra("images", IMAGE_URLS);
                startActivity(i);

            }
        });
    }

    private void setStartChangingWallpapersButton() {

        final String[] IMAGE_URLS = getIntent().getStringArrayExtra("images");

        findViewById(R.id.buttonSettingContinousWallpaperChange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplainingChosenFolderActivity.this, ExitAppActivity.class);
                intent.putExtra("images", IMAGE_URLS);
                startActivity(intent);
            }
        });

    }

}
