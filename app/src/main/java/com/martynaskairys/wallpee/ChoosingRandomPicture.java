package com.martynaskairys.wallpee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ChoosingRandomPicture extends AppCompatActivity {

    private Links mPictures = new Links();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_random_picture);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        Button button = (Button)findViewById(R.id.buttonChooseRandomPicture);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String picture = mPictures.getPicture();

                Picasso.with(ChoosingRandomPicture.this)

                        .load(picture)
                        .placeholder(R.drawable.mok)
                        // .error(R.drawable.ic_error_fallback)
                         .resize(1250, 1200)
                        // .rotate(90)
                        .into(imageView);


            }
        });



    }
}
