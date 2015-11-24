package com.wxsafe.ccy.common;

import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import com.wxsafe.ccy.config.StrConfig;
import com.wxsafe.ccy.dao.DataSourseFactory;
import com.wxsafe.ccy.method.CommonMetheds;

public class FileDeleteTask extends TimerTask {

	private String projectPath;

	public FileDeleteTask(String projectPath) {

		this.projectPath = projectPath;
	}

	public void run() {
		Date now = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(now);
		// System.out.println("当前时间：" + gc.get(Calendar.HOUR_OF_DAY));
		if (0 == gc.get(Calendar.HOUR_OF_DAY)
				|| 12 == gc.get(Calendar.HOUR_OF_DAY)) {
			Connection conn = null;
			// System.out.println("进入了删除");
			try {
				conn = DataSourseFactory.getDataSource().getConnection();
				CommonMetheds cm = new CommonMetheds(conn);
				String[] filePaths = cm.selectAllUploadFile();
				conn.close();
				String upload_path = projectPath + StrConfig.UPLOAD_FILE;
				// System.out.println(upload_path);

				File upload = new File(upload_path);
				if (upload.isDirectory()) {
					File[] files = upload.listFiles();
					List<String> fileList = new ArrayList<String>();
					for (int i = 0; i < files.length; i++) {
						fileList
								.add(StrConfig.UPLOAD_FILE + files[i].getName());
						// System.out.println(StrConfig.UPLOAD_FILE
						// + files[i].getName());
					}

					for (int i = 0; i < filePaths.length; i++) {
						while (fileList.contains(filePaths[i])) {
							// System.out.println(filePaths[i]);
							fileList.remove(filePaths[i]);
						}
					}

					fileList.remove(StrConfig.UPLOAD_FILE + "Thumbs.db");
					fileList.remove(StrConfig.UPLOAD_FILE + "nonePic.JPG");

					Iterator<String> ir = fileList.iterator();
					while (ir.hasNext()) {

						File file = new File(projectPath + ir.next());
						if (file.isFile()) {
							// System.out.println(file.getAbsolutePath() +
							// "/n删除");
							file.delete();

						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("结束");
		}
	}
}
