// JavaScript Document
function ChangeTab(number,TdID,Tablen,ImgID,Url)
{

	var len=Tablen
	var controlID=TdID+number;
	var imgsrc=document.getElementById(controlID).background;
	imgsrcdefault=imgsrc.substring(0,imgsrc.lastIndexOf('/')+1);
	
	for(var i=1;i<len;i++)
	{
		controlID=TdID+i;
		document.getElementById(controlID).background=imgsrcdefault+ImgID+".gif"
		document.getElementById(controlID).className="OutFont";
		
	}
	controlID=TdID+number;
	document.getElementById(controlID).background=imgsrcdefault+ImgID+"Over.gif"
	document.getElementById(controlID).className="OverFont";
	//window.open(Url);
	
}
function OpenWin(Url){
	
	window.location=Url;
	}
function WelcomeUser(div1,div2)
{
	document.getElementById(div1).style.display="none";
	document.getElementById(div2).style.display="";
}
function login(div1,div2){
    document.getElementById(div2).style.display="none";
	document.getElementById(div1).style.display="";
}