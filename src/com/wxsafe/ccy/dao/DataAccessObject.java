package com.wxsafe.ccy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAccessObject {

	private Connection conn = null;

	private PreparedStatement ps = null;

	private ResultSet rs = null;

	public DataAccessObject(Connection conn) {
		this.conn = conn;
	}

	public List<Map<String, Object>> executeQuery(String strSql)
			throws SQLException {

		ps = conn.prepareStatement(strSql);
		rs = ps.executeQuery();

		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			resultList.add(getResultMap(rs));
		}
		rs.close();
		ps.close();
		return resultList;
	}

	public boolean executeUpdate(String strSql) {

		boolean result = false;

		try {
			ps = conn.prepareStatement(strSql);
			ps.executeUpdate();
			
			ps.close();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public String executeSingel(String strSql) throws SQLException {

		ps = conn.prepareStatement(strSql);
		rs = ps.executeQuery();

		String result = null;
		while (rs.next()) {
			result = rs.getString(1);
		}
		rs.close();
		ps.close();
		return result;
	}

	public Map<String, Object> getResultMap(ResultSet rs) throws SQLException {
		Map<String, Object> hm = new HashMap<String, Object>();
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		for (int i = 1; i <= count; i++) {
			String key = rsmd.getColumnLabel(i);
			Object value = rs.getObject(i);
			hm.put(key, value);
		}
		return hm;
	}
}
