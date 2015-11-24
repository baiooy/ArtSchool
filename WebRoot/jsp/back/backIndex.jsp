<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>装饰材料图库后台</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<meta http-equiv="Expires" CONTENT="0">
	</head>
	<frameset rows="118,*" border="0">
		<FRAME SRC="<%=path%>/jsp/back/backTop.jsp" NAME="left" scrolling="no">
		<FRAMESET COLS="210,*">
			<FRAME SRC="content.do" NAME="left">
			<FRAME SRC="<%=path%>/jsp/back/backNone.jsp" NAME="right">
		</FRAMESET>
	</frameset>
</html>