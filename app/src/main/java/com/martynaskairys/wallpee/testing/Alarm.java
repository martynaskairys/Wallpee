package com.martynaskairys.wallpee.testing;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.martynaskairys.wallpee.ExitAppActivity;
import com.martynaskairys.wallpee.MainActivity;
import com.martynaskairys.wallpee.R;
import com.martynaskairys.wallpee.RandomlyChangeWallpapers;
import com.martynaskairys.wallpee.WallpaperService;

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        // For our recurring task, we'll just display a message
        Toast.makeText(context, "I'm running and... what am I suppose to do now? ", Toast.LENGTH_LONG).show();

        //and let phone vibrate
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);


        Intent serviceIntent = new Intent (context, WallpaperService.class);
        context.startService(serviceIntent);



       // RandomlyChangeWallpapers rcw = new RandomlyChangeWallpapers();
        //rcw.changeRandomly(context);

        // PendingIntent.getActivity (null,2 , null, 4,null);
/*
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.w("MY_DEBUG_TAG", state);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNumber = extras
                        .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.w("MY_DEBUG_TAG", phoneNumber);
            }



        }


        if (extras != null) {
            if(extras!=null){
                if(extras.containsKey("value")){

                    System.out.println("Value is: "+extras.get("value"));
                }
            }



        }
        */
    }
}


