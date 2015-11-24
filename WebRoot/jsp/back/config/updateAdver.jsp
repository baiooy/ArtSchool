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
	<script type="text/javascript">
	function changeUrlKey() {

		var urlKey = document.getElementById("urlKey");
		var picKey = document.getElementById("picKey");
		String
		select = document.getElementById("select").value;
		if (select == 1) {
			urlKey.value = 'big_adver_1';
			picKey.value = 'big_pic_1';
		}
		if (select == 2) {
			urlKey.value = 'big_adver_2';
			picKey.value = 'big_pic_2';
		}
		if (select == 3) {
			urlKey.value = 'big_adver_3';
			picKey.value = 'big_pic_3';
		}
		if (select == 4) {
			urlKey.value = 'big_adver_4';
			picKey.value = 'big_pic_4';
		}
		if (select == 5) {
			urlKey.value = 'small_adver_1';
			picKey.value = 'small_pic_1';
		}
		if (select == 6) {
			urlKey.value = 'small_adver_2';
			picKey.value = 'small_pic_2';
		}
		if (select == 7) {
			urlKey.value = 'small_adver_3';
			picKey.value = 'small_pic_3';
		}
		if (select == 8) {
			urlKey.value = 'small_adver_4';
			picKey.value = 'small_pic_4';
		}
		if (select == 9) {
			urlKey.value = 'small_adver_5';
			picKey.value = 'small_pic_5';
		}
		if (select == 10) {
			urlKey.value = 'small_adver_6';
			picKey.value = 'small_pic_6';
		}
		if (select == 11) {
			urlKey.value = 'small_adver_7';
			picKey.value = 'small_pic_7';
		}
		if (select == 12) {
			urlKey.value = 'small_adver_8';
			picKey.value = 'small_pic_8';
		}
	}
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
							タイプを選択してください
							<select id="select" onchange="changeUrlKey()">
								<option value="1">
									大型広告1
								</option>
								<option value="2">
									大型広告2
								</option>
								<option value="3">
									大型広告3
								</option>
								<option value="4">
									大型広告4
								</option>
								<option value="5">
									小さな広告1
								</option>
								<option value="6">
									小さな広告2
								</option>
								<option value="7">
									小さな広告3
								</option>
								<option value="8">
									小さな広告4
								</option>
								<option value="9">
									小さな広告5
								</option>
								<option value="10">
									小さな広告6
								</option>
								<option value="11">
									小さな広告7
								</option>
								<option value="12">
									小さな広告8
								</option>
							</select>
							
							<input type="hidden" id="urlKey" name="urlKey"
								value="big_adver_1">
							<input type="hidden" id="picKey" name="picKey" value="big_pic_1">
							<input type="hidden" name="backurl"
								value="/jsp/back/config/updateAdver.jsp">
						</td>
					</tr>
					<tr>
						<td>
							広告のURLを入力してください
							<input type="text" name="urlValue" value="http://"/>
						</td>
					</tr>
					<tr>
						<td>
							写真をアップロード
							<input type="file" id="pic" name="pic" />
						</td>
					</tr>

					<tr>
						<td>

							<input type="submit" value="保存" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;">
							<font style="color: red; font-size: 12px">
								注記：大型広告の長さと幅は200 * 50に近い,小さな広告の長さと幅は90*30に近い</font>
						</td>
					</tr>
				</html:form>
			</table>
		</div>

	</body>
</html>
