package com.wxsafe.ccy.method;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.wxsafe.ccy.dao.DataAccessObject;
import com.wxsafe.ccy.dto.TypeDto;
import com.wxsafe.ccy.form.TypeForm;
import com.wxsafe.ccy.sql.TypeSql;

public class TypeMethods {
	private Connection conn = null;

	public TypeMethods() {
	}

	public TypeMethods(Connection conn) {
		this.conn = conn;
	}

	private static TypeDto MapToDto(Map<String, Object> map) {
		TypeDto dto = new TypeDto();
		if (map.containsKey("typeID")) {
			dto.setTypeID((Integer) map.get("typeID"));
		}
		if (map.containsKey("typeParent")) {
			dto.setTypeParent((Integer) map.get("typeParent"));
		}
		if (map.containsKey("typeName")) {
			dto.setTypeName(map.get("typeName").toString());
		}
		if (map.containsKey("parentName")) {
			dto.setParentName(map.get("parentName").toString());
		}
		return dto;

	}

	private static List<TypeDto> changeList(List<Map<String, Object>> mapList) {

		List<TypeDto> dtoList = new ArrayList<TypeDto>();
		Iterator<Map<String, Object>> ir = mapList.iterator();
		int rowNum = 1;
		while (ir.hasNext()) {
			TypeDto dto = MapToDto(ir.next());
			dto.setRowNum(rowNum);
			rowNum++;
			dtoList.add(dto);
		}
		return dtoList;
	}

	public TypeDto selectType(int typeID) throws SQLException {

		TypeDto dto = null;
		DataAccessObject da = new DataAccessObject(conn);

		List<Map<String, Object>> mapList = da.executeQuery(TypeSql
				.selectTypeByID(typeID));
		if (mapList.size() > 0) {
			dto = (TypeDto) changeList(mapList).get(0);
		}
		return dto;
	}

	public boolean deleteType(int typeID) throws SQLException {

		DataAccessObject da = new DataAccessObject(conn);
		return da.executeUpdate(TypeSql.deleteType(selectAllChildType(typeID,
				conn)));

	}

	public boolean addType(TypeForm form) {
		boolean result = false;
		TypeDto dto = new TypeDto();
		try {
			BeanUtils.copyProperties(dto, form);
			DataAccessObject da = new DataAccessObject(conn);
			result = da.executeUpdate(TypeSql.addType(dto));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateType(TypeForm form) {
		boolean result = false;
		TypeDto dto = new TypeDto();
		try {
			BeanUtils.copyProperties(dto, form);
			DataAccessObject da = new DataAccessObject(conn);
			result = da.executeUpdate(TypeSql.updateType(dto));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<TypeDto> selectChildType(int typeID,int start,int row) throws SQLException {
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(TypeSql
				.selectChildType(typeID, start, row));
		return changeList(mapList);
	}
	public List<TypeDto> selectChildType(int typeID) throws SQLException {
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(TypeSql
				.selectChildType(typeID));
		return changeList(mapList);
	}
	
	public static int[] selectAllChildType(int typeID, Connection conn)
			throws SQLException {
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(TypeSql
				.selectAllChildType(typeID));
		int[] typeIDs = new int[mapList.size() + 1];
		typeIDs[0] = typeID;
		int i = 1;
		Iterator<TypeDto> ir = changeList(mapList).listIterator();
		while (ir.hasNext()) {
			typeIDs[i] = ((TypeDto) ir.next()).getTypeID();
			i++;
		}
		return typeIDs;
	}
	
	public List<TypeDto> selectAllParentType(int typeID) throws SQLException {
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(TypeSql
				.selectAllParentType(typeID));
		return changeList(mapList);
	}
}
