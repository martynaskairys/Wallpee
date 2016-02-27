package com.martynaskairys.wallpee;

import android.app.WallpaperManager;
import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RandomlyChangeWallpapers {

    private Links mPictures = new Links();


    public void changeRandomly(Context context)

    {

        WallpaperManager wpm = WallpaperManager.getInstance(context);
        try {

            InputStream ins = new URL(mPictures.getRandomPictureUrl()).openStream();
            wpm.setStream(ins);

        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }
}


