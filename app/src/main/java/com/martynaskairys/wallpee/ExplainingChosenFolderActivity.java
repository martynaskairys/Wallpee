package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ExplainingChosenFolderActivity extends AppCompatActivity {

    public static final String EXPLANATION = "explanation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaining_chosen_folder);

        setPicture();
        setExplanationText();
        setTakeAPeakAtWallpapersFirstButton();

    }

    private void setPicture() {

        ImageView v = (ImageView) findViewById(R.id.imageView2);
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("image");
        v.setImageResource(pic);

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

        final String[] IMAGES = getIntent().getStringArrayExtra("images");

        findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplainingChosenFolderActivity.this, ThumbnailActivity.class);
                intent.putExtra("images", IMAGES);
                startActivity(intent);

            }
        });
    }
}
