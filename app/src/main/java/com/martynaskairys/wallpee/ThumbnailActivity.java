package com.martynaskairys.wallpee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Shows a list of pictures
 */
public class ThumbnailActivity extends AppCompatActivity {

	/** Populates list items */
	private RecyclerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thumbnail_activity);

		initRecyclerView();
		showList(Links.IMAGE_URLS);
	}

	private void initRecyclerView() {
		adapter = new RecyclerAdapter(getApplicationContext());
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
		recyclerView.setAdapter(adapter);
	}

	/** Shows list of images */
	private void showList(String[] imageUrls) {
		adapter.setData(imageUrls);
	}

}
