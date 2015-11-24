<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title></title>
		<meta http-equiv="Expires" CONTENT="0">
	</head>
	<body bgcolor="#FF9900" leftmargin="0">
		<div style="background-color: #000000; width: 100%; height: 65px;">
			<font color="#FFFFFF" size="+6">Logo</font><font color="#FF0000"
				size="+2">后台管理</font>
		</div>
		<br>
		<div>
			<img src="<%=path%>/img/back/label.GIF" width="100%" height="19">
		</div>
	</body>
</html>
