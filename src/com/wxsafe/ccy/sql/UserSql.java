package com.wxsafe.ccy.sql;

import com.wxsafe.ccy.dto.UserDto;

public class UserSql {

	public static String changeRoleSql(UserDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE tbUser SET ");
		sb.append(" userRole='" + dto.getUserRole() + "'");
		sb.append(" WHERE userID=" + dto.getUserID());

		return sb.toString();
	}

	public static String getCountByKeySql(String keyword) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT COUNT(userID)");
		sb.append(" AS 'count'");
		sb.append(" FROM tbUser ");
		sb.append(" WHERE");
		sb.append(" CONCAT(userName,userCall) LIKE '%" + keyword + "%'");
		sb.append(" AND userRole=3");
		return sb.toString();
	}

	public static String listUser(String keyword, int start, int rows) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT *");
		sb.append(" FROM tbUser ");
		sb.append(" WHERE");
		sb.append(" CONCAT(userName,userCall) LIKE '%" + keyword + "%'");
		sb.append(" AND userRole=3");
		sb.append(" ORDER BY userID DESC");
		sb.append(" LIMIT " + start + "," + rows);
		return sb.toString();
	}

	public static String addUserSql(UserDto dto) {

		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO ");
		//
		sb.append("  tbUser(");
		sb.append("  userName");
		sb.append(" ,userPass");
		sb.append(" ,userCall");
		sb.append(" ,userRole");
		sb.append(" ,userMail");
		sb.append(" ,userTel");
		sb.append(" ,userAdress");
		sb.append(" ,userAsk");
		sb.append(" ,userAanswer");
		sb.append(" ,registTime");
		sb.append(" ,lastTime");
		sb.append(" )VALUES");
		sb.append(" ('" + dto.getUserName() + "',");
		sb.append(" '" + dto.getUserPass() + "',");
		sb.append(" '" + dto.getUserCall() + "',");
		sb.append(" '" + 3 + "',");
		sb.append(" '" + dto.getUserMail() + "',");
		sb.append(" '" + dto.getUserTel() + "',");
		sb.append(" '" + dto.getUserAdress() + "',");
		sb.append(" '" + dto.getUserAsk() + "',");
		sb.append(" '" + dto.getUserAnswer() + "',");
		sb.append(" '" + dto.getRegistTime() + "',");
		sb.append(" '" + dto.getLastTime() + "'");
		sb.append(" )");
		return sb.toString();
	}

	public static String updateUserSql(UserDto dto) {

		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE tbUser SET ");
		sb.append(" userPass='" + dto.getUserPass() + "',");
		sb.append(" userCall='" + dto.getUserCall() + "',");
		sb.append(" userAsk='" + dto.getUserAsk() + "',");
		sb.append(" userAanswer='" + dto.getUserAnswer() + "',");
		sb.append(" userMail='" + dto.getUserMail() + "',");
		sb.append(" userTel='" + dto.getUserTel() + "',");
		sb.append(" userAdress='" + dto.getUserAdress() + "'");
		sb.append(" WHERE userID=" + dto.getUserID());
		//System.out.println(sb.toString());
		return sb.toString();
	}

	public static String deleteUserSql(int[] userIDs) {
		StringBuffer sb = new StringBuffer();
		sb.append(" DELETE");
		sb.append(" FROM");
		sb.append(" tbUser");
		sb.append(" WHERE");
		sb.append(" userID in(");
		for (int i = 0; i < userIDs.length; i++) {
			if (i == 0) {
				sb.append(userIDs[i]);
			} else {
				sb.append("," + userIDs[i]);
			}
		}
		sb.append(" )");
		return sb.toString();
	}

	public static String selectUserByIDSql(int userID) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT *");
		sb.append(" FROM");
		sb.append(" tbUser");
		sb.append(" WHERE");
		sb.append(" userID =" + userID);
		return sb.toString();
	}

	public static String selectUserByNameSql(String userName) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT *");
		sb.append(" FROM");
		sb.append(" tbUser");
		sb.append(" WHERE");
		sb.append(" userName ='" + userName + "'");
		sb.append(" AND");
		//普通用户
		sb.append(" userRole=3");
		return sb.toString();
	}

	public static String selectUserByAnswerSql(int userID, String userAnswer) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT *");
		sb.append(" FROM");
		sb.append(" tbUser");
		sb.append(" WHERE");
		sb.append(" userAanswer ='" + userAnswer + "'");
		sb.append(" AND");
		sb.append(" userID=" + userID);
		sb.append(" AND");
		sb.append(" userRole=3");
		return sb.toString();
	}

	public static String checkUserNameSql(String userName) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT COUNT(userName)AS 'count'");
		sb.append(" FROM");
		sb.append(" tbUser");
		sb.append(" WHERE");
		sb.append(" userName ='" + userName + "'");
		return sb.toString();
	}

	public static String userLoginSql(String userName, String userPass) {
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
		sb.append(" userRole!=2");
		return sb.toString();
	}
}
