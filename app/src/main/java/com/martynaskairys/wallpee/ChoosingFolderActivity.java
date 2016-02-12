package com.martynaskairys.wallpee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChoosingFolderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_folder);


        Button buttonA = (Button) findViewById(R.id.button_folder_a);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(ChoosingFolderActivity.this, R.string.yoo_message_a_folder, Toast.LENGTH_SHORT).show();

                String folderA = getString(R.string.text_explaining_folder_content_a);
                Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
                intent.putExtra("folderContentExplaining", folderA);
                startActivity(intent);

            }
        });

        Button buttonB = (Button) findViewById(R.id.button_folder_b);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(ChoosingFolderActivity.this, R.string.yoo_message_b_folder, Toast.LENGTH_SHORT).show();

                String folderB = getString(R.string.text_explaining_folder_content_b);
                Intent intent = new Intent(ChoosingFolderActivity.this, ExplainingChosenFolderActivity.class);
                intent.putExtra("folderContentExplaining", folderB);
                startActivity(intent);

            }
        });

    }

}
