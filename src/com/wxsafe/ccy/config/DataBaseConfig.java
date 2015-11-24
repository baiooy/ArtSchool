package com.wxsafe.ccy.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataBaseConfig {

	private static DataBaseConfig rc = new DataBaseConfig();

	private DataBaseConfig() {
	}

	public static DataBaseConfig getInstance() {
		return rc;
	}

	private static final String config_file = "./database.properties";
	private Properties pro = null;
	private InputStream in = null;
	private FileOutputStream out = null;
	public String driver_name = "";
	public String url = "";
	public String user = "";
	public String password = "";

	public void getDateConfig() {
		pro = new Properties();
		try {
			in = this.getClass().getResourceAsStream(config_file);
			pro.load(in);
			driver_name = pro.getProperty("driver_name");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pro.clear();
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getPorperty(String key) {
		String value = "";
		pro = new Properties();
		try {
			in = this.getClass().getResourceAsStream(config_file);
			pro.load(in);
			value = pro.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pro.clear();
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}

	public boolean updateConfig(String key, String value) {

		boolean result = false;
		pro = new Properties();
		try {
			in = this.getClass().getResourceAsStream(config_file);
			pro.load(in);
			pro.put(key, value);
			String path = this.getClass().getResource(config_file).getPath();
			System.out.println(path);
			out = new FileOutputStream(path);
			pro.store(out, null);
			out.flush();
			result = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
}
