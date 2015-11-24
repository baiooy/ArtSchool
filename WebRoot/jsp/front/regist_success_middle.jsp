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
			content="5;url=<%=path%>/login.do?userName=${userName}&userPass=${userPass}&loginUrl=/navigate.do">
		<title>装饰材料图库</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<style type="text/css">
.font_01 {
	font-size: 13px;
	color: #666666;
}
</style>
		<script type="text/javascript">
	var times = 6;
	clock();
	function clock() {
		if (times > 0) {
			window.setTimeout('clock() ', 1000);
			times = times - 1;
			document.getElementById('time').innerHTML = times;
		}
	}
</script>
	</head>

	<body style="margin: 0">
		<table width="894" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td width="100%" valign="top" align="center">
			<tr height="80">
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<table width="283" height="60" align="center"
						background="<%=path%>/img/front/regist/backdropImg_02.gif">
						<tr>
							<td>
								<img src="<%=path%>/img/front/regist/rigthImg.gif" width="22"
									height="19" align="middle">
								<span class="font_01">${message}成功,<font id="time">5</font>5秒後にで自ら上陸して戻ります <a
									href="<%=path%>/navigate.do" class="font_02">トップページ </a> </span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="80">
				<td>
					&nbsp;
				</td>
			</tr>

		</table>
	</body>
</html>