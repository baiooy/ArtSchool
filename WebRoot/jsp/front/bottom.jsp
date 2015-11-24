<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<script language="JavaScript" type="text/JavaScript"></script>
		<style type="text/css">
.indexCote_03 {
	font-size: 12px;
	color: #2F4870;
}

.indexCote_01 {
	background-color: #CCCCCC;
	font-size: 12px;
	vertical-align: middle;
}

.indexCote_02 {
	font-size: 12px;
	font-family: Arial;
}

img {
	border: 0;
}
</style>
	</head>
	<body>
		<table width="880" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr height="5">
				<td>
				</td>
			</tr>
			<tr>
				<td align="center">
					<a href="${big_adver_1}" target="_blank"><img width="200"
							height="50" src="<%=path%>${big_pic_1}"> </a>
					<a href="${big_adver_2}" target="_blank"> <img width="200"
							height="50" src="<%=path%>${big_pic_2}"> </a>
					<a href="${big_adver_3}" target="_blank"> <img width="200"
							height="50" src="<%=path%>${big_pic_3}"> </a>
					<a href="${big_adver_4}" target="_blank"><img width="200"
							height="50" src="<%=path%>${big_pic_4}"> </a>
				</td>
			</tr>
			<tr height="5">
				<td>
				</td>
			</tr>
			<tr>
				<td width="878" align="center">
					<a href="${small_adver_1}" target="_blank"><img width="90"
							height="30" src="<%=path%>${small_pic_1}"> </a> &nbsp;
					<a href="${small_adver_2}" target="_blank"><img width="90"
							height="30" src="<%=path%>${small_pic_2}"> </a> &nbsp;
					<a href="${small_adver_3}" target="_blank"> <img width="90"
							height="30" src="<%=path%>${small_pic_3}"> </a> &nbsp;
					<a href="${small_adver_4}" target="_blank"><img width="90"
							height="30" src="<%=path%>${small_pic_4}"> </a> &nbsp;
					<a href="${small_adver_5}" target="_blank"><img width="90"
							height="30" src="<%=path%>${small_pic_5}"> </a> &nbsp;
					<a href="${small_adver_6}" target="_blank"> <img width="90"
							height="30" src="<%=path%>${small_pic_6}"> </a> &nbsp;
					<a href="${small_adver_7}" target="_blank"> <img width="90"
							height="30" src="<%=path%>${small_pic_7}"> </a> &nbsp;
					<a href="${small_adver_8}" target="_blank"> <img width="90"
							height="30" src="<%=path%>${small_pic_8}"> </a>
				</td>
			</tr>
			<tr>
				<td height="5">

				</td>
			</tr>
			<tr>
				<td height="19" class="indexCote_01">
					<div align="center">
						<a href="<%=path%>/index.jsp">トップページに戻ります </a> |
						<a href="mailto:${email}">私達を連絡します </a> | 当駅に関して | 責任の声明を免れます |
						ウェブサイトの協力
					</div>
				</td>
			</tr>
			<tr>
				<td height="34">
					<div align="center">
						<span class="indexCote_03"> 無錫の晟のオーストリアのソフトウェアは技術サポートを提供します
							<br> Copyright© ピアノ教室.net All Rights Reserverd <br>教室の住所:
							東京都目黒区八雲（地図の表示あり） </span>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
