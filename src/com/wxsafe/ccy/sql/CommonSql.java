package com.wxsafe.ccy.sql;

public class CommonSql {

	public static String listNodeSql() {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" typeID AS 'nodeID',");
		sb.append(" typeName AS 'nodeName',");
		sb.append(" typeParent AS 'nodeParent',");
		sb.append(" 0 AS 'nodeType'");
		sb.append(" FROM tbType");
		return sb.toString();
	}

	public static String getLastInsertId() {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT LAST_INSERT_ID()");
		return sb.toString();
	}
	
	public static String selectAllUploadFileSql() {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" maPicPath AS 'uploadfile'");
		sb.append(" FROM tbMaterial ");
		sb.append(" UNION");
		sb.append(" SELECT");
		sb.append(" maAffix AS 'uploadfile'");
		sb.append(" FROM tbMaterial ");
		return sb.toString();
	}
}
