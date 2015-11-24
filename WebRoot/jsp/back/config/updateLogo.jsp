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
	function checkSubmit() {
		var pic = document.getElementById('pic');
		if (isPic(pic)) {
			return true;
		} else {
			window.alert('请上传一张正确的图片');
			return false;
		}
	}
</script>
	<body>
		<div class="divStyle1">
			<table width="" height="" border="0" bordercolor="#000000" id="tb"
				style="text-align: left; font-size: 12px;">
				<html:form action="updatePicUrl.do" method="post"
					enctype="multipart/form-data" onsubmit="return checkSubmit()">
					<tr>
						<td>
							Logo写真をアップロード
							<input type="file" id="pic" name="pic" />
						</td>
					</tr>

					<tr>
						<td>
							<input type="hidden" name="backurl"
								value="/jsp/back/config/updateLogo.jsp">
							<input type="hidden" name="picKey" value="logo">
							<input type="submit" value="保存" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;">
							<font style="color: red; font-size: 12px">注記：写真の長さと幅は212*35に近い</font>
						</td>
					</tr>
				</html:form>
			</table>
		</div>

	</body>
</html>
