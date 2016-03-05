package com.martynaskairys.wallpee.networking;

import com.martynaskairys.wallpee.DataTypes.FoldersResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * List of server API calls
 */
public interface ApiService {

	@GET ("/document/d/16hS5yqkQTvvhrvRqHcSs9YdpCnilIoJH3F5kQMR2HYY/edit?usp=sharing")
	void getFolders(Callback<FoldersResponse> callback);

}
