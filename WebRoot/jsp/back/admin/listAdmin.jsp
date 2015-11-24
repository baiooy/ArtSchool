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
		<title></title>
		<meta http-equiv="Expires" CONTENT="0">
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/back.css" />
		<script type="text/javascript" src="<%=path%>/js/back.js"></script>
	</head>
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/back.css" />
	<script type="text/javascript" src="<%=path%>/js/back.js"></script>
	
	<body>
		<div class="divStyle1">
			<table width="" height="" border="0" bordercolor="#000000" id="tb"
				style="text-align: left; font-size: 12px;">
				<tr>
					<td>
						現在の管理者:${loginAdmin.userName}
					</td>
				</tr>
			</table>
		</div>
		<br>
		<div class="divStyle1">
			<table width="" height="" border="0" bordercolor="#000000" id="tb"
				style="text-align: center; font-size: 12px;">
				<tr height="30">
					<td width="75">
						ユーザ名
					</td>
					<td width="200">
						パスワード
					</td>
					<td width="75">

					</td>
					<td width="200">
						状態
					</td>
					<td width="75">

					</td>
				</tr>
				<c:forEach var="admin" items="${admin}">
					<tr height="30">
						<html:form action="updateAdmin.do" method="post"
							enctype="multipart/form-data">
							<td width="75">
								<input type="hidden" name="userID" value="${admin.userID}">
								<input type="text" name="userName" maxlength="11"
									value="${admin.userName}">
							</td>
							<td width="200">
								<input type="text" name="userPass" maxlength="20"
									value="${admin.userPass}">

							</td>
							<td width="75">
								<input type="submit" value="保存" onmouseover="checkCursor(this)"
									style=" width: 49px;height: 28px;border-style: none;">
							</td>
						</html:form>
						<td width="200">
							<c:if test="${admin.userRole==1}">オープニング</c:if>
							<c:if test="${admin.userRole==2}">使用を禁止</c:if>
						</td>
						<html:form action="updateAdmin.do" method="post"
							enctype="multipart/form-data">
							<td width="75">
								<input type="hidden" name="userID" value="${admin.userID}">
								<c:if test="${admin.userRole==1}">
									<input type="hidden" name="userRole" value="2">

								
									 <input type="submit" value="禁止" onmouseover="checkCursor(this)"
										style=" width: 49px;height: 28px;border-style: none;">
									
								</c:if>
								<input type="hidden" name="userRole" value="1">
								<c:if test="${admin.userRole==2}">
									
									<input type="submit" value="使用" onmouseover="checkCursor(this)"
										style=" width: 49px;height: 28px;border-style: none;">
								</c:if>
							</td>
						</html:form>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
