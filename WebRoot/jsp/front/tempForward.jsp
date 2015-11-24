<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Refresh"
			content="0;url=<%=path%>${forward}">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
	</head>

	<body style="margin: 0">
		
	</body>
</html>