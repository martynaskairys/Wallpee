package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.martynaskairys.wallpee.DataTypes.Folder;
import com.martynaskairys.wallpee.networking.ApiService;
import com.martynaskairys.wallpee.networking.RetrofitSetup;
import com.martynaskairys.wallpee.utils.Utils;

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
    private ViewGroup rootView;
    private RelativeLayout rl;
    private RelativeLayout r2;
    private RelativeLayout r3;


    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Checks if user is first time here
        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(ChoosingFolderActivity.this, PREF_USER_FIRST_TIME, "true"));
        Intent introIntent = new Intent(ChoosingFolderActivity.this, PagerActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);
        if (isUserFirstTime) {
            startActivity(introIntent);
        }

        setContentView(R.layout.activity_choosing_folder);



        findViews();

        fetchImageUrlsAndUpdateUiAccordingly();

    }

    private void findViews() {
        rootView = (ViewGroup) findViewById(R.id.root);
        content = (ViewGroup) findViewById(R.id.content);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
       // buttonA = (Button) findViewById(R.id.button_folder_a);
       // buttonB = (Button) findViewById(R.id.button_folder_b);
       // buttonC = (Button) findViewById(R.id.button_folder_c);

        rl = (RelativeLayout) findViewById(R.id.RL1);
        r2 = (RelativeLayout) findViewById(R.id.RL2);
        r3 = (RelativeLayout) findViewById(R.id.RL3);

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
                showRetryButtonOnly();
            }
        });
    }

    private void showRetryButtonOnly() {
        content.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

        Snackbar.make(rootView, R.string.something_not_right, Snackbar.LENGTH_INDEFINITE).setAction(R.string.retry, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchImageUrlsAndUpdateUiAccordingly();
            }
        }).show();
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


    private void setupFolderAButton(final String[] urlsFolderA) {
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String folderA = getString(R.string.text_explaining_folder_content_a);
                Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
                intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderA);
                intent.putExtra("images", urlsFolderA);
                Bundle bundle = new Bundle();
                bundle.putInt("image", R.drawable.pic1a);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setupFolderBButton(final String[] urlsFolderB) {
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String folderB = getString(R.string.text_explaining_folder_content_b);
                Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
                intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderB);
                intent.putExtra("images", urlsFolderB);

                Bundle bundle = new Bundle();
                bundle.putInt("image", R.drawable.pic1b);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });
    }

    private void setupFolderCButton(final String[] urlsFolderC) {
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String folderC = getString(R.string.text_explaining_folder_content_c);
                Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
                intent.putExtra(ExplainingChosenFolderActivity.EXPLANATION, folderC);
                intent.putExtra("images", urlsFolderC);

                Bundle bundle = new Bundle();
                bundle.putInt("image", R.drawable.pic1c);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

}
