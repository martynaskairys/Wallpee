package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.martynaskairys.wallpee.DataTypes.Folder;
import com.martynaskairys.wallpee.networking.ApiService;
import com.martynaskairys.wallpee.networking.RetrofitSetup;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Activity for user to choose which folder he/she wants Pictures from
 */
public class ChoosingFolderActivity extends AppCompatActivity {

	private ViewGroup content;
	private ProgressBar progressBar;
	private Button buttonA;
	private Button buttonB;
	private Button buttonC;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choosing_folder);
		findViews();

		fetchImageUrlsAndUpdateUiAccordingly();
	}

	private void findViews() {
		content = (ViewGroup) findViewById(R.id.content);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		buttonA = (Button) findViewById(R.id.button_folder_a);
		buttonB = (Button) findViewById(R.id.button_folder_b);
		buttonC = (Button) findViewById(R.id.button_folder_c);
	}

	private void fetchImageUrlsAndUpdateUiAccordingly() {

		showProgressBarOnly();

		ApiService service = new RetrofitSetup().getService();
		service.getFolders(new Callback<List<Folder>>() {
			@Override
			public void success(List<Folder> folders, Response response) {
				setupButtons(folders);
				showContentOnly();
			}

			@Override
			public void failure(RetrofitError error) {
				showContentOnly();
			}
		});
	}

	private void showContentOnly() {
		content.setVisibility(View.VISIBLE);
		progressBar.setVisibility(View.INVISIBLE);
	}

	private void showProgressBarOnly() {
		content.setVisibility(View.INVISIBLE);
		progressBar.setVisibility(View.VISIBLE);
	}

	private void setupButtons(List<Folder> folders) {

		String[] urlsFolderA = toArray(folders.get(0));
		String[] urlsFolderB = toArray(folders.get(1));
		String[] urlsFolderC = toArray(folders.get(2));

		setupFolderAButton(urlsFolderA);
		setupFolderBButton(urlsFolderB);
		setupFolderCButton(urlsFolderC);
	}

	private String[] toArray(Folder folder) {

		List<String> urlsList = folder.getUrls();

		String[] strings = new String[urlsList.size()];
		for (int i = 0; i < urlsList.size(); i++) {
			strings[i] = urlsList.get(i);
		}

		return strings;
	}

	private void setupFolderAButton(final String[] images) {
		buttonA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String folderA = getString(R.string.text_explaining_folder_content_a);
				Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
				intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderA);
				intent.putExtra("images", images);

				startActivity(intent);
			}
		});
	}

	private void setupFolderBButton(final String[] images) {
		buttonB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String folderB = getString(R.string.text_explaining_folder_content_b);
				Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
				intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderB);
				intent.putExtra("images", images);

				startActivity(intent);

			}
		});
	}

	private void setupFolderCButton(final String[] images) {
		buttonC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String folderC = getString(R.string.text_explaining_folder_content_c);
				Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
				intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderC);
				intent.putExtra("images", images);

				startActivity(intent);
			}
		});
	}

}
