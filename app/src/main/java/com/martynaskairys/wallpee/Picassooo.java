package com.martynaskairys.wallpee;

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

        Picasso.with(this)
                .load("http://i.kinja-img.com/gawker-media/image/upload/s--hUWAg1eC--/wsgtilb9ibbxysybe3mu.png")
                //.placeholder(R.drawable.ic_placeholder)
                // .error(R.drawable.ic_error_fallback)
                // .resize(250, 200)
                // .rotate(90)
                .into(imageView);

    }
}
