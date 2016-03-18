package com.martynaskairys.wallpee.networking;

import com.martynaskairys.wallpee.BuildConfig;

import retrofit.RestAdapter;

/** Prepares Retrofit to be used */
public class RetrofitSetup {

	private static final String BASE_URL = "http://pictex.orgfree.com/";

	/** Returns {@link ApiService} which allows making API calls */
	public ApiService getService() {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(BASE_URL)
				.setLogLevel(getLoggingLevel())
				.build();

		return restAdapter.create(ApiService.class);
	}

	private RestAdapter.LogLevel getLoggingLevel() {

		if (BuildConfig.DEBUG) {
			return RestAdapter.LogLevel.FULL;
		} else {
			return RestAdapter.LogLevel.NONE;
		}
	}

}