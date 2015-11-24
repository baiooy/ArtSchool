<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<script language="JavaScript" type="text/JavaScript"
			src="<%=path%>/js/back.js"></script>
		<style type="text/css">
.font_01 {
	font-size: 12px;
	color: #666666;
}

.font_03 {
	color: #686868;
	font-size: 12px;
}
</style>

	</head>
	<script type="text/javascript">
	function doFind() {
		var userForm = document.getElementById('userForm');
		userForm.submit();
	}
</script>
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
				<html:form action="findPass.do" method="post"
					enctype="multipart/form-data">
					<td>
						<c:if test="${user!=null}">
							<table width="425" height="180" align="center"
								background="<%=path%>/img/front/regist/backdropImg_03.GIF">
								<tr>
									<td colspan="2">
									</td>
								</tr>
								<tr>
									<td width="130" height="33" align="right">
										<span class="font_03">パスワードの注意の問題 ：</span>
									</td>
									<td width="">
										<span class="font_03">${user.userAsk}</span>
									</td>
								</tr>
								<tr>
									<td width="130" height="33" align="right">
										<span class="font_03">パスワードは解答にヒントを与えます ：</span>
									</td>
									<td width="doFind()">
										<input type="text" name="userAnswer" maxlength="20">
										<input type="hidden" name="userID" value="${user.userID}">
									</td>
								</tr>
								<tr>
									<td width="130" height="33" align="right">
									</td>
									<td align="left">
										<img src="<%=path%>/img/front/button/btnFindPass.GIF"
											onClick="doFind()" onmouseover="checkCursor(this)" width="65"
											height="20">
									</td>
								</tr>
								<tr>
									<td colspan="2">
									</td>
								</tr>
							</table>
						</c:if>
						<c:if test="${user==null}">
							<table width="425" height="180" align="center"
								background="<%=path%>/img/front/regist/backdropImg_03.GIF">
								<tr>
									<td colspan="2">
									</td>
								</tr>
								<tr>
									<td width="130" height="33" align="right">
										<span class="font_03">ハンドル名：</span>
									</td>
									<td width="">
										<input type="text" name="userName" maxlength="20">

									</td>
								</tr>
								<tr>
									<td width="130" height="33" align="right">

									</td>
									<td align="left">
										<img src="<%=path%>/img/front/button/btnNextFind.GIF"
											onClick="doFind()" onmouseover="checkCursor(this)" width="65"
											height="20">
									</td>
								</tr>
								<tr>
									<td colspan="2">
									</td>
								</tr>
							</table>
						</c:if>
					</td>
				</html:form>
			</tr>
			<tr height="80">
				<td>
					&nbsp;
				</td>
			</tr>

		</table>
	</body>
</html>