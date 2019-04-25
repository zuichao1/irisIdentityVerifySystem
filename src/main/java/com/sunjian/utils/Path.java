package com.sunjian.utils;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class Path {

	public static String deskTop() {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com = fsv.getHomeDirectory().getAbsoluteFile();
		String path = com.toString().replaceAll("\\\\", "/") + "/";
		
		return path;
	}
}
