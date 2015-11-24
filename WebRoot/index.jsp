<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<link href="css/index.css" rel="stylesheet" type="text/css">
	</head>

	<body>
		<table width="1000" align="center" cellpadding="0" cellspacing="0"
			border=0;>
			<tr id="head">
				<td height="218" width="1000px">

				</td>
			</tr>
			<tr id="mid"
				style="background: url('<%=path%>/img/front/index.gif');">
				<td style="width: 1000px; height: 293px;">

					<table width="1000">
						<tr valign="top" height="63">
							<td width="650">
								<div id="heading">
									<span class="chanaHead">ピアノ教室.net</span>
									<br>
									<span class="engHead">Decorative Materials Gallery</span>
								</div>
							</td>
							<td width="350">
								<div id="myself" align="right">
									│
									<a href="navigate.do?navigateID=0">全部の資料</a>│
									<a href="index.jsp">私達に関して </a>
								</div>
							</td>
						</tr>
					</table>
					<div id="navi">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td align="center">
									│
									<a href="navigate.do?navigateID=1">北海道</a>
								</td>
								<td align="center">
									│
									<a href="navigate.do?navigateID=2">北東</a>
								</td>
								<td align="center">
									│
									<a href="navigate.do?navigateID=3">中部</a>
								</td>
								<td align="center">
									│
									<a href="navigate.do?navigateID=4">関東</a>
								</td>
								<td align="center">
									│
									<a href="navigate.do?navigateID=5">近畿 </a>
								</td>
								<td align="center">
									│
									<a href="navigate.do?navigateID=6">中国</a>
								</td>
								<td align="center">
									│
									<a href="navigate.do?navigateID=7">四国</a>
								</td>
								<td align="center">
									│
									<a href="navigate.do?navigateID=8">九州</a>
								</td>
								<td align="center">
									│
									<a href="navigate.do?navigateID=12">その他</a>
								</td>
							</tr>
						</table>
					</div>

				</td>
			</tr>
			<tr id="und" height="337">
				<td align="center" width="1000px">
					<div id="message">
						Copyright© ピアノ教室.net All Rights Reserverd
						<br>
						教室の住所: 東京都目黒区八雲（地図の表示あり）
					</div>
				</td>
			</tr>
		</table>

	</body>
</html>
