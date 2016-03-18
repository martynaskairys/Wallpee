package com.martynaskairys.wallpee.networking;

import com.martynaskairys.wallpee.DataTypes.Folder;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * List of server API calls
 */
public interface ApiService {

	@GET ("/folders.json.json")
	void getFolders(Callback<List<Folder>> callback);

}
