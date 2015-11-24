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
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<link href="<%=path%>/css/head.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<%=path%>/js/back.js"></script>
		<style type="text/css">
.OverFont {
	BACKGROUND-POSITION: left top;
	FONT-WEIGHT: bold;
	FONT-SIZE: 12px;
	CURSOR: hand;
	COLOR: #ffffff;
	PADDING-TOP: 5px;
	TEXT-ALIGN: center
}

.OutFont {
	BACKGROUND-POSITION: left top;
	FONT-SIZE: 12px;
	CURSOR: hand;
	COLOR: #000000;
	PADDING-TOP: 5px;
	TEXT-ALIGN: center
}
</style>
		<script type="text/javascript">
	function doSortLevel() {
		var sortLevelForm = document.getElementById('SortLevelForm');
		sortLevelForm.submit();
	}
</script>
	</head>
	<body>
		<table width="900" height="131" border="0" align="center">
			<tr>
				<td width="900" align="left" valign="middle">
					<img width="212" height="35" src="<%=path%>${logo}">
					<br>
					<span class="engHead">
						&nbsp;Decorative&nbsp;&nbsp;Materials&nbsp;&nbsp;Gallery</span>
					<br>
				</td>
			</tr>

			<tr>
				<td align="center" valign="middle">
					<TABLE height=26 cellSpacing=0 cellPadding=0 width=840 border=0
						align="center">
						<TBODY>
							<TR>

								<TD width="60px"
									<c:if test="${navigateID==0}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=0}">background="<%=path%>/img/front/common/cart.gif" class="OutFont" </c:if>
									class="OutFont" onclick="goTarget('<%=path%>/index.jsp')"> 
									ウェブサイ  
								</TD>
								<TD width="60px"
									<c:if test="${navigateID==1}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=1}">background="<%=path%>/img/front/common/cart.gif" class="OutFont" </c:if>
									onclick="goTarget('navigate.do?navigateID=1')"> 
									北海道</TD>
								<TD width="60px"
									<c:if test="${navigateID==2}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=2}">background="<%=path%>/img/front/common/cart.gif" class="OutFont" </c:if>
									onclick="goTarget('navigate.do?navigateID=2')"> 
									北東</TD>
								<TD width="60px"
									<c:if test="${navigateID==3}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=3}">background="<%=path%>/img/front/common/cart.gif" class="OutFont"</c:if>
									onclick="goTarget('navigate.do?navigateID=3')"> 
									中部</TD>
								<TD width="60px"
									<c:if test="${navigateID==4}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=4}">background="<%=path%>/img/front/common/cart.gif" class="OutFont" </c:if>
									onclick="goTarget('navigate.do?navigateID=4')"> 
									関東</TD>
								<TD width="60px"
									<c:if test="${navigateID==5}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=5}">background="<%=path%>/img/front/common/cart.gif" class="OutFont"</c:if>
									onclick="goTarget('navigate.do?navigateID=5')">
									近畿
								</TD>
								<TD width="60px"
									<c:if test="${navigateID==6}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=6}">background="<%=path%>/img/front/common/cart.gif" class="OutFont"</c:if>
									onclick="goTarget('navigate.do?navigateID=6')"> 
									中国</TD>
								<TD width="60px"
									<c:if test="${navigateID==7}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=7}">background="<%=path%>/img/front/common/cart.gif" class="OutFont" </c:if>
									onclick="goTarget('navigate.do?navigateID=7')"> 
									四国</TD>
								<TD width="60px"
									<c:if test="${navigateID==8}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=8}">background="<%=path%>/img/front/common/cart.gif" class="OutFont" </c:if>
									onclick="goTarget('navigate.do?navigateID=8')"> 
									九州</TD>
								
								<TD width="60px"
									<c:if test="${navigateID==12}">background="<%=path%>/img/front/common/cartOver.gif" class="OverFont"</c:if>
									<c:if test="${navigateID!=12}">background="<%=path%>/img/front/common/cart.gif" class="OutFont" </c:if>
									onclick="goTarget('navigate.do?navigateID=12')">
									其他
								</TD>

								<TD vAlign=middle background="">
									&nbsp;
								</TD>
							</TR>
						</TBODY>
					</TABLE>

					<div class="channel">
						<TABLE width=900 height=32 border=0 align="left" cellPadding=0
							cellSpacing=0>
							<TBODY>
								<html:form action="sortLevel.do" method="post"
									enctype="multipart/form-data">
									<TR>
										<TD width="900"
											background="<%=path%>/img/front/common/bar.gif">
											&nbsp;&nbsp;
											<img src="<%=path%>/img/front/common/findPic.gif" width="22"
												height="22" align="middle" id="findPic">
											<span class="font_01">地区の捜索 ：</span>
											<select class="select" name="typeID"
												style="vertical-align: middle">
												<option value="0"
													<c:if test="${navigateID==0}">selected</c:if>>
													全部資料
												</option>

												<option value="1"
													<c:if test="${navigateID==1}">selected</c:if>>
													北海道
												</option>
												<option value="2"
													<c:if test="${navigateID==2}">selected</c:if>>
													北東
												</option>
												<option value="3"
													<c:if test="${navigateID==3}">selected</c:if>>
													中部
												</option>
												<option value="4"
													<c:if test="${navigateID==4}">selected</c:if>>
													関東
												</option>
												<option value="5"
													<c:if test="${navigateID==5}">selected</c:if>>
													塑料
												</option>
												<option value="6"
													<c:if test="${navigateID==6}">selected</c:if>>
													中国
												</option>
												<option value="7"
													<c:if test="${navigateID==7}">selected</c:if>>
													四国
												</option>
												<option value="8"
													<c:if test="${navigateID==8}">selected</c:if>>
													九州
												</option>
												<option value="12"
													<c:if test="${navigateID==12}">selected</c:if>>
													其他
												</option>
											</select>
											<input type="text" class="text" name="keyword" size="15"
												value="${keyword}" style="vertical-align: middle">
											<a onclick="doSortLevel()" onmousemove="checkCursor(this)">
												<span style="font-size: 15;color: #ff0000">捜索</span></a>
											&nbsp;&nbsp;
										</TD>
									</TR>
								</html:form>
							</TBODY>
						</TABLE>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>