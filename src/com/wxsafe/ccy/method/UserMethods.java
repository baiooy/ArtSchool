package com.wxsafe.ccy.method;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.wxsafe.ccy.dao.DataAccessObject;
import com.wxsafe.ccy.dto.PageDto;
import com.wxsafe.ccy.dto.UserDto;
import com.wxsafe.ccy.form.AdminForm;
import com.wxsafe.ccy.form.LoginForm;
import com.wxsafe.ccy.form.UserForm;
import com.wxsafe.ccy.sql.AdminSql;
import com.wxsafe.ccy.sql.UserSql;

public class UserMethods {
	
	// 数据库连接
	private Connection conn = null;

	public UserMethods() {
	}

	public UserMethods(Connection conn) {
		this.conn = conn;
	}

	private UserDto MapToDto(Map<String, Object> map) {
		UserDto dto = new UserDto();
		if (map.containsKey("userID")) {
			dto.setUserID((Integer) map.get("userID"));
		}
		if (map.containsKey("userName")) {
			dto.setUserName(map.get("userName").toString());
		}
		if (map.containsKey("userPass")) {
			dto.setUserPass(map.get("userPass").toString());
		}
		if (map.containsKey("userCall")) {
			dto.setUserCall(map.get("userCall").toString());
		}
		if (map.containsKey("userRole")) {
			dto.setUserRole((Integer) map.get("userRole"));
		}
		if (map.containsKey("userMail")) {
			dto.setUserMail(map.get("userMail").toString());
		}
		if (map.containsKey("userTel")) {
			dto.setUserTel(map.get("userTel").toString());
		}
		if (map.containsKey("userAdress")) {
			dto.setUserAdress(map.get("userAdress").toString());
		}
		if (map.containsKey("userAsk")) {
			dto.setUserAsk(map.get("userAsk").toString());
		}
		if (map.containsKey("userAanswer")) {
			dto.setUserAnswer(map.get("userAanswer").toString());
		}
		if (map.containsKey("lastTime")) {
			dto.setLastTime(map.get("lastTime").toString());
		}
		if (map.containsKey("registTime")) {
			dto.setRegistTime(map.get("registTime").toString());
		}
		return dto;

	}

	public List<UserDto> changeList(List<Map<String, Object>> mapList) {
		List<UserDto> dtoList = new ArrayList<UserDto>();
		Iterator<Map<String, Object>> ir = mapList.iterator();
		while (ir.hasNext()) {
			UserDto dto = MapToDto(ir.next());
			dtoList.add(dto);
		}
		return dtoList;
	}

	public UserDto adminLogin(String userName, String userPass)
			throws SQLException {

		UserDto dto = new UserDto();
		DataAccessObject dao = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = dao.executeQuery(AdminSql
				.adminLoginSql(userName, userPass));
		if (mapList.size() == 0) {
			dto = null;
		} else {
			dto = changeList(mapList).get(0);
		}
		return dto;
	}

	public List<UserDto> listAdmin() throws SQLException {
		List<UserDto> list = new ArrayList<UserDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(AdminSql
				.listAdminSql());
		list = changeList(mapList);
		return list;
	}

	public UserDto selectUserByID(int userID) throws SQLException {

		UserDto dto = null;
		DataAccessObject da = new DataAccessObject(conn);

		List<Map<String, Object>> mapList = da.executeQuery(UserSql
				.selectUserByIDSql(userID));
		if (mapList.size() != 0) {
			dto = changeList(mapList).get(0);
		}
		return dto;
	}

	public UserDto selectUserByName(String userName) throws SQLException {

		UserDto dto = null;
		DataAccessObject da = new DataAccessObject(conn);

		List<Map<String, Object>> mapList = da.executeQuery(UserSql
				.selectUserByNameSql(userName));
		if (mapList.size() != 0) {
			dto = changeList(mapList).get(0);
		}
		return dto;
	}

	public UserDto selectUserByAnswer(int userID, String userAnswer)
			throws SQLException {

		UserDto dto = null;
		DataAccessObject da = new DataAccessObject(conn);

		List<Map<String, Object>> mapList = da.executeQuery(UserSql
				.selectUserByAnswerSql(userID, userAnswer));
		if (mapList.size() != 0) {
			dto = changeList(mapList).get(0);
		}
		return dto;
	}

	public int getUserCount(String keyword) throws SQLException {

		DataAccessObject da = new DataAccessObject(conn);
		Map<String, Object> map = da.executeQuery(
				UserSql.getCountByKeySql(keyword)).get(0);
		int count = Integer.parseInt((map.get("count").toString()));
		return count;
	}

	public List<UserDto> listUser(String keyword, PageDto dto)
			throws SQLException {
		List<UserDto> list = new ArrayList<UserDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(UserSql.listUser(
				keyword, dto.getStart(), dto.getRows()));
		list = changeList(mapList);
		return list;
	}

	public boolean addUser(UserForm form) {

		UserDto dto = new UserDto();
		try {
			BeanUtils.copyProperties(dto, form);
			java.util.Date now = new Date();
			String nowTime = FormatDate.formatDate(now, "yy-MM-dd");
			dto.setRegistTime(nowTime);
			dto.setLastTime(nowTime);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataAccessObject dao = new DataAccessObject(conn);
		return dao.executeUpdate(UserSql.addUserSql(dto));
	}

	public boolean updateUser(UserForm form) {

		UserDto dto = new UserDto();
		try {
			BeanUtils.copyProperties(dto, form);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataAccessObject dao = new DataAccessObject(conn);
		return dao.executeUpdate(UserSql.updateUserSql(dto));
	}

	public boolean updateAdmin(AdminForm form) {
		UserDto dto = new UserDto();
		dto.setUserName(form.getUserName());
		dto.setUserPass(form.getUserPass());
		dto.setUserID(form.getUserID());

		DataAccessObject dao = new DataAccessObject(conn);
		return dao.executeUpdate(AdminSql.updateAdminSql(dto));
	}

	public boolean deleteUser(int[] userIDs) {
		if (userIDs == null || 0 == userIDs.length) {
			return true;
		}
		DataAccessObject dao = new DataAccessObject(conn);
		return dao.executeUpdate(UserSql.deleteUserSql(userIDs));
	}

	public boolean changeRole(AdminForm form) {
		UserDto dto = new UserDto();
		dto.setUserRole(form.getUserRole());
		dto.setUserID(form.getUserID());
		DataAccessObject dao = new DataAccessObject(conn);
		return dao.executeUpdate(UserSql.changeRoleSql(dto));
	}

	public UserDto userLogin(LoginForm form) {
		UserDto dto = new UserDto();
		DataAccessObject dao = new DataAccessObject(conn);
		try {
			List<Map<String, Object>> list = dao.executeQuery(UserSql
					.userLoginSql(form.getUserName(), form.getUserPass()));
			List<UserDto> newList = changeList(list);
			if (newList.size() == 0) {
				dto = null;
			} else {
				dto = newList.get(0);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	public boolean checkUserName(String userName) throws SQLException {
		boolean result = false;
		DataAccessObject da = new DataAccessObject(conn);
		Map<String, Object> map = da.executeQuery(
				UserSql.checkUserNameSql(userName)).get(0);
		int count = Integer.parseInt((map.get("count").toString()));
		if (count == 0) {
			result = true;
		}
		return result;
	}

}
