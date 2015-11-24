package com.wxsafe.ccy.sql;

import com.wxsafe.ccy.config.StrConfig;
import com.wxsafe.ccy.dto.TypeDto;

public class TypeSql {

	public static String selectTypeByID(int typeID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" a.typeID ,a.typeParent,a.typeName ,b.typeName");
		sb.append(" AS 'parentName'");
		sb.append(" FROM tbType a,tbType b");
		sb.append(" WHERE  a.typeParent=b.typeID  AND a.typeID =" + typeID);
		sb.append(" UNION SELECT  typeID ,typeParent,typeName ,'");
		sb.append(" " + StrConfig.ALL_SORT + "' AS 'parentName' ");
		sb.append(" FROM tbType");
		sb.append(" WHERE  typeParent=0  AND typeID =" + typeID);
		return sb.toString();
	}

	public static String deleteType(int[] typeIDs) {

		StringBuffer sb = new StringBuffer();
		sb.append(" DELETE");
		sb.append(" FROM tbType");
		sb.append(" WHERE typeID IN(");
		sb.append(MaterialSql.getTypes(typeIDs));
		sb.append(" )");
		return sb.toString();
	}

	public static String addType(TypeDto typeDto) {

		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO tbType");
		sb.append(" (typeName,typeParent)");
		sb.append(" VALUES");
		sb.append(" ('" + typeDto.getTypeName() + "',");
		sb.append(" '" + typeDto.getTypeParent() + "')");
		return sb.toString();
	}

	public static String updateType(TypeDto typeDto) {
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE tbType  SET");
		sb.append(" typeName='" + typeDto.getTypeName() + "'");
		sb.append(" WHERE typeID=" + typeDto.getTypeID());
		return sb.toString();
	}

	public static String selectChildType(int typeID, int start, int rows) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" typeID,");
		sb.append(" IF(CHAR_LENGTH(typeName)>4,LEFT(typeName,4),typeName)");
		sb.append(" AS 'typeName' ");
		sb.append(" FROM tbType");
		sb.append(" WHERE  typeParent=" + typeID);
		sb.append(" LIMIT " + start + "," + rows);
		return sb.toString();
	}
	public static String selectChildType(int typeID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT");
		sb.append(" typeID,");
		sb.append(" IF(CHAR_LENGTH(typeName)>4,LEFT(typeName,4),typeName)");
		sb.append(" AS 'typeName' ");
		sb.append(" FROM tbType");
		sb.append(" WHERE  typeParent=" + typeID);
		return sb.toString();
	}

	
	public static String selectAllChildType(int typeID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" CALL sp_type_child(" + typeID + ")");
		return sb.toString();
	}
	
	public static String selectAllParentType(int typeID) {

		StringBuffer sb = new StringBuffer();
		sb.append(" CALL sp_type_parent(" + typeID + ")");
		return sb.toString();
	}
}
