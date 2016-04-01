package com.martynaskairys.wallpee;

import android.app.IntentService;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.Set;


public class WallpaperService extends IntentService {

    public static final String STANDARD = "standard";

    public WallpaperService() {
        super("martynas_notification_service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        changeRandomly(this);
    }


    public void changeRandomly(Context context) {


            DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
            int height = metrics.heightPixels;
            int width = metrics.widthPixels;


        Set<String> urls = getSavedUrls();

        if (urls == null) {
            return;
        }

        String randomUrl = getRandomUrl(urls);

        try {

            InputStream ins = new URL(randomUrl).openStream();

            Bitmap tempbitMap = BitmapFactory.decodeStream(ins);
            Bitmap bitmap = Bitmap.createScaledBitmap(tempbitMap, width, height, true);

            WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
            wallpaperManager.setWallpaperOffsetSteps(1, 1);
            wallpaperManager.suggestDesiredDimensions(width, height);
            wallpaperManager.setBitmap(bitmap);

        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }

    private Set<String> getSavedUrls() {
        SharedPreferences preferences = getSharedPreferences(STANDARD, Context.MODE_PRIVATE);
        return preferences.getStringSet(ExitAppActivity.CHOSEN_FOLDER_URLS, null);
    }

    private String getRandomUrl(Set<String> urls) {
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(urls.size());
        return (String) urls.toArray()[randomNumber];
    }
}
