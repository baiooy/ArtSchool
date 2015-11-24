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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>東京都のピアノ教室</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<link href="<%=path%>/css/front.css" rel="stylesheet" type="text/css">
		<style type="text/css">
.front1 {
	font-weight: bold;
	font-size: 12px;
	font-family: '宋体', Simsun;
}

.frontRetitle {
	font-weight: bold;
	font-size: 13px;
	font-family: '宋体', Simsun;
}

.label1 {
	text-align: center;
	font-size: 12px;
	font-family: '宋体', Simsun;
	color: #666666;
}

.label2 {
	text-align: left;
	font-size: 12px;
	font-family: '宋体', Simsun;
	color: #666666;
}

.label3 {
	text-align: center;
	font-size: 12px;
	font-family: '宋体', Simsun;
	color: #666666;
	border-top: 1px solid #E8EAE9;
}

.label4 {
	text-align: left;
	font-size: 12px;
	font-family: '宋体', Simsun;
	color: #666666;
	border-top: 1px solid #E8EAE9;
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
	function checkreview(model) {
		var btnView = document.getElementById('btnView');
		var btnHide = document.getElementById('btnHide');
		var review = document.getElementById('review');
		if (model == 0) {
			btnView.style.display = '';
			btnHide.style.display = 'none';
			review.style.display = 'none';
		} else if (model == 1) {
			btnView.style.display = 'none';
			btnHide.style.display = '';
			review.style.display = '';
		}
	}
</script>
	</head>

	<body>
		<table width="910" height="100%" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr height="25">
				<td colspan="2">
					<font class="front2">&nbsp;当面の位置 :<a href="navigate.do">トップページ
					</a> <c:forEach var="allType" items="${allType}">&gt;&nbsp;<a
								href="sortLevel.do?typeID=${allType.typeID}">${allType.typeName}</a>
						</c:forEach> </font>
				</td>
			</tr>
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0"
						style="width: 680px; height: 555px; border: 1px solid #E8EAE9; margin-left: 2px">
						<tr height="30">
							<td align="left" colspan="3">
								&nbsp;
								<font
									style="font-weight: bold; font-size: 14px; font-family: '宋体', Simsun; color: red;">${ma.maName}</font>
							</td>
							<td align="right" colspan="3">
								<c:if test="${back!=null}">
									<a onclick="goTarget('detail.do?maID=${back.maID}')"
										onmousemove="checkCursor(this)"><span
										style="font-size: 14; color: #cc9966">前へ</span>
									</a>
									<font style="font-size: 12px">${back.maName}</font>
								</c:if>
								<c:if test="${next!=null}">
									<a onclick="goTarget('detail.do?maID=${next.maID}')"
										onmousemove="checkCursor(this)"><span
										style="font-size: 14; color: #cc9966">次へ</span>
									</a>
									<font style="font-size: 12px">${next.maName}</font>
								</c:if>
								&nbsp;&nbsp;
							</td>
						</tr>
						<tr height="330">
							<td align="center" colspan="6"
								style="border-top: 1px solid #E8EAE9;">
								<img src="<%=path%>${ma.maPicPath}" style="display: none"
									onload="autoSize(this,640,300)"></img>
							</td>
						</tr>
						<tr height="5">
							<td style="border-bottom: 1px solid #E8EAE9;" colspan="6">
								&nbsp;
							</td>
						</tr>

						<tr height="22">
							<td class="label1" width="12%">
								教室の住所:
							</td>
							<td class="label2" width="22%">
								${ma.maCode}
							</td>
							<td class="label1" width="10%">
								モットー:
							</td>
							<td class="label2" width="22%">
								${ma.typeName }
							</td>
							<td class="label1" width="10%">
								料金:
							</td>
							<td class="label2" width="26%">
								${ma.maPrice1 }-${ma.maPrice2 }元
							</td>
						</tr>
						<tr height="22">
							<td class="label1" width="10%">
								ジャンル:
							</td>
							<td class="label2" width="22%">
								${ma.maBranch }
							</td>
							<td class="label1" width="10%">
								詳しい料金:
							</td>
							<td class="label2" width="22%">
								${ma.maOrigin }
							</td>
							<td class="label1" width="10%">
								入会金:
							</td>
							<td class="label2" width="26%">
								${ma.maOtherName }
							</td>
						</tr>
						<tr height="22">
							<td class="label1" width="10%">
								運営費:
							</td>
							<td class="label2" width="22%">
								${ma.maFormat }
							</td>
							<td class="label1" width="10%">
								無料体験:
							</td>
							<td class="label2" width="22%">
								${ma.maBrand }
							</td>
							<td class="label1" width="10%">
								出張:
							</td>
							<td class="label2" width="26%">
								${ma.maGrade }
							</td>
						</tr>
						<tr>
							<td height="44" class="label3">
								レッスン形態:
							</td>
							<td colspan="5" class="label4">
								${ma.maPart }&nbsp;
							</td>
						</tr>
						<tr height="66">
							<td class="label3">
								対応コース:
							</td>
							<td colspan="5" class="label4">
								${ma.maTrait }&nbsp;
							</td>
						</tr>
						<tr height="22">
							<td class="label3">
								評価:
							</td>
							<td colspan="5" class="label4">
								${ma.maEffect }&nbsp;
							</td>
						</tr>
						<tr height="22">
							<td class="label3">
								営業案内:
							</td>
							<td colspan="5" class="label4">
								${ma.maEnvironment}&nbsp;
							</td>
						</tr>
						<tr height="22">
							<td class="label3">
								浏览数:
							</td>
							<td colspan="5" class="label4">
								${ma.clickCount}&nbsp;
							</td>
						</tr>
						
					</table>
				</td>
				<td valign="top">
					<table cellpadding="0" cellspacing="0"
						style="width: 200px; height: 222px; border: 1px solid #C6CACB;">
						<tr height="22" valign="middle">
							<td background="<%=path%>/img/front/common/bgBlue.gif"
								style="border-top: 1px solid #E8EAE9;">
								&nbsp;
								<font class="fontTitle">${type.typeName}地区教室排行</font>
							</td>
						</tr>
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
						<tr height="100%"></tr>
					</table>
				</td>
			</tr>
			<tr height="1">
				<td colspan="2">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table cellpadding="0" cellspacing="0"
						style="width: 680px; border: 1px solid #E8EAE9; margin-left: 2px">
						<tr>
							<td bgcolor="#E8EAE9" style="border-bottom: 1px solid #E8EAE9">
								&nbsp;&nbsp;
								<font class="front1">ユーザー評価</font>
							</td>
							<td align="right" bgcolor="#E8EAE9"
								style="border-bottom: 1px solid #E8EAE9">
								<a style="display: none;" id="btnView" onclick="checkreview(1)"
									onmousemove="checkCursor(this)"> <span
									style="font-size: 14; color: #000000">詳細コメント</span> </a>
								<a id="btnHide" onmousemove="checkCursor(this)"
									onclick="checkreview(0)"> <span
									style="font-size: 14; color: #000000">コメントを隠す</span> </a>
							</td>
						</tr>
						<tr id="review" style="display: ">
							<td colspan="2" align="center">
								<table cellpadding="0" cellspacing="0"
									style="width: 680px; margin-top: 5px; margin-bottom: 5px; font-size: 12px;">
									<tr height="30">
										<td colspan="2">
											&nbsp;&nbsp;&nbsp;
											<font style="font-size: 12px; font-family: '宋体', Simsun;">${count}評論 
												<c:if test="${page>0}">
													<a
														href="<%=path%>/detail.do?maID=${ma.maID}&page=${page-1}">前へ</a>
												</c:if> <c:if test="${page<(pages-1)}">
													<a
														href="<%=path%>/detail.do?maID=${ma.maID}&page=${page+1}">次へ</a>
												</c:if> </font>
										</td>
									</tr>
									<c:forEach var="review" items="${review}" varStatus="status">
										<tr>
											<td bgcolor="#E8EAE9">
												&nbsp;&nbsp;
												<font class="front2">${review.userCall}</font> 発表へ
												${review.reTime}
											</td>
											<td bgcolor="#E8EAE9" align="right">
												<c:if test="${user.userRole==1}">
													<a
														href="deleteRe.do?reID=${review.reID}&backUrl=/detail.do?maID=${ma.maID}">削除
													</a>&nbsp;&nbsp;&nbsp;&nbsp;
												</c:if>
											</td>
										</tr>
										<tr height="3">
											<td colspan="2">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td colspan="2">
												&nbsp;&nbsp;${review.reMessage}
											</td>
										</tr>
										<tr height="3">
											<td style="border-bottom: 1px solid #E8EAE9" colspan="2">
												&nbsp;
											</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<html:form action="login.do" method="post"
							enctype="multipart/form-data">
							<tr height="30">
								<td colspan="2" align="center" valign="middle">
									<c:if test="${user==null}">
										<input type="hidden" name="loginUrl"
											value="/detail.do?maID=${ma.maID}">
										<font class="front2">会員ID <input type="text"
												name="userName" style="width: 85px"> パスワード <input
												type="password" name="userPass" style="width: 85px">
										</font>
										<input type="submit" value="登録 ">
									</c:if>
									<c:if test="${user!=null}">
										<font class="front2">${user.userCall}: あなたの伝言を期待 </font>
									</c:if>
								</td>
							</tr>
						</html:form>
						<html:form action="sendReview.do" method="post"
							enctype="multipart/form-data">
							<tr>
								<td align="center" colspan="2">
									<input type="hidden" name="maID" value="${ma.maID}">
									<c:if test="${user!=null}">
										<input type="hidden" name="userID" value="${user.userID}">
									</c:if>
									<c:if test="${user==null}">
										<input type="hidden" name="userID" value="1">
									</c:if>
									<textarea rows="5" name="reMessage" style="width: 460px"
										onmouseup="textareaLengtn(this,200)"></textarea>
									<br>
									<br>
									<input type="submit" value="評論を発表 ">
								</td>
							</tr>
						</html:form>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
