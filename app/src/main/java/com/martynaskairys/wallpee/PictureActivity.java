package com.martynaskairys.wallpee;


import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.MenuItem.OnMenuItemClickListener;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/** Shows a large resolution picture for the user to decide whether they want to to use it as a background */
public class PictureActivity extends AppCompatActivity {

	public static final String PICTURE = "picture";
	private String imageUrl;


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

		imageUrl = null;
		if (b != null) {
			imageUrl = (String) b.get(PICTURE);
		}

		Picasso.with(this)
				.load(imageUrl)
				.into(imageView);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(R.string.set_wallpaper)
                .setOnMenuItemClickListener(this.setWallpaperClickListener)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);

    }

    private OnMenuItemClickListener setWallpaperClickListener = new OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem item) {

            WallpaperManager wpm = WallpaperManager.getInstance(PictureActivity.this);
            try {
                InputStream ins = new URL(imageUrl).openStream();
                wpm.setStream(ins);

                Toast.makeText(PictureActivity.this, R.string.wallpaper_changed, Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                // TODO Auto-generated catch block
            }

            return true;
        }
    };



}


