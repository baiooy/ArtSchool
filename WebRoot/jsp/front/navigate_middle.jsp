<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>
	<head>
		<meta http-equiv="Expires" content="0">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<link href="<%=path%>/css/front.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" type="text/JavaScript"
			src="<%=path%>/js/back.js"></script>
		<style type="text/css">
.leftTable1 {
	height: 315px;
	width: 100%;
	border-left: 1px solid #E8EAE9;
	border-top: 1px solid #E8EAE9;
}

.leftTable2 {
	height: 380px;
	width: 100%;
	border-left: 1px solid #E8EAE9
}

.rightTable1 {
	width: 100%;
	height: 100%;
	border-left: 1px solid #C6CACB;
	margin-left: 0px;
	border-right: 1px solid #C6CACB;
	margin-right: 0px;
	border-top: 1px solid #C6CACB;
	margin-top: 0px;
}

.rightTable2 {
	width: 100%;
	border: 1px solid #C6CACB;
}

.front1 {
	font-size: 13px;
	color: #FF0000;
	font-weight: bold;
}

.front2 {
	font-size: 12px;
	color: #666666;
}

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
		<script type="text/javascript">
	function changeSortTable(temp) {
		var table1 = document.getElementById("sortTable1");
		var table2 = document.getElementById("sortTable2");
		var next = document.getElementById("btnNext");
		var back = document.getElementById("btnBack");
		if (1 == temp) {
			table1.style.display = '';
			next.style.display = '';
			table2.style.display = 'none';
			back.style.display = 'none';
		} else if (2 == temp) {
			table1.style.display = 'none';
			next.style.display = 'none';
			table2.style.display = '';
			back.style.display = '';
		}
	}
	function doLogin() {
		var loginForm = document.getElementById('LoginForm');
		loginForm.submit();
	}
