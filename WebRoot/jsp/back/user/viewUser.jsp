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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Expires" CONTENT="0">
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/back.css" />
		<script type="text/javascript" src="<%=path%>/js/back.js"></script>
	</head>
	<body>
		<div class="divStyle1" align="left">
			<table width="" height="" border="0" align="center"
				bordercolor="#000000" id="tb"
				style="COLOR: #069; text-align: center; font-size: 12px;">
				<tr height="30">
					<td width="75">
						用户名
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${user.userName}
						</DIV>
					</td>
					<td width="75">
						密码
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${user.userPass}
						</DIV>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						昵称
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${user.userCall}
						</DIV>
					</td>
					<td width="75">
						邮箱
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${user.userMail}
						</DIV>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						电话
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${user.userTel}
						</DIV>
					</td>
					<td width="75">
						地址
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${user.userAdress}
						</DIV>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						注册时间
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${user.registTime}
						</DIV>
					</td>
					<td width="75">
						最后登陆
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${user.lastTime}
						</DIV>
					</td>
				</tr>
				<html:form action="deleteUser.do">
					<tr height="30">
						<td width="75">
						</td>
						<td colspan="3" align="left">
							<input type="hidden" name="deleteModel" value="1">
							<input type="hidden" name="userIDs" value="${user.userID}">
							<input type="submit" value="删除" style="color: #069">
						</td>
					</tr>
				</html:form>
			</table>
		</div>
	</body>
</html>
