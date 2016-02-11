package com.martynaskairys.wallpee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ExplainingChosenFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaining_chosen_folder);

        TextView textExplainingFolderChoice = (TextView)findViewById(R.id.text_explaining_folder_content);
        textExplainingFolderChoice.setText(R.string.text_explaining_folder_content_a);

       Button buttonF = (Button) findViewById(R.id.button_ok);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ExplainingChosenFolderActivity.this, R.string.leaving_app, Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(Intent.ACTION_MAIN);
               intent.addCategory(Intent.CATEGORY_HOME);
               startActivity(intent);

            }
        });
    }
}
