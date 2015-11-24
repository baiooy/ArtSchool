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
	function goPage(url) {
		var obj = document.getElementById('pageNum');
		var page = obj.value;
		if (isNaN(page) || (page < 1)) {
			alert('请输入一个正确的数字');
		} else {
		if(page>${pages}){
		
		alert('不存在的页面')
		}
		else{
			window.open(url + (page - 1), "_self");
		}
		}
	}
	function onSave(str) {
	　var addLabel=document.getElementById('addLabel');
	  var updateLabel=document.getElementById('updateLabel');
	　var updateButton=document.getElementById('updateButton');
	　var cancelButton=document.getElementById('cancelButton');
	  updateButton.style.display='none';
	  cancelButton.style.display='';
	  if(str=='add'){
	  addLabel.style.display='';
	  updateLabel.style.display='none';
	  }
	  else if(str=='update'){
	  addLabel.style.display='none';
	  updateLabel.style.display='';
	  }
	 }
	function onCancel() {
	  var addLabel=document.getElementById('addLabel');
	  var updateLabel=document.getElementById('updateLabel');
	　var updateButton=document.getElementById('updateButton');
	　var cancelButton=document.getElementById('cancelButton');
	  addLabel.style.display='none';
	  updateLabel.style.display='none';
	  updateButton.style.display='';
	  cancelButton.style.display='none';
	}
	 
  function  changeAction()   
  {     
  document.DoForm.action='changeRecommend.do';
  document.DoForm.submit();   
  }   

