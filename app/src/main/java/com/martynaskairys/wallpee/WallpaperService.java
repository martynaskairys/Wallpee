package com.martynaskairys.wallpee;

import android.app.IntentService;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

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

		Set<String> urls = getSavedUrls();

		if (urls == null) {
			return;
		}

		String randomUrl = getRandomUrl(urls);

		WallpaperManager wpm = WallpaperManager.getInstance(context);
		try {

			InputStream ins = new URL(randomUrl).openStream();
			wpm.setStream(ins);

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
		String[] urlsArray = (String[]) urls.toArray();
		return urlsArray[randomNumber];
	}

}
