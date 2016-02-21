package com.martynaskairys.wallpee;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Shows a list of pictures
 */
public class ThumbnailActivity extends AppCompatActivity {

    /**
     * Populates list items
     */
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thumbnail_activity);

        initRecyclerView();
        showList(Links.IMAGE_URLS);

        findViewById(R.id.buttonChooseNewFolder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThumbnailActivity.this, ChoosingFolderActivity.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.buttonDoIt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThumbnailActivity.this, ExitAppActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initRecyclerView() {
        adapter = new RecyclerAdapter(getApplicationContext());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    /**
     * Shows list of images
     */
    private void showList(String[] imageUrls) {
        adapter.setData(imageUrls);
    }

}



