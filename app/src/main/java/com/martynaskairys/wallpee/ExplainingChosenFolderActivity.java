package com.martynaskairys.wallpee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExplainingChosenFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaining_chosen_folder);

        TextView textExplainingFolderChoice = (TextView) findViewById(R.id.text_explaining_folder_content);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            String j = (String) b.get("folderContentExplaining");
            textExplainingFolderChoice.setText(j);
        }


        Button buttonF = (Button) findViewById(R.id.button_ok);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExplainingChosenFolderActivity.this, ThumbnailActivity.class);
                startActivity(intent);

            }
        });
    }
}
