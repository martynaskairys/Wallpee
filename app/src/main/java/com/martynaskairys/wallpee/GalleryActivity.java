package com.martynaskairys.wallpee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        Button buttonA = (Button) findViewById(R.id.buttonFolderA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GalleryActivity.this, "Yoooho", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GalleryActivity.this, FolderAActivity.class);
                startActivity(intent);
            }
        });

        Button buttonB = (Button) findViewById(R.id.buttonFolderB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GalleryActivity.this, "Yoooho", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GalleryActivity.this, FolderBActivity.class);
                startActivity(intent);
            }
        });

    }
}
