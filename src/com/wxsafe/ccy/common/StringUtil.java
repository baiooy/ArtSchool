package com.wxsafe.ccy.common;

import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

public class StringUtil extends org.apache.commons.lang.StringUtils {

	public static String CheckParm(String str) {

		if (str == null || str.equals("")) {
			return ("");

		} else {
			str = replace(str, "'", "''");
			str = replace(str, "\\", "\\\\");
			return str;
		}
	}

	public static String CheckSpecialChar(String str) {

		if (str == null || str.equals("")) {
			return ("");

		} else {
			str = replace(str, "'", "''");
			str = replace(str, "?", "\\\\?");
			str = replace(str, "%", "\\\\%");
			str = replace(str, "_", "\\\\_");
			str = replace(str, "\\", "\\\\");
			return str;
		}
	}

	public static String CheckLineChar(String str) {
		if (str == null || str.equals("")) {
			return ("");

		} else {
			str = replace(str, "\r\n", "<br>&nbsp;&nbsp;");
			return str;
		}
	}

	public static String replace(String target, String oldStr, String newStr) {

		return StringUtils.replace(target, oldStr, newStr);
	}

	public static String nullCheck(String str) {
		return ((str == null) ? "" : str);
	}

	public static String repNull(Object object) {
		if (null == object) {
			return "";
		} else {
			return object.toString();
		}
	}

	public static String zeroInsert(String str, int lenInteger) {

		StringBuffer sbuffer1 = new StringBuffer();
		StringBuffer sbuffer2 = new StringBuffer();

		for (int idx = 1; idx < lenInteger; idx++) {
			sbuffer1.append("0");
		}
		String rtn = sbuffer2.append(sbuffer1.append("0")).append(str)
				.toString();
		return rtn;
	}

	public static String zeroFormat(String str, int lenInteger) {

		int lenStr = str.length();
		StringBuffer sbuffer1 = new StringBuffer();
		StringBuffer sbuffer2 = new StringBuffer();
		int idx = 0;
		while (idx <= ((lenInteger - lenStr) - 1)) {
			sbuffer1.append("0");
			idx++;
		}
		String rtn = sbuffer2.append(sbuffer1).append(str).toString();
		return rtn;
	}

	public static String[] splitString(String data, String delimita) {

		StringTokenizer st = new StringTokenizer(data, delimita);
		String[] buf = new String[st.countTokens()];

		int icount = 0;
		while (st.hasMoreTokens()) {
			buf[icount] = st.nextToken();
			icount++;
		}
		if (buf.length == 0) {
			buf = null;
		}
		return buf;
	}

	public static boolean isNotEmpty(String sb) {
		return sb != null && sb.length() > 0;
	}

	public static Integer parseInteger(String s) {
		Integer object = null;
		try {
			if (isNotEmpty(s)) {
				object = Integer.valueOf(s);
			}
		} catch (NumberFormatException e) {
		}
		return object;
	}
}
