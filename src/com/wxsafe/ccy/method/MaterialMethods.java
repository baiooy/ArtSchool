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
import com.wxsafe.ccy.dto.MaterialDto;
import com.wxsafe.ccy.dto.PageDto;
import com.wxsafe.ccy.form.MaterialForm;
import com.wxsafe.ccy.sql.MaterialSql;

public class MaterialMethods {

	private Connection conn = null;

	public MaterialMethods() {
	}

	public MaterialMethods(Connection conn) {
		this.conn = conn;
	}

	private MaterialDto MapToDto(Map<String, Object> map) {

		MaterialDto dto = new MaterialDto();
		if (map.containsKey("maID")) {
			dto.setMaID((Integer) map.get("maID"));
		}
		if (map.containsKey("maName")) {
			dto.setMaName(map.get("maName").toString());
		}
		if (map.containsKey("maCode")) {
			dto.setMaCode(map.get("maCode").toString());
		}
		if (map.containsKey("maType")) {
			dto.setMaType((Integer) map.get("maType"));
		}
		if (map.containsKey("typeName")) {
			dto.setTypeName(map.get("typeName").toString());
		}
		if (map.containsKey("maBranch")) {
			dto.setMaBranch(map.get("maBranch").toString());
		}
		if (map.containsKey("maOrigin")) {
			dto.setMaOrigin(map.get("maOrigin").toString());
		}
		if (map.containsKey("maOtherName")) {
			dto.setMaOtherName(map.get("maOtherName").toString());
		}
		if (map.containsKey("maFormat")) {
			dto.setMaFormat(map.get("maFormat").toString());
		}
		if (map.containsKey("maPrice1")) {
			dto.setMaPrice1((Integer) map.get("maPrice1"));
		}
		if (map.containsKey("maPrice2")) {
			dto.setMaPrice2((Integer) map.get("maPrice2"));
		}
		if (map.containsKey("maBrand")) {
			dto.setMaBrand(map.get("maBrand").toString());
		}
		if (map.containsKey("maGrade")) {
			dto.setMaGrade(map.get("maGrade").toString());
		}
		if (map.containsKey("maPart")) {
			dto.setMaPart(map.get("maPart").toString());
		}
		if (map.containsKey("maTrait")) {
			dto.setMaTrait(map.get("maTrait").toString());
		}
		if (map.containsKey("maEffect")) {
			dto.setMaEffect(map.get("maEffect").toString());
		}
		if (map.containsKey("maEnvironment")) {
			dto.setMaEnvironment(map.get("maEnvironment").toString());
		}
		if (map.containsKey("maPicPath")) {
			dto.setMaPicPath(map.get("maPicPath").toString());
		}
		if (map.containsKey("maAffix")) {
			dto.setMaAffix(map.get("maAffix").toString());
		}
		if (map.containsKey("isRecommend")) {
			dto.setIsRecommend((Integer) map.get("isRecommend"));
		}
		if (map.containsKey("downCount")) {
			dto.setDownCount((Integer) map.get("downCount"));
		}
		if (map.containsKey("maNewlyTime")) {

			java.sql.Date newDate = (java.sql.Date) map.get("maNewlyTime");
			dto.setMaNewlyTime(FormatDate.formatDate(newDate, "yy/MM/dd"));
		}
		if (map.containsKey("maUpdateTime")) {
			java.sql.Date upDate = (java.sql.Date) map.get("maUpdateTime");
			dto.setMaUpdateTime(upDate.toString());
		}
		if (map.containsKey("clickCount")) {
			dto.setClickCount((Integer) map.get("clickCount"));
		}
		return dto;
	}

	private List<MaterialDto> changeList(List<Map<String, Object>> mapList) {
		List<MaterialDto> dtoList = new ArrayList<MaterialDto>();
		Iterator<Map<String, Object>> ir = mapList.iterator();
		int rowNum = 1;
		while (ir.hasNext()) {
			MaterialDto dto = MapToDto(ir.next());
			dto.setRowNum(rowNum);
			rowNum++;
			dtoList.add(dto);
		}
		return dtoList;
	}

	public List<MaterialDto> listMaterialsByType(int typeID, PageDto dto)
			throws SQLException {
		List<MaterialDto> list = new ArrayList<MaterialDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(MaterialSql
				.listMaterialSql(TypeMethods.selectAllChildType(typeID, conn),
						dto.getStart(), dto.getRows()));
		list = changeList(mapList);
		return list;
	}

	public List<MaterialDto> listMaterialByKey(String keyword, PageDto dto)
			throws SQLException {
		List<MaterialDto> list = new ArrayList<MaterialDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(MaterialSql
				.listMaterialSql(keyword, dto.getStart(), dto.getRows()));
		list = changeList(mapList);
		return list;
	}

	public List<MaterialDto> listMaterialByKeyType(int typeID, String keyword,
			PageDto dto) throws SQLException {
		List<MaterialDto> list = new ArrayList<MaterialDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		if (typeID == 0) {
			mapList = da.executeQuery(MaterialSql.listMaterialSql(keyword, dto
					.getStart(), dto.getRows()));
		} else {
			mapList = da.executeQuery(MaterialSql.listMaterialSql(TypeMethods
					.selectAllChildType(typeID, conn), keyword, dto.getStart(),
					dto.getRows()));
		}
		list = changeList(mapList);
		return list;
	}