</script>
	<body>
		<div class="divStyle1" align="left">
			<table width="" height="" border="0" align="left"
				bordercolor="#000000" id="tb"
				style="COLOR: #069; text-align: center; font-size: 13px;">
				<tr height="30">
					<td width="75">
						名称
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${type.typeName}
						</DIV>
					</td>
					<td width="75">
						上のレベル
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${type.parentName}
						</DIV>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						<div id="updateButton">
							<input type="button" value="更新" onclick="onSave('update');"
								onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;">
						</div>
						<div id="cancelButton" style="display: none">
							<input type="button" value="キャンセル" onclick="onCancel()"
								style=" width: 60px;height: 28px;border-style: none;"
								onmouseover="checkCursor(this)">
						</div>
					</td>
					<td width="200" align="left">
						<input type="button" value="地域に追加" onmouseover="checkCursor(this)"
							onclick="onSave('add')"
							style=" width: 83px;height: 28px;border-style: none;">
						<input type="button" value="教室に追加" onmouseover="checkCursor(this)"
							style=" width: 83px;height: 28px;border-style: none;"
							onclick="goTarget('readyMa.do?operation=add&&typeID=${type.typeID}')">
					</td>
					<td width="75">
						<c:if test="${(ma==null)&&(type.typeParent!=0)}">
							<input type="submit" value="削除" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;"
								onclick="goTarget('deleteType.do?typeID=${type.typeID}&&typeParent=${type.typeParent}')">
						</c:if>
					</td>
					<td width="200" align="left">
					</td>
				</tr>
				<html:form action="saveType.do" method="post"
					enctype="multipart/form-data">
					<tr height="30" id="addLabel" style="display: none">
						<td width="75">
							<input type="submit" value="保存" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;">
						</td>
						<td width="200" align="left">
							追加
							<input type="hidden" name="typeParent" value="${type.typeID}">
							<input type="text" name="typeName" size="19" maxlength="6">
						</td>
						<td width="75">

						</td>
						<td width="200" align="left">

						</td>
					</tr>
				</html:form>
				<html:form action="saveType.do" method="post"
					enctype="multipart/form-data">
					<tr height="30" id="updateLabel" style="display: none">
						<td width="75">
							<input type="submit" value="保存" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;">
						</td>
						<td width="200" align="left">
							更新
							<input type="hidden" name="typeID" value="${type.typeID}">
							<input type="text" name="typeName" size="19"
								value="${type.typeName}" maxlength="6">
						</td>
						<td width="75">

						</td>
						<td width="200" align="left">

						</td>
					</tr>
				</html:form>
			</table>

		</div>
		<br>
		<div class="divStyle1">
			<table width="" height="" border="0" bordercolor="#000000" id="tb"
				style="text-align: center; font-size: 12px;">
				<c:if test="${ma==null}">一時的に関連性の記録ない!</c:if>
				<c:if test="${ma!=null}">
					<tr height="30">
						<td width="30">
						</td>
						<td width="200" colspan="2" valign="bottom">
							<font class="aStyle1">共${pages}页&nbsp;${count}条</font>
						</td>
						<td width="350" colspan="2" align="right">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a class="aStyle1"
								href="viewType.do?typeID=${type.typeID}&&page=0">首页</a>
							<c:if test="${((pages-page)==1)&&((page-3)>0)}">
								<a class="aStyle"
									href="viewType.do?typeID=${type.typeID}&&page=${page-4}">${page-3}</a>
							</c:if>
							<c:if test="${((pages-page)<=2)&&((page-2)>0)}">
								<a class="aStyle"
									href="viewType.do?typeID=${type.typeID}&&page=${page-3}">${page-2}</a>
							</c:if>
							<c:if test="${(page-1)>0}">
								<a class="aStyle"
									href="viewType.do?typeID=${type.typeID}&&page=${page-2}">${page-1}</a>
							</c:if>
							<c:if test="${page>0}">
								<a class="aStyle"
									href="viewType.do?typeID=${type.typeID}&&page=${page-1}">${page}</a>
							</c:if>
							<font class="aStyle2">${page+1}</font>
							<c:if test="${(page+2)<=pages}">
								<a class="aStyle"
									href="viewType.do?typeID=${type.typeID}&&page=${page+1}">${page+2}</a>
							</c:if>
							<c:if test="${(page+3)<=pages}">
								<a class="aStyle"
									href="viewType.do?typeID=${type.typeID}&&page=${page+2}">${page+3}</a>
							</c:if>
							<c:if test="${((page+1)<=2)&&(4<=pages)}">
								<a class="aStyle"
									href="viewType.do?typeID=${type.typeID}&&page=${page+3}">${page+4}</a>
							</c:if>
							<c:if test="${((page+2)<=2)&&(5<=pages)}">
								<a class="aStyle"
									href="viewType.do?typeID=${type.typeID}&&page=${page+4}">${page+5}</a>
							</c:if>
							<a class="aStyle1"
								href="viewType.do?typeID=${type.typeID}&&page=${pages-1}">尾页</a>
							<input type="text" id="pageNum" style="width: 25px; height: 20px"
								align="right" />
							&nbsp;&nbsp;&nbsp;
						</td>
						<td width="75">
							<input type="button" value="" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;background: url('<%=path%>/img/back/button/btnGo.GIF');"
								onclick="goPage('viewType.do?typeID=${type.typeID}&&page=')">
						</td>
					</tr>
					<tr height="10">
						<td colspan="6">
							<img src="<%=path%>/img/back/common/line.GIF" width="100%"
								height="1px"></img>
						</td>
					</tr>
					<html:form action="deleteMa.do">
						<tr height="30">
							<td width="30">
							</td>
							<td width="75">
								モデル
							</td>
							<td width="200">
								名称
							</td>
							<td width="75">
								価格
							</td>
							<td width="200">
								推荐?
							</td>
							<td width="75">
								ページ${page+1}
							</td>
						</tr>
						<input type="hidden" name="typeID" value="${type.typeID}">
						<input type="hidden" name="page" value="${page}">
						<c:forEach var="ma" items="${ma}">
							<tr height="30">
								<td width="30">
									<input type="checkbox" name="maIDs" value="${ma.maID}">
								</td>
								<td width="75">
									${ma.maCode}
								</td>
								<td width="200">
									${ma.maName}
								</td>
								<td width="75">
									${ma.maPrice1}元
								</td>
								<td width="200">

									<input type="checkbox" name="isIDs" value="${ma.maID}"
										<c:if test="${ma.isRecommend==0}"> checked="checked" </c:if>>
								</td>
								<td width="75" valign="middle">
									<input type="button" value="視野" onmouseover="checkCursor(this)"
										style=" width: 41px;height: 18px;border-style: none;"
										onclick="goTarget('viewMa.do?maID=${ma.maID}')">
								</td>
							</tr>
						</c:forEach>
						<tr height="10">
							<td colspan="6">
								<img src="<%=path%>/img/back/common/line.GIF" width="100%"
									height="1px"></img>
							</td>
						</tr>
						<tr height="30">
							<td width="30">
								<input type="submit" value="削除" onmouseover="checkCursor(this)"
									style=" width: 49px;height: 28px;border-style: none;">
							</td>
							<td width="350" colspan="3">

							</td>
							<td width="200">
								<input type="button" value="推荐保存" onmouseover="checkCursor(this)"
									onclick="changeAction()"
									style=" width: 83px;height: 28px;border-style: none;">
							</td>
							<td width="75">

							</td>
						</tr>
					</html:form>
				</c:if>
			</table>
		</div>
	</body>
</html>
