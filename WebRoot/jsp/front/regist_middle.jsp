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
		<meta http-equiv="Expires" CONTENT="0">
		<title>装饰材料图库</title>
		<link rel="shortcut icon" href="<%=path%>/icon.ico">
		<script type="text/javascript" src="<%=path%>/js/back.js"></script>
		<style type="text/css">
.backdrop_01 {
	line-height: 25px;
}

.font_01 {
	font-size: 13px;
	color: #666666;
}

.font_02 {
	color: #FF6600
}

.font_03 {
	color: #686868;
	font-size: 13px;
}

.dashedLine {
	border-bottom-width: 1px;
	border-bottom-style: dashed;
	border-bottom-color: #DEDEDE;
}

.font_04 {
	font-size: 14px;
	font-style: normal;
	font-weight: bold;
}

.style2 {
	color: #FF0000;
	font-size: 12px;
}
</style>
		<script language="javascript">
	var XMLHttpReq = false;
	function creatXMLHttpRequest() { //alert("start createRequest"); 
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (trymicrosoft) {
			try {
				request = new XMLHttpRequest();
			} catch (othermicrosoft) {
				try {
					if (window.ActiveXObject) {
						request = new ActiveXObject("Microsoft.XMLHTTP");
					} else if (window.ActiveXObject) {
						request = new ActiveXObject("Msxml2.XMLHTTP.4.0");
					} else if (window.XMLHttpRequest) {
						request = new XMLHttpRequest();
					}
				} catch (failed) {
					request = false;
				}
			}
		}
		if (!request) {
			alert("err Happend!");
			return null;
		}
		XMLHttpReq = request;
	}

	//发出请求
	function sendRequest(url) {
		creatXMLHttpRequest();
		XMLHttpReq.open("POST", url, true);// XMLHttpReq.open("GET",url,true);
		XMLHttpReq.onreadystatechange = processResponse;//指定响应函数(状态改变的触发器)
		//或 XMLHttpReq.onreadystatechange = function(){};
		XMLHttpReq.send(null);//发送请求
	}

	//处理返回信息函数
	function processResponse() {
		if (XMLHttpReq.readyState == 4) {
			if (XMLHttpReq.status == 200) {
				var res = XMLHttpReq.responseXML.getElementsByTagName("res")[0].firstChild.data;
				//是否验证成功
				var errorname_exsit = document
						.getElementById('errorname_exsit');
				if (res == 'no') {
					errorname_exsit.style.display = '';
				} else {
					errorname_exsit.style.display = 'none';
				}
			} else {
				window.alert("你所请求的页面异常");
			}
		}
	}

	function checkUserName() {
		var name = document.getElementById('userName').value;//获取要验证的用户名
		var errorname_none = document.getElementById('errorname_none');
		if (name == "") {
			errorname_none.style.display = '';
			return false;
		} else {
			errorname_none.style.display = 'none';
			sendRequest('checkUserName.jsp?name=' + name);//将信息发送到后台进行验证
		}
		return true;
	}
	function checkUserPass() {
		var userPass = document.getElementById('userPass').value;//获取要验证的密码
		var errorpass_none = document.getElementById('errorpass_none');
		if (userPass == "") {
			errorpass_none.style.display = '';
			return false;
		} else {
			errorpass_none.style.display = 'none';

			var checkPass = document.getElementById('checkPass').value;//获取要验证的再次输入密码
			var errorpass_dif = document.getElementById('errorpass_dif');
			if (checkPass == userPass) {
				errorpass_dif.style.display = 'none';
			} else {
				errorpass_dif.style.display = '';
				return false;
			}
		}
		return true;
	}
	function checkAsk() {
		var userAsk = document.getElementById('userAsk').value;
		var errorask_none = document.getElementById('errorask_none');
		if (userAsk == "") {
			errorask_none.style.display = '';
			return false;
		} else {
			errorask_none.style.display = 'none';
		}
		return true;
	}
	function checkAnswer() {
		var userAnswer = document.getElementById('userAnswer').value;
		var erroranswer_none = document.getElementById('erroranswer_none');
		if (userAnswer == "") {
			erroranswer_none.style.display = '';
			return false;
		} else {
			erroranswer_none.style.display = 'none';
		}
		return true;
	}
	function checkCall() {
		var userCall = document.getElementById('userCall').value;
		var errorcall_none = document.getElementById('errorcall_none');
		if (userCall == "") {
			errorcall_none.style.display = '';
			return false;
		} else {
			errorcall_none.style.display = 'none';
		}
		return true;
	}

	function checkEmail() {
		var userMail = document.getElementById('userMail').value;
		var erroremail = document.getElementById('erroremail');
		patrn = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if (userMail == "") {
			erroremail.style.display = '';
			return false;
		}
		if (!patrn.test(userMail)) {
			erroremail.style.display = '';
			return false;
		} else {
			erroremail.style.display = 'none';
		}
		return true;
	}

	function checkSubmit() {
		if (checkUserName() && checkUserPass() && checkAsk() && checkAnswer()
				&& checkCall() && checkEmail()) {
			document.UserForm.submit();
		}
	}
	function checkUpdate() {
		if (checkUserPass() && checkAsk() && checkAnswer() && checkCall()
				&& checkEmail()) {
			document.UserForm.submit();
		}
	}
