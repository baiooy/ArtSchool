package com.wxsafe.ccy.method;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.wxsafe.ccy.dao.DataAccessObject;
import com.wxsafe.ccy.sql.CommonSql;

public class CommonMetheds {

	private Connection conn = null;

	public CommonMetheds() {
	}

	public CommonMetheds(Connection conn) {
		this.conn = conn;
	}

	public int getLastInsertID() throws SQLException {
		int id = 0;
		DataAccessObject da = new DataAccessObject(conn);
		id = Integer.parseInt(da.executeSingel(CommonSql.getLastInsertId()));
		return id;
	}
	
	public String[] selectAllUploadFile() throws SQLException {
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(CommonSql
				.selectAllUploadFileSql());
		String[] picPaths = new String[mapList.size()];
		Iterator<Map<String, Object>> ir = mapList.iterator();
		int i = 0;
		while (ir.hasNext()) {
			Map<String, Object> picMap = ir.next();
			if (picMap.containsKey("uploadfile")) {
				picPaths[i] = picMap.get("uploadfile").toString();
			}
			i++;
		}
		return picPaths;
	}
}
