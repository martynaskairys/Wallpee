package com.martynaskairys.wallpee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Picassooo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picassooo);


        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String url = null;

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
}
