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
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<meta http-equiv="Expires" CONTENT="0">
		<script language="JavaScript" type="text/JavaScript"
			src="<%=path%>/js/back.js"></script>
	</head>
	<script type="text/javascript">
	var len_0_error = "技量の暇でない";
	var len_min_error = "より小さい";
	var len_max_error = "より大きい ";
	var char_char = "キャラクター";
	function check(obj, min, max, objname, id) {
		var temp = obj.value;
		var len = temp.length;
		if (len == 0) {
			showerror(id, objname + len_0_error);
			return false;
		} else if (len < min) {
			warning(id, objname + len_min_error + min + char_char)
			return false;
		} else if (len > max) {
			warning(id, objname + len_max_error + max + char_char);
			return false;
		}
		diserror(id);
		return true;

	}
	function showerror(id, msg) {
		obj = document.getElementById(id);
		obj.style.display = '';

		obj.innerHTML = ' &nbsp; ' + msg;

	}
	function diserror(id) {
		obj = document.getElementById(id);
		obj.style.display = 'none';
	}
	function checksubmit() {
		obj1 = document.getElementById('username');
		obj2 = document.getElementById('userpass');
		if (check(obj1, 3, 11, 'ハンドル名', 'usererror')
				&& check(obj2, 3, 11, 'パスワード', 'passerror')) {
			return true;
		} else {
			return false;
		}
	}
	function doLogin() {
		var loginForm = document.getElementById('LoginForm');
		loginForm.submit();
	}
</script>
	<body>
		<BR>
		<BR>
		<BR>
		<BR>
		<BR>
		<BR>
		<BR>
		<BR>
		<BR>
		<BR>
		<html:form action="backLogin.do" method="post"
			enctype="multipart/form-data" focus="userName">
			<table align="center" width="250">
				<tr>
					<td style="border: 1px solid #0577b5;">
						<table width="250" height="170">
							<tr>
								<td colspan="2"
									style="width: 100%; height: 29px; font-weight: bold; color: #0577b5; FONT-SIZE: 12px;"
									background="<%=path%>/img/front/common/bluenavi.gif">
									&nbsp;
									<img src="<%=path%>/img/front/common/memberPic.gif" width="16"
										height="15"> 
									管理人の登録 
								</td>
							</tr>

							<tr
								style="height: 25px; font-size: 13px; color: #666666; font-family: '宋体', Simsun;">
								<td width="40%" align="center">
									ハンドル名：
								</td>
								<td align="left">
									<input type="text" name="userName" style="width: 125px">
									<input name="loginUrl" value="<%=path%>/backLogin.jsp"
										type="hidden">
								</td>
							</tr>
							<tr
								style="height: 25px; font-size: 13px; color: #666666; font-family: '宋体', Simsun;">
								<td width="40%" align="center">
									パスワード：
								</td>
								<td align="left">
									<input type="password" name="userPass" style="width: 125px">
								</td>
							</tr>
							<tr height="25">
								<td align="center" colspan="2">
									<input type="hidden" name="loginUrl" value="/backLogin.jsp">
									<a onClick="doLogin()" onmouseover="checkCursor(this)"><span
										style="font-size: 14; color: #996600"> 登録</span>
									</a>

								</td>
							</tr>
						</table>
					</td>
				</tr>

			</table>

		</html:form>

	</body>
</html>
