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
	<script type="text/javascript">
	var _name = "名称";
	var _code = "型号";
	var _price = "价格";
	function checkNone(obj, divID) {
		var len = obj.value.length;
		var error = document.getElementById(divID);
		if (len == 0) {
			error.style.display = '';
			if (divID == 'nameError') {
				error.innerHTML = _name + '不能为空';
				return false;
			} else if (divID == 'codeError') {
				error.innerHTML = _code + '不能为空';
				return false;
			}
		} else {
			error.style.display = 'none';
			return true;
		}
	}
	function isPic(obj) {
		var error = document.getElementById('picError');
		var strFilter = ".jpeg|.gif|.jpg|.png|.bmp|.pic|"
		var strFileName = obj.value;
		if (strFileName == '') {
			return true;
		}
		if (strFileName.indexOf(".") > -1) {
			point = strFileName.lastIndexOf(".");
			strFileName = strFileName.substring(point, obj.length) + '|';
			strFileName = strFileName.toLowerCase();
			if (strFilter.indexOf(strFileName) > -1) {
				error.style.display = 'none';
				return true;
			} else {
				error.style.display = '';
				error.innerHTML = '请上传一张正确的图片';
				return false;
			}
		}
	}
	function isNum(obj) {
		var error = document.getElementById('numError');
		if (isNaN(obj.value)) {
			error.style.display = '';
			error.innerHTML = '请输入数字';
			return false;
		}
		error.style.display = 'none';
		return true;
	}

	function checkSubmit() {
		var name = document.getElementById('maName');
		var code = document.getElementById('maCode');
		var pic = document.getElementById('pic');
		var price1 = document.getElementById('maPrice1');
		var price2 = document.getElementById('maPrice2');
		if (checkNone(name, 'nameError') && checkNone(code, 'codeError')
				&& isPic(pic) && isNum(price1) && isNum(price2)) {
			document.MaterialForm.submit();
		} else {
			alert("输入信息有误");
		}
	}

	//
