package com.martynaskairys.wallpee;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;
import com.martynaskairys.wallpee.R;
import com.martynaskairys.wallpee.WallpaperService;

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // For our recurring task, we'll just display a message
        Toast.makeText(context, R.string.do_you_like_your_new_wallpaper, Toast.LENGTH_LONG).show();

        //and let phone vibrate
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);

        //execute wallpaper service (change wallpapers randomly)
        Intent serviceIntent = new Intent(context, WallpaperService.class);
        context.startService(serviceIntent);

    }
}


