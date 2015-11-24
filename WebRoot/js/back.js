function goTarget(url) {
	window.open(url, "_self");
}
function openNewWindow(url) {
	window.open(url);
}
function checkCursor(obj) {
	obj.style.cursor = 'hand';
}

function textareaLengtn(obj, len) {
	if (obj.value.length > len) {
		obj.value = obj.value.substring(0, len);
	}
}

function drawImg(obj) {
	if ((obj.height * 22 >= obj.width * 29) && obj.height >= 290) {
		obj.width = obj.width * 290 / obj.height;
		obj.height = 290;
	}
	if ((obj.height * 22 < obj.width * 29) && obj.width > 220) {

		obj.height = obj.height * 220 / obj.width;
		obj.width = 220;
	}
}

function autoSize(obj, MAX_WIDTH, MAX_HEIGHT) {
	var tImg = new Image();
	tImg.onload = function() {
		if (obj.src.length < 1) {
			obj.width = MAX_WIDTH;
			obj.height = MAX_HEIGHT;
			return;
		}
		var w = this.width;
		var h = this.height;
		// if (w < MAX_WIDTH && h < MAX_HEIGHT) {
		// obj.width = w;
		// obj.height = h;
		// return;
		// }
		if (w * MAX_HEIGHT >= h * MAX_WIDTH) {
			obj.width = MAX_WIDTH;
			obj.height = MAX_WIDTH * h / w;
		} else {
			obj.height = MAX_HEIGHT;
			obj.width = MAX_HEIGHT * w / h;
		}
		if (obj.src) {
			obj.style.display = '';
		}
	}
	tImg.src = obj.src;
}

function isPic(obj) {
	var strFilter = ".jpeg|.gif|.jpg|.png|.bmp|.pic|"
	var strFileName = obj.value;
	if (strFileName == '') {
		return true;
	}
	if (strFileName.indexOf(".") > -1) {
		point = strFileName.lastIndexOf(".");
		strFileName = strFileName.substring(point, obj.length) + '|';
		strFileName = strFileName.toLowerCase();
		if (strFilter.indexOf(strFileName) > -1) {
			error.style.display = 'none';
			return true;
		} else {
			
			return false;
		}
	}
}
