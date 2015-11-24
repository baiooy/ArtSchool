package com.wxsafe.ccy.method;

import java.text.SimpleDateFormat;

public class FormatDate {

	public static String formatDate(java.util.Date date, String dateType) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateType);
		return sdf.format(date);
	}

	public static java.sql.Date changeDate(java.util.Date utilDate) {

		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

}