	public MaterialDto selectMaterial(int maID) throws SQLException {

		MaterialDto dto = null;
		DataAccessObject da = new DataAccessObject(conn);

		List<Map<String, Object>> mapList = da.executeQuery(MaterialSql
				.selectMaterialByIDSql(maID));
		if (mapList.size() > 0) {
			dto = changeList(mapList).get(0);
		}
		return dto;
	}

	public int getMaterialCount(int typeID) throws SQLException {

		DataAccessObject da = new DataAccessObject(conn);
		Map<String, Object> map = da.executeQuery(
				MaterialSql.getCountByTypeSql(TypeMethods.selectAllChildType(
						typeID, conn))).get(0);
		int count = Integer.parseInt((map.get("count").toString()));
		return count;
	}

	public int getMaterialCount(String keyword) throws SQLException {

		DataAccessObject da = new DataAccessObject(conn);
		Map<String, Object> map = da.executeQuery(
				MaterialSql.getCountByKeySql(keyword)).get(0);
		int count = Integer.parseInt((map.get("count").toString()));
		return count;
	}

	public int getMaterialCount(int typeID, String keyword) throws SQLException {

		DataAccessObject da = new DataAccessObject(conn);
		Map<String, Object> map = da.executeQuery(
				MaterialSql.getCountByKeyTypeSql(TypeMethods
						.selectAllChildType(typeID, conn), keyword)).get(0);
		int count = Integer.parseInt((map.get("count").toString()));
		return count;
	}

	public boolean addMaterial(MaterialForm form) {
		boolean result = false;
		try {
			MaterialDto dto = new MaterialDto();
			BeanUtils.copyProperties(dto, form);
			java.util.Date now = new Date();
			String nowTime = FormatDate.formatDate(now, "yy-MM-dd");
			dto.setMaNewlyTime(nowTime);
			dto.setMaUpdateTime(nowTime);
			dto.setDownCount(0);
			DataAccessObject da = new DataAccessObject(conn);
			da.executeUpdate(MaterialSql.addMaterialSql(dto));
			result = true;

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean upMaterial(MaterialForm form) {
		boolean result = false;
		try {
			MaterialDto dto = new MaterialDto();
			BeanUtils.copyProperties(dto, form);
			java.util.Date now = new Date();
			String nowTime = FormatDate.formatDate(now, "yy-MM-dd");
			dto.setMaUpdateTime(nowTime);
			DataAccessObject da = new DataAccessObject(conn);
			da.executeUpdate(MaterialSql.upMaterialSql(dto));
			result = true;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean changeIsCommend(int[] isIDs, int[] noIDs) {
		boolean result = false;
		DataAccessObject da = new DataAccessObject(conn);
		da.executeUpdate(MaterialSql.changeIsRecommendSql(noIDs, 1));
		da.executeUpdate(MaterialSql.changeIsRecommendSql(isIDs, 0));

		result = true;
		return result;
	}

	public boolean deleteMaterial(int[] maIDs) {
		if (maIDs == null || 0 == maIDs.length) {
			return true;
		}
		DataAccessObject da = new DataAccessObject(conn);
		da.executeUpdate(MaterialSql.deleteMaterialSql(maIDs));
		return true;
	}

	public List<MaterialDto> selectRecommend(int typeID, PageDto dto)
			throws SQLException {
		List<MaterialDto> list = new ArrayList<MaterialDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(MaterialSql
				.selectRecommendSql(TypeMethods
						.selectAllChildType(typeID, conn), dto.getStart(), dto
						.getRows()));
		list = changeList(mapList);
		return list;
	}

	public int selectRecommendCount(int typeID) throws SQLException {

		DataAccessObject da = new DataAccessObject(conn);
		Map<String, Object> map = da.executeQuery(
				MaterialSql.selectRecommendCountSql(TypeMethods
						.selectAllChildType(typeID, conn))).get(0);
		int count = Integer.parseInt((map.get("count").toString()));
		return count;
	}

	public List<MaterialDto> selectTopDown() throws SQLException {
		List<MaterialDto> list = new ArrayList<MaterialDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(MaterialSql
				.selectTopDownSql(0, 16));
		list = changeList(mapList);
		return list;
	}

	public List<MaterialDto> selectTopDown(int typeID) throws SQLException {
		List<MaterialDto> list = new ArrayList<MaterialDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(MaterialSql
				.selectTopDownSql(TypeMethods.selectAllChildType(typeID, conn),
						0, 10));
		list = changeList(mapList);
		return list;
	}

	public MaterialDto selectBackNext(int maID, int typeID, int isNext)
			throws SQLException {

		MaterialDto dto = null;
		DataAccessObject da = new DataAccessObject(conn);

		List<Map<String, Object>> mapList = da.executeQuery(MaterialSql
				.selectBackNextSql(maID, TypeMethods.selectAllChildType(typeID,
						conn), isNext));
		if (mapList.size() > 0) {
			dto = changeList(mapList).get(0);
		}
		return dto;
	}

	public boolean down(int maID) {
		DataAccessObject da = new DataAccessObject(conn);
		return da.executeUpdate(MaterialSql.downLoadSql(maID));
	}

	public boolean click(int maID) {
		DataAccessObject da = new DataAccessObject(conn);
		return da.executeUpdate(MaterialSql.clickSql(maID));
	}
}
