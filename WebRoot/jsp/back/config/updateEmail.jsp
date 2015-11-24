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
	<script type="text/javascript">
	
</script>
	<body>
		<div class="divStyle1">
			<table width="" height="" border="0" bordercolor="#000000" id="tb"
				style="text-align: left; font-size: 12px;">
				<html:form action="updateStrConfig.do" method="post"
					enctype="multipart/form-data" onsubmit="return checkSubmit()">
					<tr>
						<td>
							e - mailアドレスを入力してください
							<input type="text" name="strValue">
							<input type="hidden" name="strKey" value="email">
							<input type="hidden" name="backurl"
								value="/jsp/back/config/updateEmail.jsp">
						</td>
					</tr>

					<tr>
						<td>

							<input type="submit" value="保存" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;">
						</td>
					</tr>
				</html:form>
			</table>
		</div>

	</body>
</html>