</script>
	</head>

	<body style="margin: 0">
		<table width="894" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="610" valign="top">
					<table width="610" height="527" cellpadding="0" cellspacing="0"
						background="<%=path%>/img/front/regist/backdropImg_01.gif">
						<tr>
							<td height="42" colspan="2" class="dashedLine">
								&nbsp;
								<img src="<%=path%>/img/front/regist/iconImg_01.gif" width="41"
									height="30" align="middle">
								<c:if test="${user==null}">
									<span class="font_04">会員は登録 </span>
								</c:if>
								<c:if test="${user!=null}">
									<span class="font_04">資料を改正 </span>
								</c:if>
							</td>
						</tr>
						<html:form action="regist.do" method="post"
							enctype="multipart/form-data">
							<tr>
								<td width="116" height="32" align="right">
									<span class="font_03">会員ID：</span>
								</td>
								<td width="494">
									<c:if test="${user==null}">
										<input type="text" id="userName" name="userName"
											maxlength="11" onblur="checkUserName()">
										<span class="style2">*</span>
										<span class="font_03"> 1-11キャラクター </span>
									</c:if>
									<c:if test="${user!=null}">
									${user.userName}	<input type="hidden" name="userName"
											value="${user.userName}" />
									</c:if>
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">
									<span class="font_03">パスワード ：</span>
								</td>
								<td width="494">
									<input type="password" style="width: 154px" id="userPass"
										name="userPass" maxlength="20" value="${user.userPass}">
									<span class="style2">*</span><span class="font_03">1-20キャラクター、大きい小文字を区分します</span>
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">
									<span class="font_03"> パスワードを再入力：</span>
								</td>
								<td width="494">
									<input type="password" style="width: 154px" id="checkPass"
										name="checkPass" maxlength="20" onblur="checkUserPass()"
										value="${user.userPass}">
									<span class="style2">*</span><span class="font_03">更に一回のパスワードを入力します</span>
								</td>
							</tr>
							<tr valign="top">
								<td width="116" height="20" align="right" class="dashedLine">
									&nbsp;
								</td>
								<td width="494" height="20" class="dashedLine">
									<span id="errorname_exsit" class="style2" style="display: none">
										用户名已被占用&nbsp; </span>
									<span id="errorname_none" class="style2" style="display: none">
										用户名不能为空&nbsp; </span>
									<span id="errorpass_dif" class="style2" style="display: none">
										两次输入的密码不同&nbsp; </span>
									<span id="errorpass_none" class="style2" style="display: none">
										密码不能为空 </span>
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">
									<span class="font_03">秘密の質問:</span>
								</td>
								<td width="494">
									<input type="text" id="userAsk" name="userAsk" maxlength="20"
										onblur="checkAsk()" value="${user.userAsk}">
									<span class="font_03"><span class="style2">*</span>解答をしっかり覚えて、パスワードがなくす時質問に答える</span>
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">
									<span class="font_03"> 秘密の答え:</span>
								</td>
								<td width="494">
									<input type="text" id="userAnswer" name="userAnswer"
										maxlength="20" onblur="checkAnswer()"
										value="${user.userAnswer}">
									<span class="font_03"><span class="style2">*</span>パスワードを探し出す時、あなたはこの問題に答えます
									</span>
								</td>
							</tr>
							<tr valign="top">
								<td width="116" height="20" align="right" class="dashedLine">
									&nbsp;
								</td>
								<td width="494" height="20" class="dashedLine">
									<span id="errorask_none" class="style2" style="display: none">
										密码提示问题不能为空&nbsp;&nbsp;</span>
									<span id="erroranswer_none" class="style2"
										style="display: none"> 密码提示答案不能为空 </span>
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">
									<span class="font_03">愛称：</span>
								</td>
								<td width="494">
									<input type="text" id="userCall" name="userCall" maxlength="6"
										onblur="checkCall()" value="${user.userCall}">
									<span class="style2">*</span><span class="font_03">1-6キャラクター</span>
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">
									<span class="font_03">E_mail：</span>
								</td>
								<td width="494">
									<input type="text" id="userMail" name="userMail"
										maxlength="100" onblur="checkEmail()" value="${user.userMail}">
									<span class="style2">*</span><span class="font_03"></span>
								</td>
							</tr>
							<tr valign="top">
								<td width="116" height="20" align="right" class="dashedLine">
									&nbsp;
								</td>
								<td width="494" height="20" class="dashedLine">
									<span id="errorcall_none" class="style2" style="display: none">
										姓名不能为空&nbsp;&nbsp;</span>
									<span id="erroremail" class="style2" style="display: none">
										E_mail格式错误 </span>
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">
									<span class="font_03">電話：</span>
								</td>
								<td width="494">
									<input type="text" name="userTel" maxlength="20"
										value="${user.userTel}">
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">
									<span class="font_03">住所:</span>
								</td>
								<td width="494">
									<input type="text" name="userAdress" maxlength="100"
										value="${user.userAdress}">
								</td>
							</tr>
							<tr height="1">
								<td colspan="2">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td width="116" height="33" align="right">

								</td>
								<td width="494">
									<c:if test="${user==null}">
<a onclick="checkSubmit()" onmouseover="checkCursor(this)"><span style="font-size: 15;color: #cc9966">登録</span></a>
										
									</c:if>
									<c:if test="${user!=null}">
										<input type="hidden" name="userID" value="${user.userID}" />
										<img src="<%=path%>/img/front/regist/iconImg_04.GIF"
											onclick="checkUpdate()" onmouseover="checkCursor(this)">
									</c:if>
								</td>
							</tr>
						</html:form>
						<tr height="100%">
							<td colspan="2">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
				<td width="284" valign="top">
					<table width="283" height="60" align="center"
						background="<%=path%>/img/front/regist/backdropImg_02.gif">
						<tr>
							<td>
								<img src="<%=path%>/img/front/regist/rigthImg.gif" width="22"
									height="19" align="middle">
								<c:if test="${user==null}">
									<span class="font_01">会員がもし頼むのだならば <a
										href="<%=path%>/navigate.do" class="font_02">登録</a> </span>
								</c:if>
								<c:if test="${user!=null}">
									<span class="font_01">戻ります<a href="<%=path%>/navigate.do"
										class="font_02">トップページ</a> </span>
								</c:if>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>