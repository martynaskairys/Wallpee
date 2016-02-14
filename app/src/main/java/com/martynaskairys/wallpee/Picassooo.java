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

public class Picassooo extends AppCompatActivity {

    String url = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picassooo);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            url = (String) b.get("picture");
        }

        Picasso.with(this)

                .load(url)
                //.placeholder(R.drawable.ic_placeholder)
                // .error(R.drawable.ic_error_fallback)
                // .resize(250, 200)
                // .rotate(90)
                .into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Create an actionbar menu
        menu.add("Set as Wallpaper")
                // Add a new Menu Button
                .setOnMenuItemClickListener(this.SetWallpaperClickListener)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    // Capture actionbar menu item click
    OnMenuItemClickListener SetWallpaperClickListener = new OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem item) {

            WallpaperManager wpm = WallpaperManager.getInstance(Picassooo.this);
            try {
                InputStream ins = new URL(url).openStream();
                wpm.setStream(ins);

                //instead of stream (2 lines above) you can set 1 wallpaper image from drawable;
                //myWallpaperManager.setResource(+R.drawable.wallpaper_nexus5);

                // Show a toast message on successful change
                Toast.makeText(Picassooo.this,
                        "Wallpaper successfully changed", Toast.LENGTH_SHORT)
                        .show();

            } catch (IOException e) {
                // TODO Auto-generated catch block
            }

            return false;
        }
    };


}


