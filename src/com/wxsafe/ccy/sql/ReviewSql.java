package com.wxsafe.ccy.sql;

import com.wxsafe.ccy.dto.ReviewDto;

public class ReviewSql {

	public static String addReSql(ReviewDto dto) {

		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO tbreview");
		sb.append(" (reMessage,maID,userID,reTime)");
		sb.append(" VALUES");
		sb.append(" ('" + dto.getReMessage() + "',");
		sb.append(" '" + dto.getMaID() + "',");
		sb.append(" '" + dto.getUserID() + "',");
		sb.append(" '" + dto.getReTime() + "'");
		sb.append(" )");
		return sb.toString();
	}

	public static String listReSql(int maID, int start, int rows) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT r.reID,r.reMessage,r.reTime,");
		// sb.append(" IF(r.userID=0,'" + StrConfig.VISITOR
		// + "',u.userCall) AS 'userCall'");
		// sb.append(" FROM tbreview r LEFT JOIN tbuser u");
		// sb.append(" ON maID=" + maID);
		sb.append(" u.userCall");
		sb.append(" FROM tbreview r , tbuser u");
		sb.append(" WHERE maID=" + maID);
		sb.append(" AND r.userID=u.userID");
		sb.append(" ORDER BY r.reTime DESC,r.reID DESC");
		sb.append(" LIMIT " + start + "," + rows);
		// System.out.println(sb.toString());
		return sb.toString();
	}

	public static String getReCounr(int maID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT COUNT(reID) AS 'count'");
		sb.append(" FROM tbreview");
		sb.append(" WHERE maID=" + maID);
		return sb.toString();
	}

	public static String deleteReByID(int reID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" DELETE");
		sb.append(" FROM");
		sb.append(" tbreview");
		sb.append(" WHERE");
		sb.append(" reID=" + reID);
		return sb.toString();
	}

	public static String deleteReByMa(int[] maIDs) {

		StringBuffer sb = new StringBuffer();
		sb.append(" DELETE");
		sb.append(" FROM");
		sb.append(" tbreview");
		sb.append(" WHERE");
		sb.append(" maID in(");
		for (int i = 0; i < maIDs.length; i++) {
			if (i == 0) {
				sb.append(maIDs[i]);
			} else {
				sb.append("," + maIDs[i]);
			}
		}
		sb.append(" );");
		return sb.toString();
	}
}
