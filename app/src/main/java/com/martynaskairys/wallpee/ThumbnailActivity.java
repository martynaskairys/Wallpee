package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

//Shows a list of pictures
public class ThumbnailActivity extends AppCompatActivity {

    //Populates list items
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thumbnail_activity);

        initRecyclerView();

        String[] images = getIntent().getStringArrayExtra("images");
        showList(images);

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

                final String[] images = getIntent().getStringArrayExtra("images");

                Intent intent = new Intent(ThumbnailActivity.this, ExitAppActivity.class);
                intent.putExtra("images", images);

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


    //Shows list of images
    private void showList(String[] imageUrls) {
        adapter.setData(imageUrls);
    }

}



