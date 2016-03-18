package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.martynaskairys.wallpee.utils.Utils;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Checks if user is first time here
        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));
        Intent introIntent = new Intent(MainActivity.this, PagerActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);
        if (isUserFirstTime) {
            startActivity(introIntent);
        }


        setContentView(R.layout.activity_main);

        setupButton();

    }

    private void setupButton() {
        Button button = (Button) findViewById(R.id.button_for_choosing_pic_folders);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ChoosingFolderActivity.class);
                startActivity(intent);
            }
        });
    }
}