</script>
	</head>

	<body>
		<table width="910" align="center">
			<tr>
				<td>
					<table style="width: 654px;">
						<tr>
							<td>
								<table class="leftTable1" cellspacing="0">
									<tr height="27">
										<td background="<%=path%>/img/front/common/blueBar.gif"
											width="494">
											<img src="<%=path%>/img/front/common/sign.gif" width="13"
												height="13">
											&nbsp;
											<font class="front1">ピアノの教室を推薦</font>
										</td>
										<td width="80" align="right"
											background="<%=path%>/img/front/common/blueBar.gif">
											<c:if test="${page>0}">
												<img src="<%=path%>/img/front/button/back.GIF"
													onClick="goTarget('navigate.do?navigateID=${navigateID}&page=${page-1}')"
													onmouseover="checkCursor(this)">
											</c:if>
										</td>
										<td width="80" align="center"
											background="<%=path%>/img/front/common/blueBar.gif">
											<c:if test="${page<(pages-1)}">
												<img src="<%=path%>/img/front/button/next.GIF"
													onClick="goTarget('navigate.do?navigateID=${navigateID}&page=${page+1}')"
													onmouseover="checkCursor(this)">
											</c:if>
										</td>
									</tr>
									<tr height="15">
										<td colspan="3"></td>
									</tr>
									<tr height="288">
										<td colspan="3" valign="top" align="left">
											<table style="margin-left: 10px">
												<tr height="85">
													<c:forEach var="recommend" items="${recommend}">
														<td width="100">
															<div style="width: 100%; height: 60px;" align="center">
																<a href="detail.do?maID=${recommend.maID}"> <img
																		src="<%=path%>${recommend.maPicPath}"
																		style="display: none" onload="autoSize(this,90,60)"></img>
																</a>
															</div>
															<div
																style="width: 100%; height: 35px; font-size: 13px; color: #666666;"
																align="center">
																<a href="detail.do?maID=${recommend.maID}">
																	${recommend.maName}</a>
															</div>
														</td>
														<c:if test="${recommend.rowNum%6==0}">
												</tr>
												<tr>
													</c:if>
													</c:forEach>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table class="leftTable2" cellspacing="0">
									<tr height="27">
										<td background="<%=path%>/img/front/common/blueBar.gif"
											width="574">
											<img src="<%=path%>/img/front/common/sign.gif" width="13"
												height="13">
											&nbsp;
											<font class="front1">地区は区分</font>
										</td>
										<td width="80" align="center"
											background="<%=path%>/img/front/common/blueBar.gif">
											<img id="btnNext" src="<%=path%>/img/front/button/next.GIF"
												onClick="changeSortTable(2)" onmouseover="checkCursor(this)">
											<img id="btnBack" src="<%=path%>/img/front/button/back.GIF"
												onClick="changeSortTable(1)" style="display: none"
												onmouseover="checkCursor(this)">
										</td>
									</tr>

									<tr valign="top">
										<td>
											<table width="100%" id="sortTable1">
												<tr height="100" valign="middle">
													<td width="20%" align="right">
														<img src="<%=path%>${wood}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">北海道</font>
																	</td>
																</tr>
																<tr>
																	<c:forEach var="sort" items="${type1}">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>

													<td width="20%" align="right">
														<img src="<%=path%>${stone}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">北東</font>
																	</td>
																</tr>
																<tr>

																	<c:forEach var="sort" items="${type2}"
																		varStatus="status">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>
												</tr>
												<tr height="100" valign="middle">
													<td width="20%" align="right">
														<img src="<%=path%>${ceramics}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">中部</font>
																	</td>
																</tr>
																<tr>
																	<c:forEach var="sort" items="${type3}">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>

													<td width="20%" align="right">
														<img src="<%=path%>${glass}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">関東</font>
																	</td>
																</tr>
																<tr>
																	<c:forEach var="sort" items="${type4}">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>
												</tr>
												<tr height="100" valign="middle">
													<td width="20%" align="right">
														<img src="<%=path%>${plastic}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">近畿</font>
																	</td>
																</tr>
																<tr>
																	<c:forEach var="sort" items="${type5}">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>

													<td width="20%" align="right">
														<img src="<%=path%>${carpet}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">中国</font>
																	</td>
																</tr>
																<tr>
																	<c:forEach var="sort" items="${type6}">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>
												</tr>
											</table>

											<table width="100%" id="sortTable2" style="display: none">
												<tr height="100" valign="middle">
													<td width="20%" align="right">
														<img src="<%=path%>${paint}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">四国</font>
																	</td>
																</tr>
																<tr>
																	<c:forEach var="sort" items="${type7}">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>

													<td width="20%" align="right">
														<img src="<%=path%>${wallpaper}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">九州</font>
																	</td>
																</tr>
																<tr>
																	<c:forEach var="sort" items="${type8}">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>
												</tr>

												<tr height="100" valign="middle">

													

													<td width="20%" align="right">
														<img src="<%=path%>${other}" width="80" height="80">
													</td>
													<td width="30%" align="left">
														<div style="height: 80px; vertical-align: top">
															<table style="" class="front2">
																<tr>
																	<td colspan="3">
																		<font
																			style="font-weight: bold; color: #0577b5; FONT-SIZE: 12px;">其他</font>
																	</td>
																</tr>
																<tr>
																	<c:forEach var="sort" items="${type12}">
																		<td width="50" align="left">
																			<a href="sortLevel.do?typeID=${sort.typeID}">${sort.typeName}</a>
																		</td>
																		<c:if test="${sort.rowNum%3==0}">
																</tr>
																<tr>
																	</c:if>
																	</c:forEach>
																</tr>

															</table>
														</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td valign="top">
					<table style="width: 250px;">
						<tr height="111">
							<td>
								<c:if test="${user==null}">
									<html:form action="login.do" method="post"
										enctype="multipart/form-data">
										<table class="rightTable1">
											<tr>
												<td colspan="2"
													style="width: 100%; height: 29px; font-weight: bold; color: #0577b5; FONT-SIZE: 12px;"
													background="<%=path%>/img/front/common/bluenavi.gif">
													&nbsp;
													<img src="<%=path%>/img/front/common/memberPic.gif"
														width="16" height="15">
													会員の登録
												</td>
											</tr>

											<tr
												style="height: 25px; font-size: 13px; color: #666666; font-family: '宋体', Simsun;">
												<td width="40%">&nbsp;  
													会員ID：  
												</td>
												<td align="left">
													<input type="text" name="userName" style="width: 85px">

												</td>
											</tr>
											<tr
												style="height: 25px; font-size: 13px; color: #666666; font-family: '宋体', Simsun;">
												<td width="40%">&nbsp; 
													パスワード:
												</td>
												<td align="left">
													<input type="password" name="userPass" style="width: 85px">
												</td>
											</tr>
											<tr height="25">
												<td align="center" colspan="2">
													<input type="hidden" name="loginUrl"
														value="/navigate.do?navigateID=${navigateID}&page=${page}">
													<a onClick="doLogin()" onmouseover="checkCursor(this)">
														<span style="font-size: 14; color: #cc9988">ログイン</span> </a>
													&nbsp;
													<a href="<%=path%>/jsp/front/regist.jsp"><span
														style="font-size: 14; color: #cc9988">会員は登録</span> </a>
												</td>
											</tr>
										</table>
									</html:form>
								</c:if>
								<c:if test="${user!=null}">
									<html:form action="login.do" method="post"
										enctype="multipart/form-data">
										<table class="rightTable1">
											<tr>
												<td colspan="2"
													style="width: 100%; height: 29px; font-weight: bold; color: #0577b5; FONT-SIZE: 12px;"
													background="<%=path%>/img/front/common/bluenavi.gif">
													&nbsp;
													<img src="<%=path%>/img/front/common/memberPic.gif"
														width="16" height="15">
													お帰り
												</td>
											</tr>

											<tr
												style="height: 25px; font-size: 13px; color: #666666; font-family: '宋体', Simsun;">
												<td width="40%" align="right">会員I：  
												</td>
												<td align="left">
													${user.userName}
												</td>
											</tr>
											<tr
												style="height: 25px; font-size: 13px; color: #666666; font-family: '宋体', Simsun;">
												<td width="40%" align="right">
													愛称：
												</td>
												<td align="left">
													${user.userCall}
												</td>
											</tr>
											<tr height="25">
												<td align="center" colspan="2">
													<c:if test="${user.userRole==3}">
														<input type="hidden" name="loginUrl"
															value="<%=path%>/navigate.do?navigateID=${navigateID}&page=${page}">
														<img src="<%=path%>/img/front/button/btnUpdate.GIF"
															onClick="goTarget('<%=path%>/jsp/front/regist.jsp')"
															onmouseover="checkCursor(this)" width="65" height="20">
													&nbsp;</c:if>
													<a
														onClick="goTarget('quit.do?backUrl=/navigate.do?navigateID=${navigateID}&page=${page}')"
														onmouseover="checkCursor(this)"><span
														style="font-size: 14; color: #cc9988">退出</span> </a>

												</td>
											</tr>
										</table>
									</html:form>
								</c:if>
							</td>
						</tr>
						<tr height="500" valign="top">
							<td>
								<table class="rightTable2">
									<tr>
										<td colspan="4"
											style="width: 100%; height: 29px; font-weight: bold; color: #0577b5; FONT-SIZE: 12px;"
											background="<%=path%>/img/front/common/bgBlue.gif">
											&nbsp;
											<img src="<%=path%>/img/front/common/downloadPic.gif"
												width="15" height="15"> 
											教室のランキング  
										</td>
									</tr>
									<tr height="393" valign="top">
										<td>
											<table style="font-size: 12px; color: #666666;" border="0"
												cellspacing="5" cellpadding="0">
												<tr>
													<c:forEach var="topdown" items="${topdown}">
														<td width="25%" align="center">
															<img src="<%=path%>${topdown.maPicPath}"
																style="display: none" onload="autoSize(this,42,41)">
														</td>
														<td width="25%">
															<div
																style="word-break: break-all; overflow: hidden; width: 60px;">
																<a href="detail.do?maID=${topdown.maID}">${topdown.maName}</a>
																<br>
																<font style="color: green">[${topdown.downCount}]</font>
															</div>
														</td>
														<c:if test="${topdown.rowNum%2==0}">
												</tr>
												<tr>
													</c:if>
													</c:forEach>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
