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
	<body>
		<div class="divStyle1" align="left">
			<table width="" height="" border="0" align="center"
				bordercolor="#000000" id="tb"
				style="COLOR: #069; text-align: center; font-size: 12px;">
				<tr height="30">
					<td width="75">
						名称
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.maName}
						</DIV>
					</td>
					<td width="20">
					</td>
					<td width="300" rowspan="10">
						<DIV class="divStyle3">
							<c:if test="${null==ma.maPicPath}">
								<img width="220" height="290"
									src="<%=path%>/upload_file/nonePic.JPG"></img>
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
						<DIV class="divStyle2">
							${ma.maCode}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						モットー
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.typeName}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						ジャンル
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.maBranch}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						詳しい料金
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.maOrigin}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						入会金
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.maOtherName}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						運営費（月額）
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.maFormat}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						料金
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.maPrice1}-${ma.maPrice2}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						無料体験レッスン
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.maBrand}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						出張レッスン 
					</td>
					<td width="200" align="left">
						<DIV class="divStyle2">
							${ma.maGrade}
						</div>
					</td>
					<td width="20">
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						レッスン形態 
					</td>
					<td colspan="3" align="left">
						<DIV class="divStyle4">
							${ma.maPart}
						</div>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						対応コース 
					</td>
					<td colspan="3" align="left">
						<DIV class="divStyle4">
							${ma.maTrait }
						</div>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						評価
					</td>
					<td colspan="3" align="left">
						<DIV class="divStyle4">
							${ma.maEffect}
						</div>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						営業案内
					</td>
					<td colspan="3" align="left">
						<DIV class="divStyle4">
							${ma.maEnvironment}
						</div>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						是否推荐
					</td>
					<td colspan="3" align="left">
						<DIV class="divStyle4">
							<c:if test="${ma.isRecommend==0}">是</c:if>
							<c:if test="${ma.isRecommend==1}">否</c:if>
						</div>
					</td>
				</tr>
				<tr height="30">
					<td width="75">
						下载次数
					</td>
					<td colspan="3" align="left">
						<DIV class="divStyle4">
							${ma.downCount} &nbsp;&nbsp;&nbsp;
							<a href="<%=path%>/download.do?maAffix=${ma.maAffix}">查看下载</a>
						</div>
					</td>
				</tr>
				<html:form action="deleteMa.do">
					<tr height="30">
						<td width="75">
							<input type="button" value="戻る" style="color: #069"
								onclick="goTarget('viewType.do?typeID=${ma.maType}')">
						</td>
						<td colspan="3" align="left">

							<input type="hidden" name="typeID" value="${ma.maType}">
							<input type="hidden" name="maIDs" value="${ma.maID}">
							<input type="hidden" name="deleteModel" value="1">
							<input type="submit" value="削除" style="color: #069">
							<input type="button" value="更新" style="color: #069"
								onclick="goTarget('readyMa.do?operation=update&&maID=${ma.maID}')">

							<input type="button" value="コピー" style="color: #069"
								onclick="goTarget('readyMa.do?operation=copy&&maID=${ma.maID}')">


						</td>
					</tr>
				</html:form>
			</table>
		</div>
	</body>
</html>
