package com.wxsafe.ccy.sql;

import java.util.Date;

import com.wxsafe.ccy.dto.MaterialDto;
import com.wxsafe.ccy.method.FormatDate;

public class MaterialSql {

	public static String getTypes(int[] typeIDs) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < typeIDs.length - 1; i++) {
			sb.append(" " + typeIDs[i] + ",");
		}
		sb.append(" " + typeIDs[typeIDs.length - 1]);
		return sb.toString();
	}

	public static String getCountByTypeSql(int[] typeIDs) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" COUNT(maID)");
		sb.append(" AS 'count'");
		sb.append(" FROM");
		sb.append(" tbMaterial");
		sb.append(" WHERE maType in (");
		sb.append(getTypes(typeIDs));
		sb.append(" )");
		return sb.toString();
	}

	public static String getCountByKeySql(String keyword) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" COUNT(maID)");
		sb.append(" AS 'count'");
		sb.append(" FROM");
		sb.append(" tbMaterial WHERE");
		sb.append(" concat(maName,maCode) like '%" + keyword + "%'");
		return sb.toString();
	}

	public static String getCountByKeyTypeSql(int[] typeIDs, String keyword) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" COUNT(m.maID)");
		sb.append(" AS 'count'");
		sb.append(" FROM tbMaterial m, tbType t");
		sb.append(" WHERE");
		sb.append(" CONCAT(m.maName,m.maCode) LIKE '%" + keyword + "%'");
		sb.append(" AND m.maType=t.typeID");
		sb.append(" AND m.maType IN(");
		sb.append(getTypes(typeIDs));
		sb.append(" )");
		return sb.toString();
	}

	public static String selectMaterialByIDSql(int maID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" m.maID,m.maName,m.maCode,m.maType,t.typeName,");
		sb.append(" m.maBranch,m.maOrigin,m.maOtherName,m.maFormat,");
		sb.append(" m.maPrice1,m.maPrice2,m.maBrand,m.maGrade,");
		sb.append(" m.maPart,m.maTrait,m.maEffect,m.maEnvironment,");
		sb.append(" m.maPicPath,m.maAffix,m.isRecommend,");
		sb.append(" m.downCount,m.maNewlyTime,m.maUpdateTime,m.clickCount");
		sb.append(" FROM tbMaterial m, tbType t");
		sb.append(" WHERE m.maType=t.typeID");
		sb.append(" AND m.maID=" + maID);
		return sb.toString();
	}

	public static String listMaterialSql(int[] typeIDs, int start, int rows) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT m.maID,");
		sb.append(" IF(CHAR_LENGTH(m.maName)>22,CONCAT(LEFT(m.maName,20),'...'),m.maName)");
		sb.append(" AS 'maName',");
		sb.append(" m.maCode,m.maType,t.typeName,");
		sb.append(" m.maBranch,m.maOrigin,m.maOtherName,m.maFormat,");
		sb.append(" m.maPrice1,m.maPrice2,m.maBrand,m.maGrade,");
		sb.append(" m.maPart,m.maTrait,m.maEffect,m.maEnvironment,");
		sb.append(" m.maPicPath,m.isRecommend,m.maNewlyTime,m.maUpdateTime,m.clickCount");
		sb.append(" FROM tbMaterial m, tbType t");
		sb.append(" WHERE m.maType=t.typeID");
		sb.append(" AND m.maType IN(");
		sb.append(getTypes(typeIDs));
		sb.append(" )");
		sb.append(" ORDER BY m.maID DESC");
		sb.append(" LIMIT " + start + "," + rows);
		return sb.toString();
	}

	public static String listMaterialSql(String keyword, int start, int rows) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT m.maID,");
		sb
				.append(" IF(CHAR_LENGTH(m.maName)>22,CONCAT(LEFT(m.maName,20),'...'),m.maName)");
		sb.append(" AS 'maName',");
		sb.append(" m.maCode,m.maType,t.typeName,");
		sb.append(" m.maBranch,m.maOrigin,m.maOtherName,m.maFormat,");
		sb.append(" m.maPrice1,m.maPrice2,m.maBrand,m.maGrade,");
		sb.append(" m.maPart,m.maTrait,m.maEffect,m.maEnvironment,");
		sb
				.append(" m.maPicPath,m.isRecommend,m.maNewlyTime,m.maUpdateTime,m.clickCount");
		sb.append(" FROM tbMaterial m, tbType t");
		sb.append(" WHERE");
		sb.append(" CONCAT(m.maName,m.maCode) LIKE '%" + keyword + "%'");
		sb.append(" AND m.maType=t.typeID");
		sb.append(" ORDER BY m.maID DESC");
		sb.append(" LIMIT " + start + "," + rows);
		return sb.toString();
	}

	public static String listMaterialSql(int[] typeIDs, String keyword,
			int start, int rows) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT m.maID,");
		sb
				.append(" IF(CHAR_LENGTH(m.maName)>22,CONCAT(LEFT(m.maName,20),'...'),m.maName)");
		sb.append(" AS 'maName',");
		sb.append(" m.maCode,m.maType,t.typeName,");
		sb.append(" m.maBranch,m.maOrigin,m.maOtherName,m.maFormat,");
		sb.append(" m.maPrice1,m.maPrice2,m.maBrand,m.maGrade,");
		sb.append(" m.maPart,m.maTrait,m.maEffect,m.maEnvironment,");
		sb
				.append(" m.maPicPath,m.isRecommend,m.maNewlyTime,m.maUpdateTime,m.clickCount");
		sb.append(" FROM tbMaterial m, tbType t");
		sb.append(" WHERE CONCAT(m.maName,m.maCode) LIKE '%" + keyword + "%'");
		sb.append(" AND m.maType=t.typeID");
		sb.append(" AND m.maType IN(");
		sb.append(getTypes(typeIDs));
		sb.append(" )");
		sb.append(" ORDER BY m.maID DESC");
		sb.append(" LIMIT " + start + "," + rows);
		return sb.toString();
	}

	public static String addMaterialSql(MaterialDto dto) {

		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO tbMaterial");
		sb.append(" (maName,maCode,maType,maBranch,");
		sb.append(" maOrigin,maOtherName,maFormat,");
		sb.append(" maPrice1,maPrice2,maBrand,maGrade,");
		sb.append(" maPart,maTrait,maEffect,maEnvironment,");
		sb.append(" maPicPath,maAffix,isRecommend,downCount,");
		sb.append(" maNewlyTime,maUpdateTime,clickCount)");
		sb.append(" VALUES");
		sb.append(" ('" + dto.getMaName() + "',");
		sb.append(" '" + dto.getMaCode() + "',");
		sb.append(" '" + dto.getMaType() + "',");
		sb.append(" '" + dto.getMaBranch() + "',");
		sb.append(" '" + dto.getMaOrigin() + "',");
		sb.append(" '" + dto.getMaOtherName() + "',");
		sb.append(" '" + dto.getMaFormat() + "',");
		sb.append(" '" + dto.getMaPrice1() + "',");
		sb.append(" '" + dto.getMaPrice2() + "',");
		sb.append(" '" + dto.getMaBrand() + "',");
		sb.append(" '" + dto.getMaGrade() + "',");
		sb.append(" '" + dto.getMaPart() + "',");
		sb.append(" '" + dto.getMaTrait() + "',");
		sb.append(" '" + dto.getMaEffect() + "',");
		sb.append(" '" + dto.getMaEnvironment() + "',");
		sb.append(" '" + dto.getMaPicPath() + "',");
		sb.append(" '" + dto.getMaAffix() + "',");
		sb.append(" '" + dto.getIsRecommend() + "',");
		sb.append(" '" + dto.getDownCount() + "',");
		sb.append(" '" + dto.getMaNewlyTime() + "',");
		sb.append(" '" + dto.getMaUpdateTime() + "',");
		sb.append(" '" + dto.getClickCount() + "'");
		sb.append(" )");
		return sb.toString();
	}

	public static String upMaterialSql(MaterialDto dto) {

		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE tbMaterial SET ");
		sb.append(" maName='" + dto.getMaName() + "',");
		sb.append(" maCode='" + dto.getMaCode() + "',");
		sb.append(" maType='" + dto.getMaType() + "',");
		sb.append(" maBranch='" + dto.getMaBranch() + "',");
		sb.append(" maOrigin='" + dto.getMaOrigin() + "',");
		sb.append(" maOtherName='" + dto.getMaOtherName() + "',");
		sb.append(" maFormat='" + dto.getMaFormat() + "',");
		sb.append(" maPrice1='" + dto.getMaPrice1() + "',");
		sb.append(" maPrice2='" + dto.getMaPrice2() + "',");
		sb.append(" maBrand='" + dto.getMaBrand() + "',");
		sb.append(" maGrade='" + dto.getMaGrade() + "',");
		sb.append(" maPart='" + dto.getMaPart() + "',");
		sb.append(" maTrait='" + dto.getMaTrait() + "',");
		sb.append(" maEffect='" + dto.getMaEffect() + "',");
		sb.append(" maEnvironment='" + dto.getMaEnvironment() + "',");
		sb.append(" maPicPath='" + dto.getMaPicPath() + "',");
		sb.append(" maAffix='" + dto.getMaAffix() + "',");
		sb.append(" isRecommend='" + dto.getIsRecommend() + "',");
		sb.append(" maUpdateTime='" + dto.getMaUpdateTime() + "'");
		sb.append(" WHERE maID=" + dto.getMaID());

		return sb.toString();
	}

	public static String deleteMaterialSql(int[] maIDs) {
		StringBuffer sb = new StringBuffer();
		sb.append(" DELETE");
		sb.append(" FROM");
		sb.append(" tbMaterial");
		sb.append(" WHERE");
		sb.append(" maID in (");
		for (int i = 0; i < maIDs.length; i++) {
			if (i == 0) {
				sb.append(maIDs[i]);
			} else {
				sb.append("," + maIDs[i]);
			}
		}
		sb.append(");");
		return sb.toString();
	}

	public static String changeIsRecommendSql(int[] maIDs, int isRecommend) {
		java.util.Date now = new Date();
		String nowTime = FormatDate.formatDate(now, "yy-MM-dd");
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE tbMaterial SET");
		sb.append(" maUpdateTime='" + nowTime + "',");
		sb.append(" isRecommend='" + isRecommend + "'");
		sb.append(" WHERE");
		sb.append(" maID in(");
		for (int i = 0; i < maIDs.length; i++) {
			if (i == 0) {
				sb.append(maIDs[i]);
			} else {
				sb.append("," + maIDs[i]);
			}
		}
		sb.append(" )");
		return sb.toString();
	}

	public static String selectRecommendSql(int[] typeIDs, int start, int rows) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT maID,");
		sb
				.append(" IF(CHAR_LENGTH(maName)>14,CONCAT(LEFT(maName,12),'...'),maName)");
		sb.append(" AS 'maName',maPicPath");
		sb.append(" FROM tbMaterial ");
		sb.append(" WHERE");
		sb.append(" isRecommend=0");
		sb.append(" AND maPicPath != ''");
		if (typeIDs.length != 0) {
			sb.append(" AND maType IN(");
			sb.append(getTypes(typeIDs));
			sb.append(" )");
		}
		sb.append(" ORDER BY maUpdateTime DESC");
		sb.append(" LIMIT " + start + "," + rows);
		return sb.toString();
	}

	public static String selectRecommendCountSql(int[] typeIDs) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT COUNT(maID) AS 'count'");
		sb.append(" FROM tbMaterial ");
		sb.append(" WHERE");
		sb.append(" isRecommend=0");
		sb.append(" AND maPicPath != ''");
		if (typeIDs.length != 0) {
			sb.append(" AND maType IN(");
			sb.append(getTypes(typeIDs));
			sb.append(" )");
		}
		return sb.toString();
	}

	public static String selectTopDownSql(int start, int rows) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT maID,");
		sb
				.append(" IF(CHAR_LENGTH(maName)>9,CONCAT(LEFT(maName,8),'...'),maName)");
		sb.append(" AS 'maName',maPicPath,downCount");
		sb.append(" FROM tbMaterial ");
		sb.append(" WHERE");
		sb.append(" maPicPath != ''");
		sb.append(" ORDER BY downCount DESC");
		sb.append(" LIMIT " + start + "," + rows);
		return sb.toString();
	}

	public static String selectTopDownSql(int[] typeIDs, int start, int rows) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT m.maID,");
		sb
				.append(" IF(CHAR_LENGTH(m.maName)>10,CONCAT(LEFT(m.maName,8),'...'),m.maName)");
		sb.append(" AS 'maName' , downCount");
		sb.append(" FROM tbMaterial m, tbType t");
		sb.append(" WHERE");
		sb.append(" m.maPicPath != ''");
		sb.append(" AND m.maType=t.typeID");
		sb.append(" AND m.maType IN(");
		sb.append(getTypes(typeIDs));
		sb.append(" )");
		sb.append(" ORDER BY m.downCount DESC");
		sb.append(" LIMIT " + start + "," + rows);
		return sb.toString();
	}

	public static String selectBackNextSql(int maID, int[] typeIDs, int isNext) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT m.maID,");
		sb
				.append(" IF(CHAR_LENGTH(m.maName)>9,CONCAT(LEFT(m.maName,7),'...'),m.maName)");
		sb.append(" AS 'maName'");
		sb.append(" FROM tbMaterial m, tbType t");
		sb.append(" WHERE");
		sb.append(" m.maPicPath != ''");
		sb.append(" AND m.maType=t.typeID");
		sb.append(" AND m.maType IN(");
		sb.append(getTypes(typeIDs));
		sb.append(" )");
		sb.append(" AND m.maID");
		if (isNext == 0) {
			sb.append(" >");
		} else {
			sb.append(" <");
		}
		sb.append(" " + maID + " ORDER BY m.maID ");
		if (isNext != 0) {
			sb.append(" DESC ");
		}
		sb.append(" LIMIT " + 0 + "," + 1);
		return sb.toString();

	}

	public static String downLoadSql(int maID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE tbMaterial SET ");
		sb.append(" downCount=downCount+1");
		sb.append(" WHERE maID=" + maID);

		return sb.toString();
	}

	public static String clickSql(int maID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE tbMaterial SET ");
		sb.append(" clickCount=clickCount+1");
		sb.append(" WHERE maID=" + maID);

		return sb.toString();
	}
}
