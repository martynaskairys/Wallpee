package com.martynaskairys.wallpee;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ChoosingRandomPicture extends AppCompatActivity {

    private Links mPictures = new Links();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_random_picture);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        Button button = (Button) findViewById(R.id.buttonChooseRandomPicture);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String picture = mPictures.getRandomPictureUrl();

                Picasso.with(ChoosingRandomPicture.this)

                        .load(picture)
                        .placeholder(R.drawable.mok)
                        // .error(R.drawable.ic_error_fallback)
                        .resize(1250, 1200)
                        // .rotate(90)
                        .into(imageView);



            }
        });
findViewById(R.id.buttonSetRandomWallpaper).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        WallpaperManager wpm = WallpaperManager.getInstance(getApplicationContext());
        try {
            InputStream ins = new URL(mPictures.getRandomPictureUrl()).openStream();
            wpm.setStream(ins);

        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }
});
    }



}
