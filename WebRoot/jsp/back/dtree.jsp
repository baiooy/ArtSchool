<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.util.*" errorPage=""%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

	<head>
		<title>后台管理</title>
		<meta http-equiv="Expires" CONTENT="0">
		<link rel="StyleSheet" href="<%=path%>/jsp/back/dtree.css"
			type="text/css" />
		<script type="text/javascript" src="<%=path%>/jsp/back/dtree.js"></script>
		<script type="text/javascript" src="<%=path%>/js/back.js"></script>

	</head>
	<script type="text/javascript">

function viewDiv(id){
var obj=document.getElementById(id);

 if(obj.style.display==''){
   obj.style.display='none';
  }else{
 obj.style.display='';
 }

}
</script>
	<body bgcolor="" leftmargin="0" rightmargin="0" topmargin="0">
		<a href="#" onmouseover="checkCursor(this)" onclick="viewDiv('front')">フロントセット</a>
		<!--  <input type="button" onmouseover="checkCursor(this)"
			onclick="viewDiv('front')"
			style=" width: 125px;height: 42px;border-style: none;background: url('<%=path%>/img/back/button/btnFront.GIF');">
			-->
		<br>
		<div id="front" style="display: none" class="dtree">
			<p>
				<a href="jsp/back/config/updateAdver.jsp" target="right">広告管理 </a> |
				<a href="<%=path%>/jsp/back/config/updateSort.jsp" target="right">カテゴリイメージ</a>
				|
				<br>
				<a href="jsp/back/config/updateEmail.jsp" target="right">Eメール </a> |
				<a href="jsp/back/config/updateLogo.jsp" target="right">Logo管理 </a>
				|
			</p>
		</div>
		<a href="#" onmouseover="checkCursor(this)" onclick="viewDiv('user')">ユーザ管理</a>
		<!--	
            <input type="button" onmouseover="checkCursor(this)"
			onclick="viewDiv('user')"
			style=" width: 125px;height: 42px;border-style: none;background: url('<%=path%>/img/back/button/btnUser.GIF');">
		-->
		<div id="user" style="display: none" class="dtree">
			<p>
				<a href="listAdmin.do" target="right">管理者 </a> |
				<a href="<%=path%>/jsp/back/user/selectUser.jsp" target="right">登録ユーザー
				</a> |
			</p>
		</div>
		<br>
		<a href="#" onmouseover="checkCursor(this)" onclick="viewDiv('image')">画像検索</a>
		<!-- 		
<input type="button" onmouseover="checkCursor(this)"
			onclick="viewDiv('image')"
			style=" width: 125px;height: 42px;border-style: none;background: url('<%=path%>/img/back/button/btnImage.GIF');">
		 -->
		<div id="image" style="display: none" class="dtree">
			<p>
				<a href="<%=path%>/jsp/back/material/selectMa.jsp" target="right">ファジー検索</a>
				|
			</p>
		</div>
		<br>
		<a href="#" onmouseover="checkCursor(this)" onclick="viewDiv('dtree')">カテゴリ管理</a>
		<!--  		
<input type="button" onmouseover="checkCursor(this)"
			onclick="viewDiv('dtree')"
			style=" width: 125px;height: 42px;border-style: none;background: url('<%=path%>/img/back/button/btnType.GIF');">
		-->
		<div id="dtree" class="dtree">
			<p>
				<a href="content.do">リフレッシュ</a> |
				<a href="javascript: d.openAll();">すべて開く</a> |
				<a href="javascript: d.closeAll();">すべて閉じる</a>
			</p>
			<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'类型','','','right');
		<%String[] node = (String[]) request.getAttribute("node");
			for (int i = 0; i < node.length; i++) {
				out.println(node[i]);
			}%>
	document.write(d);
	//
</script>
		</div>

	</body>

</html>