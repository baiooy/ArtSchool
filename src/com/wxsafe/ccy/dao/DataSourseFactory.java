package com.wxsafe.ccy.dao;

import org.apache.commons.dbcp.BasicDataSource;

import com.wxsafe.ccy.config.DataBaseConfig;

public class DataSourseFactory {
//	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
//	private final static String URL = "jdbc:mysql://localhost:3306/art";
//	private final static String USER = "root";
//	private final static String PASSWORD = "123";

	private static BasicDataSource bs;

	public static BasicDataSource getDataSource() {

		DataBaseConfig rc = DataBaseConfig.getInstance();
		rc.getDateConfig();
		bs = new BasicDataSource();
//		bs.setDriverClassName(DRIVER_NAME);
//		bs.setUrl(URL);
//		bs.setUsername(USER);
//		bs.setPassword(PASSWORD);
//		System.out.println(rc.driver_name);
		bs.setDriverClassName(rc.driver_name);
		bs.setUrl(rc.url);
		bs.setUsername(rc.user);
		bs.setPassword(rc.password);
		bs.setMaxActive(20);
		return bs;
	}
}
