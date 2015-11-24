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
import com.wxsafe.ccy.dto.ReviewDto;
import com.wxsafe.ccy.form.ReviewForm;
import com.wxsafe.ccy.sql.ReviewSql;

public class ReviewMetheds {

	private Connection conn = null;

	public ReviewMetheds() {
	}

	public ReviewMetheds(Connection conn) {
		this.conn = conn;
	}

	private static ReviewDto MapToDto(Map<String, Object> map) {
		ReviewDto dto = new ReviewDto();
		if (map.containsKey("reID")) {
			dto.setReID((Integer) map.get("reID"));
		}
		if (map.containsKey("reMessage")) {
			dto.setReMessage(map.get("reMessage").toString());
		}
		if (map.containsKey("userCall")) {
			dto.setUserCall(map.get("userCall").toString());
		}
		if (map.containsKey("maId")) {
			dto.setMaID((Integer) map.get("maId"));
		}
		if (map.containsKey("userID")) {
			dto.setUserID((Integer) map.get("userID"));
		}
		if (map.containsKey("reTime")) {
			dto.setReTime(map.get("reTime").toString());
		}

		return dto;

	}

	private static List<ReviewDto> changeList(List<Map<String, Object>> mapList) {

		List<ReviewDto> dtoList = new ArrayList<ReviewDto>();
		Iterator<Map<String, Object>> ir = mapList.iterator();
		int rowNum = 1;
		while (ir.hasNext()) {
			ReviewDto dto = MapToDto(ir.next());
			dto.setRowNum(rowNum);
			rowNum++;
			dtoList.add(dto);
		}
		return dtoList;
	}

	public boolean addReview(ReviewForm form) {
		boolean result = false;
		ReviewDto dto = new ReviewDto();
		try {
			BeanUtils.copyProperties(dto, form);
			java.util.Date now = new Date();
			String nowTime = FormatDate.formatDate(now, "yy-MM-dd");
			dto.setReTime(nowTime);
			DataAccessObject da = new DataAccessObject(conn);
			result = da.executeUpdate(ReviewSql.addReSql(dto));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int getReviewCount(int maID) throws SQLException {

		DataAccessObject da = new DataAccessObject(conn);
		Map<String, Object> map = da.executeQuery(ReviewSql.getReCounr(maID))
				.get(0);
		int count = Integer.parseInt((map.get("count").toString()));
		return count;
	}

	public List<ReviewDto> listReviewByID(int maID, PageDto dto)
			throws SQLException {
		List<ReviewDto> list = new ArrayList<ReviewDto>();
		DataAccessObject da = new DataAccessObject(conn);
		List<Map<String, Object>> mapList = da.executeQuery(ReviewSql
				.listReSql(maID, dto.getStart(), dto.getRows()));
		list = changeList(mapList);
		return list;
	}

	public boolean deleteReByMa(int[] maIDs) {
		if (maIDs == null || 0 == maIDs.length) {
			return true;
		}
		DataAccessObject da = new DataAccessObject(conn);
		return da.executeUpdate(ReviewSql.deleteReByMa(maIDs));
	}

	public boolean deleteReByID(int reID) {
		DataAccessObject da = new DataAccessObject(conn);
		return da.executeUpdate(ReviewSql.deleteReByID(reID));
	}
}
