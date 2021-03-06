package com.martynaskairys.wallpee;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // For our recurring task, we'll just display a message
        Toast.makeText(context, R.string.do_you_like_your_new_wallpaper, Toast.LENGTH_LONG).show();

        //execute wallpaper service (change wallpapers randomly)
        Intent serviceIntent = new Intent(context, WallpaperService.class);
        context.startService(serviceIntent);

    }
}


