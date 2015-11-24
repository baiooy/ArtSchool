package com.wxsafe.ccy.common;

import java.io.File;

public class FileDelete {

	public static boolean delelteFile(String filePath) {
		boolean result = false;
		File file = new File(filePath);
		if (file.isFile()) {
			file.delete();
			result = true;
		}
		return result;
	}
}
