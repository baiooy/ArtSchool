<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<meta http-equiv="Expires" CONTENT="0">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
	</head>
	<body>

		<jsp:include page="top.jsp"></jsp:include>

		<jsp:include page="navigate_middle.jsp"></jsp:include>

		<jsp:include page="bottom.jsp"></jsp:include>

	</body>
</html>
