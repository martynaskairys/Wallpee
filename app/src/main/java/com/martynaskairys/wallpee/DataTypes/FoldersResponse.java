package com.martynaskairys.wallpee.DataTypes;

import java.util.List;

/**
 * Raw response received for folders data
 */
public class FoldersResponse {

	final List<Folder> folders;

	public FoldersResponse(List<Folder> folders) {
		this.folders = folders;
	}

	public List<Folder> getFolders() {
		return folders;
	}
}
