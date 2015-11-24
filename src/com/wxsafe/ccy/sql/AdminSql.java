package com.wxsafe.ccy.sql;

import com.wxsafe.ccy.dto.UserDto;

public class AdminSql {

	public static String adminLoginSql(String userName, String userPass) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" *");
		sb.append(" FROM");
		sb.append(" tbUser");
		sb.append(" WHERE");
		sb.append(" userName='" + userName + "'");
		sb.append(" AND");
		sb.append(" userPass='" + userPass + "'");
		sb.append(" AND");
		sb.append(" userRole=1");
		return sb.toString();
	}

	public static String listAdminSql() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" userID,userName,userPass,userRole");
		sb.append(" FROM");
		sb.append(" tbUser");
		sb.append(" WHERE");
		sb.append(" userRole IN (1,2)");
		return sb.toString();
	}

	public static String updateAdminSql(UserDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE tbUser SET ");
		sb.append(" userName='" + dto.getUserName() + "',");
		sb.append(" userPass='" + dto.getUserPass() + "'");
		sb.append(" WHERE userID=" + dto.getUserID());

		return sb.toString();
	}

}