</script>
	<body>
		<div class="divStyle1" align="left">
			<html:form action="saveMa.do" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="operation" value="${operation}">
				<table width="" height="" border="0" align="center"
					bordercolor="#000000" id="tb"
					style="COLOR: #069; text-align: center; font-size: 12px;">
					<tr height="30">
						<td width="75">
							名称
						</td>
						<td width="200" align="left">
							<input type="hidden" id="maID" name="maID" value="${ma.maID}">
							<html:text property="maName" maxlength="20"
								styleClass="textStyle0" value="${ma.maName}"
								onblur="checkNone(this,'nameError')"></html:text>
							<font style="COLOR: red">*</font>
							<div id="nameError" style="COLOR: red"></div>
						</td>
						<td width="20">
						</td>
						<td width="300" rowspan="10">
							<DIV class="divStyle3">
								<c:if test="${null==ma.maPicPath}">
									<img src="<%=path%>/upload_file/nonePic.JPG"></img>
								</c:if>
								<c:if test="${null!=ma.maPicPath}">
									<img src="<%=path%>${ ma.maPicPath}"
										onload="autoSize(this,290,220)" />
								</c:if>
							</div>
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							教室の住所
						</td>
						<td width="200" align="left">
							<html:text property="maCode" styleClass="textStyle0"
								maxlength="10" value="${ma.maCode}"
								onblur="checkNone(this,'codeError')"></html:text>
							<font style="COLOR: red">*</font>
							<div id="codeError" style="COLOR: red"></div>
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							モットー
						</td>
						<td width="200" align="left">
							<input type="text" 
								class="textStyle1" />
							<input type="hidden" name="maType" value="${ma.maType}" />
							<input type="hidden" name="maPicPath" value="${ma.maPicPath}" />
							<input type="hidden" name="maAffix" value="${ma.maAffix}" />
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							ジャンル
						</td>
						<td width="200" align="left">
							<html:text property="maBranch" maxlength="20"
								styleClass="textStyle1" value="${ma.maBranch}"></html:text>
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							詳しい料金
						</td>
						<td width="200" align="left">
							<html:text property="maOrigin" maxlength="20"
								styleClass="textStyle1" value="${ma.maOrigin}"></html:text>
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							入会金
						</td>
						<td width="200" align="left">
							<html:text property="maOtherName" maxlength="20"
								styleClass="textStyle1" value="${ma.maOtherName}"></html:text>
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							運営費（月額）
						</td>
						<td width="200" align="left">
							<html:text property="maFormat" maxlength="20"
								styleClass="textStyle1" value="${ma.maFormat}"></html:text>
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							料金
						</td>
						<td width="200" align="left">
							<html:text property="maPrice1" maxlength="8" size="6"
								value="${ma.maPrice1}" onblur="isNum(this)"></html:text>
							-
							<html:text property="maPrice2" maxlength="8" size="6"
								value="${ma.maPrice2}" onblur="isNum(this)"></html:text>
							<div id="numError" style="COLOR: red"></div>
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							無料体験レッスン
						</td>
						<td width="200" align="left">
							<html:text property="maBrand" maxlength="20"
								styleClass="textStyle1" value="${ma.maBrand}"></html:text>
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							出張レッスン
						</td>
						<td width="200" align="left">
							<html:text property="maGrade" styleClass="textStyle1"
								maxlength="10" value="${ma.maGrade}"></html:text>
						</td>
						<td width="20">
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							レッスン形態
						</td>
						<td colspan="3" align="left">
							<textarea name="maPart" class="textareaStyle1"
								onkeyup="textareaLengtn(this,100)">${ma.maPart}</textarea>
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							対応コース
						</td>
						<td colspan="3" align="left">
							<textarea name="maTrait" class="textareaStyle1"
								onkeyup="textareaLengtn(this,200)">${ma.maTrait }</textarea>
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							評価
						</td>
						<td colspan="3" align="left">
							<html:text property="maEffect" maxlength="100"
								styleClass="textStyle2" value="${ma.maEffect}"></html:text>
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							営業案内
						</td>
						<td colspan="3" align="left">
							<html:text property="maEnvironment" maxlength="100"
								styleClass="textStyle2" value="${ma.maEnvironment}"></html:text>
						</td>
					</tr>

					<tr height="30">
						<td width="75">
							写真をアップロード
						</td>
						<td colspan="3" align="left">
							<html:file property="pic" onblur="isPic(this)"></html:file>
							<font style="COLOR: red">*</font>
							<div id="picError" style="COLOR: red"></div>
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							上传附件
						</td>
						<td colspan="3" align="left">
							<html:file property="affix"></html:file>
							<font style="COLOR: red">*</font>
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							是否推荐
						</td>
						<td colspan="3" align="left">
							<input type="radio" name="isRecommend" value="0"
								<c:if test="${ma.isRecommend==0}"> checked="checked" </c:if>>
							是
							<input type="radio" name="isRecommend" value="1"
								<c:if test="${ma.isRecommend==1}"> checked="checked" </c:if>>
							否
						</td>
					</tr>
					<tr height="30">
						<td width="75">
							<a href=""><input type="button" value="保存"
									style="color: #069" onclick="checkSubmit()"> </a>
						</td>
						<td colspan="3" align="left">
							<c:if test="${ma.maName!=null}">
								<a href=""><input type="button" value="キャンセル"
										style="color: #069"
										onclick="goTarget('viewMa.do?maID=${ma.maID}')"> </a>
							</c:if>
							<c:if test="${ma.maName==null}">
								<a href=""><input type="button" value="キャンセル"
										style="color: #069"
										onclick="goTarget('viewType.do?typeID=${ma.maType}')">
								</a>
							</c:if>
						</td>
					</tr>
				</table>
			</html:form>
		</div>
	</body>
</html>
