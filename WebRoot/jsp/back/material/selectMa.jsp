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
	
	function doLogin() {
		var selectForm = document.getElementById('SelectForm');
		selectForm.submit();
	}
</script>
	<body>
		<div class="divStyle1">
			<table width="" height="" border="0" bordercolor="#000000" id="tb"
				style="text-align: left; font-size: 12px;">
				<html:form action="selectMa.do" method="post"
					enctype="multipart/form-data">
					<tr>
						<td>
							キーワード
							<input type="text" name="keyword" value="${keyword}" />
							<input type="hidden" name="page" value="0" />
													
                                 <input type="submit" value="探す" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;">
						
						</td>
					</tr>
				</html:form>
			</table>
		</div>
		<br>
		<div class="divStyle1">
			<table width="" height="" border="0" bordercolor="#000000" id="tb"
				style="text-align: center; font-size: 12px;">
				<c:if test="${ma==null}">暂时无相关记录!</c:if>
				<c:if test="${ma!=null}">
					<tr height="30">
						<td width="30">
						</td>
						<td width="200" colspan="2" valign="bottom">
							<font class="aStyle1">共${pages}页&nbsp;${count}条</font>
						</td>
						<td width="350" colspan="3" align="right">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a class="aStyle1" href="selectMa.do?keyword=${keyword}&&page=0">首页</a>
							<c:if test="${((pages-page)==1)&&((page-3)>0)}">
								<a class="aStyle"
									href="selectMa.do?keyword=${keyword}&&page=${page-4}">${page-3}</a>
							</c:if>
							<c:if test="${((pages-page)<=2)&&((page-2)>0)}">
								<a class="aStyle"
									href="selectMa.do?keyword=${keyword}&&page=${page-3}">${page-2}</a>
							</c:if>
							<c:if test="${(page-1)>0}">
								<a class="aStyle"
									href="selectMa.do?keyword=${keyword}&&page=${page-2}">${page-1}</a>
							</c:if>
							<c:if test="${page>0}">
								<a class="aStyle"
									href="selectMa.do?keyword=${keyword}&&page=${page-1}">${page}</a>
							</c:if>
							<font class="aStyle2">${page+1}</font>
							<c:if test="${(page+2)<=pages}">
								<a class="aStyle"
									href="selectMa.do?keyword=${keyword}&&page=${page+1}">${page+2}</a>
							</c:if>
							<c:if test="${(page+3)<=pages}">
								<a class="aStyle"
									href="selectMa.do?keyword=${keyword}&&page=${page+2}">${page+3}</a>
							</c:if>
							<c:if test="${((page+1)<=2)&&(4<=pages)}">
								<a class="aStyle"
									href="selectMa.do?keyword=${keyword}&&page=${page+3}">${page+4}</a>
							</c:if>
							<c:if test="${((page+2)<=2)&&(5<=pages)}">
								<a class="aStyle"
									href="selectMa.do?keyword=${keyword}&&page=${page+4}">${page+5}</a>
							</c:if>
							<a class="aStyle1"
								href="selectMa.do?keyword=${keyword}&&page=${pages-1}">尾页</a>
							<input type="text" id="pageNum" style="width: 25px; height: 20px"
								align="right" />
							&nbsp;&nbsp;&nbsp;
						</td>
						<td width="75">
							<input type="button" value="" onmouseover="checkCursor(this)"
								style=" width: 49px;height: 28px;border-style: none;background: url('<%=path%>/img/back/button/btnGo.GIF');"
								onclick="goPage('selectMa.do?keyword=${keyword}&&page=')">
						</td>
					</tr>
					<tr height="10">
						<td colspan="6">
							<img src="<%=path%>/img/back/common/line.GIF" width="100%"
								height="1px"></img>
						</td>
					</tr>
					<tr height="30">
						<td width="30"></td>
						<td width="75">
							型号
						</td>
						<td width="200">
							名称
						</td>
						<td width="75">
							单价
						</td>
						<td width="200">
							最后修改时间
						</td>
						<td width="75">
							第${page+1}页
						</td>
					</tr>
					<html:form action="deleteMa.do">
						<input type="hidden" name="keyword" value="${keyword}">
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
									${ma.maUpdateTime}
								</td>
								<td width="75">
									<input type="button" value="" onmouseover="checkCursor(this)"
										style=" width: 41px;height: 18px;border-style: none;background: url('<%=path%>/img/back/button/btnView.GIF');"
										onclick="openNewWindow('viewMa.do?maID=${ma.maID}')">
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
								<input type="submit" value="" onmouseover="checkCursor(this)"
									style=" width: 49px;height: 28px;border-style: none;background: url('<%=path%>/img/back/button/btnDelete.GIF');">
							</td>
							<td width="350" colspan="3">

							</td>
							<td width="200">
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
