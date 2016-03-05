package com.martynaskairys.wallpee.networking;

import android.database.Observable;

import com.martynaskairys.wallpee.DataTypes.FoldersResponse;

import retrofit.http.GET;

/**
 * List of server API calls
 */
public interface ApiService {

	@GET ("/s/nscp7b6qiuguearszwefw7hvtmkt29aj")
	Observable<FoldersResponse> getFolders();

}
