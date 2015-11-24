package com.wxsafe.ccy.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetConfig {

	public GetConfig(String projectPath) {
		this.config_file = projectPath + "/config.properties";
	}

	private String config_file = "";
	private Properties pro = null;
	private FileInputStream in = null;
	private FileOutputStream out = null;

	public String big_adver_1 = "";
	public String big_adver_2 = "";
	public String big_adver_3 = "";
	public String big_adver_4 = "";
	public String small_adver_1 = "";
	public String small_adver_2 = "";
	public String small_adver_3 = "";
	public String small_adver_4 = "";
	public String small_adver_5 = "";
	public String small_adver_6 = "";
	public String small_adver_7 = "";
	public String small_adver_8 = "";

	public String big_pic_1 = "";
	public String big_pic_2 = "";
	public String big_pic_3 = "";
	public String big_pic_4 = "";
	public String small_pic_1 = "";
	public String small_pic_2 = "";
	public String small_pic_3 = "";
	public String small_pic_4 = "";
	public String small_pic_5 = "";
	public String small_pic_6 = "";
	public String small_pic_7 = "";
	public String small_pic_8 = "";

	public String wood = "";
	public String stone = "";
	public String ceramics = "";
	public String glass = "";
	public String plastic = "";
	public String carpet = "";
	public String paint = "";
	public String wallpaper = "";
	public String metal = "";
	public String gypsum = "";
	public String hydropower = "";
	public String other = "";

	public String logo = "";

	public String email = "";

	public void getTopConfig() {
		pro = new Properties();
		try {
			in = new FileInputStream(config_file);
			pro.load(in);

			logo = pro.getProperty("logo");
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

	public void getBottomConfig() {

		pro = new Properties();
		try {
			in = new FileInputStream(config_file);
			pro.load(in);

			big_pic_1 = pro.getProperty("big_pic_1");
			big_pic_2 = pro.getProperty("big_pic_2");
			big_pic_3 = pro.getProperty("big_pic_3");
			big_pic_4 = pro.getProperty("big_pic_4");

			small_pic_1 = pro.getProperty("small_pic_1");
			small_pic_2 = pro.getProperty("small_pic_2");
			small_pic_3 = pro.getProperty("small_pic_3");
			small_pic_4 = pro.getProperty("small_pic_4");
			small_pic_5 = pro.getProperty("small_pic_5");
			small_pic_6 = pro.getProperty("small_pic_6");
			small_pic_7 = pro.getProperty("small_pic_7");
			small_pic_8 = pro.getProperty("small_pic_8");

			big_adver_1 = pro.getProperty("big_adver_1");
			big_adver_2 = pro.getProperty("big_adver_2");
			big_adver_3 = pro.getProperty("big_adver_3");
			big_adver_4 = pro.getProperty("big_adver_4");

			small_adver_1 = pro.getProperty("small_adver_1");
			small_adver_2 = pro.getProperty("small_adver_2");
			small_adver_3 = pro.getProperty("small_adver_3");
			small_adver_4 = pro.getProperty("small_adver_4");
			small_adver_5 = pro.getProperty("small_adver_5");
			small_adver_6 = pro.getProperty("small_adver_6");
			small_adver_7 = pro.getProperty("small_adver_7");
			small_adver_8 = pro.getProperty("small_adver_8");

			email = pro.getProperty("email");
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

	public void getSortPicUrlConfig() {
		pro = new Properties();
		try {
			in = new FileInputStream(config_file);
			pro.load(in);

			wood = pro.getProperty("wood");
			stone = pro.getProperty("stone");
			ceramics = pro.getProperty("ceramics");
			glass = pro.getProperty("glass");
			plastic = pro.getProperty("plastic");
			carpet = pro.getProperty("carpet");
			paint = pro.getProperty("paint");
			wallpaper = pro.getProperty("wallpaper");
			metal = pro.getProperty("metal");
			gypsum = pro.getProperty("gypsum");
			hydropower = pro.getProperty("hydropower");
			other = pro.getProperty("other");
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
			in = new FileInputStream(config_file);
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
			in = new FileInputStream(config_file);
			pro.load(in);
			pro.put(key, value);
			out = new FileOutputStream(config_file);
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
