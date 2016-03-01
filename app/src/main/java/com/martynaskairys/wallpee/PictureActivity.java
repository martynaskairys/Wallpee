package com.martynaskairys.wallpee;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

//Shows a large resolution picture for the user to decide whether they want to to use it as a background
public class PictureActivity extends AppCompatActivity {

    public static final String PICTURE = "picture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_activity);

        setPicture();
    }

    private void setPicture() {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        String imageUrl = null;
        if (b != null) {
            imageUrl = (String) b.get(PICTURE);
        }

        Picasso.with(this)
                .load(imageUrl)
                .into(imageView);
    }
}


