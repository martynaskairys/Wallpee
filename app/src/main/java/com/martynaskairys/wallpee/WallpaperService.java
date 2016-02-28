package com.martynaskairys.wallpee;

import android.app.IntentService;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class WallpaperService extends IntentService {

    private Links mPictures = new Links();

    public WallpaperService() {
        super("martynas_notification_service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        changeRandomly(this);
    }

    public void changeRandomly(Context context)

    {

        WallpaperManager wpm = WallpaperManager.getInstance(context);
        try {

            InputStream ins = new URL(mPictures.getRandomPictureUrlA()).openStream();
            wpm.setStream(ins);

        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }
}
