<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<link href="<%=path%>/css/front.css" rel="stylesheet" type="text/css">
		<style type="text/css">
a:link {
	color: #666666;
	text-decoration: none;
}

a:active {
	text-decoration: none;
}

a:visited {
	color: #666666;
	text-decoration: none;
}

a:hover {
	color: blue;
	text-decoration: underline;
}

img {
	border: 0
}
</style>
	</head>

	<body>
		<table width="910" height="644" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr height="25">
				<td colspan="2">
					<font class="front2">&nbsp;当面の位置 :<a href="navigate.do">トップページ </a>
						<c:forEach var="allType" items="${allType}">&gt;&nbsp;<a
								href="sortLevel.do?typeID=${allType.typeID}">${allType.typeName}</a>
						</c:forEach> </font>
				</td>
			</tr>
			<tr>
				<td align="left" valign="top">
					<table
						style="width: 680px; height: 644px; border: 1px solid #C6CACB; margin-left: 2px">
						<tr height="27">
							<td colspan="2">
								&nbsp;&nbsp;
								<img src="<%=path%>/img/front/sortLevel/naturePic.gif"
									width="16" height="14">
								&nbsp;
								<font
									style="font-weight: bold; font-size: 14px; font-family: '宋体', Simsun; color: red;">${type.typeName}地区</font>
							</td>
							<td colspan="2" align="right">
								<a href="sortLevel.do?typeID=${type.typeParent}"> <font
									class="front1" color="#000000">トップに戻るカテゴリーへ&nbsp;&nbsp;&nbsp;</font>
								</a>
							</td>
						</tr>
						<tr height="27">
							<td colspan="2" align="left"
								background="<%=path%>/img/front/listView/blueBar.gif">
								<font class="front1"> &nbsp;&nbsp;第${page+1}页 共${pages}页
									16条/页 共：${count}条</font>
							</td>
							<td colspan="2" align="right"
								background="<%=path%>/img/front/listView/blueBar.gif">
								<font class="front1"> <a
									href="sortLevel.do?typeID=${type.typeID}&keyword=${keyword}&page=0">最初のページ </a>
									<c:if test="${page>0}">
										<a
											href="sortLevel.do?typeID=${type.typeID}&keyword=${keyword}&page=${page-1}">前のページ</a>
									</c:if> <c:if test="${page<(pages-1)}">
										<a
											href="sortLevel.do?typeID=${type.typeID}&keyword=${keyword}&page=${page+1}">次のページ</a>
									</c:if> <a
									href="sortLevel.do?typeID=${type.typeID}&keyword=${keyword}&page=${pages-1}">最後のページ</a>
									&nbsp;&nbsp;</font>
							</td>
						</tr>
						<tr height="5">
							<td colspan="4"></td>
						</tr>
						<tr height="130">
							<c:forEach var="ma" items="${maList}">
								<td width="25%" align="center">
									<div style="width: 150; height: 90px;" align="center">
										<a href="detail.do?maID=${ma.maID}"><img
												src="<%=path%>${ma.maPicPath}" style="display: none"
												onload="autoSize(this,150,90)"></img> </a>
									</div>
									<div style="width: 100%; height: 40px;" align="center">
										<font class="fontPhoto"><a
											href="detail.do?maID=${ma.maID}">${ma.maName}</a> </font>
									</div>
								</td>
								<c:if test="${ma.rowNum%4==0}">
						</tr>
						<tr>
							</c:if>
							</c:forEach>
						</tr>
						<tr height="100%">
							<td colspan="4"></td>
						</tr>
					</table>
				</td>
				<td valign="top">
					<table cellpadding="0" cellspacing="0"
						style="width: 200px; border: 1px solid #E8EAE9;">
						<tr height="22" valign="middle">
							<td background="<%=path%>/img/front/common/bgBlue.gif">
								&nbsp;
								<font class="fontTitle">${type.typeName}地区分類</font>
							</td>
						</tr>
						<tr height="">
							<td valign="top">
								<table cellpadding="0" cellspacing="0">
									<c:forEach var="childType" items="${childType}">
										<tr height="22">
											<td>
												&nbsp;
												<img src="<%=path%>/img/front/sortLevel/arrow_01.gif">
												<a href="sortLevel.do?typeID=${childType.typeID}"> <font
													class="fontTitle">${childType.typeName}</font> </a>
											</td>
										</tr>
									</c:forEach>
									<tr height="22">
										<td>
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>


						<tr height="22" valign="middle">
							<td background="<%=path%>/img/front/common/bgBlue.gif"
								style="border-top: 1px solid #E8EAE9;">
								&nbsp;
								<font class="fontTitle">${type.typeName}地区教室排行</font>
							</td>
						</tr>
						<tr height="220">
							<td valign="top">
								<table cellpadding="0" cellspacing="0">
									<c:forEach var="topDown" items="${topDown}">
										<tr height="22">
											<td>
												&nbsp;
												<img src="<%=path%>/img/front/sortLevel/arrow_02.gif">
												<font class="fontPhoto"><a
													href="detail.do?maID=${topDown.maID}">${topDown.maName}</a>[<font
													style="color: green">${topDown.downCount}</font>]</font>
											</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<tr height="100%">
							<td></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
