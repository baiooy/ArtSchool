<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<meta http-equiv="Expires" CONTENT="0">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
.font {
	color: red;
	font-size: 12px;
}
.afont {
	font-size: 12px;
}
</style>
	</head>

	<body>
		<br>
		<br>
		<br>
		<table align="center" width="150">
			<tr>
				<td style="border: 1px solid #666666;">
					<table align="center" width="200" height="50">
						<tr>
							<td align="center">
								<font class="font">${error}</font>
							</td>
						</tr>
						<tr>
							<td align="center">
								<a href="${backUrl}"><font class="afont">戻ります</font>
								</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
