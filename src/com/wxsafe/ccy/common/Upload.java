package com.wxsafe.ccy.common;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts.upload.FormFile;

public class Upload {

	public static String imageUpload(FormFile file, String folder,
			String fileName, String projectPath) {
		String result = "";
		if (fileName == null) {
			fileName = (new Date()).getTime()
					+ file.getFileName().substring(
							file.getFileName().lastIndexOf("."));
		} else {
			fileName = fileName
					+ file.getFileName().substring(
							file.getFileName().lastIndexOf("."));
		}

		String filePath = folder + fileName;

		String fileAdress = projectPath + filePath;
		InputStream in = null;
		OutputStream out = null;
		try {
			in = file.getInputStream();
			out = new BufferedOutputStream(new FileOutputStream(fileAdress));
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			in.close();
			out.close();
			result = filePath;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
