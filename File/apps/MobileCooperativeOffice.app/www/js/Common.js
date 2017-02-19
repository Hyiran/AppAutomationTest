

var setNomalRowDivDataWriteByPTag = function(rowDivId,dataParamter){
    var rowDivElement = document.getElementById(rowDivId);
    var oDd = rowDivElement.getElementsByTagName("i");
    var getArr = dataParamter.split("|");
    for(var i = 0;i < getArr.length;i ++){
        var val =  getArr[i];
        var tmp = oDd[i];
        var fs = tmp.getElementsByTagName("font");
        fs[0].innerHTML = val;
    }
}


var setNomalTableDivData = function(tableDivId,dataParamter){
    var tableDivElement = document.getElementById(tableDivId);
    var tb = tableDivElement.getElementsByTagName("table")[0];
    var row = tb.insertRow();
    row.className = "tableRow";
    var getArr = dataParamter.split("|");
    for(var i = 0;i < getArr.length;i ++){
        var val =  getArr[i];
        var cell = row.insertCell();
        cell.className = "tableCell";
        cell.innerHTML = val;
    }
}



var setTwoTableChage = function(leftTabelControlId,rightTableControlId,leftTabelId,rightTableId) {
	var Tabchange1 = document.getElementById(leftTabelControlId);
	var Tabchange2 = document.getElementById(rightTableControlId);
	var Tabchange1Div = document.getElementById(leftTabelId);
	var Tabchange2Div = document.getElementById(rightTableId);
	Tabchange1.onclick = function() {
		Tabchange1.style.color = "#3D72DE";
		Tabchange2.style.color = "#666666";
		Tabchange2Div.style.display = "none";
		Tabchange1Div.style.display = "block";
	}
	Tabchange2.onclick = function() {
		Tabchange1.style.color = "#666666";
		Tabchange2.style.color = "#3D72DE";
		Tabchange2Div.style.display = "block";
		Tabchange1Div.style.display = "none";
	}
}

var setColseAndOpenDiv = function(openId, controlId, titleId) {

	var blockElement = document.getElementById(controlId);
	var openElement = document.getElementById(openId);
	var dlElement = document.getElementById(titleId);
	openElement.src = "../img/up.png";
	openElement.className = "normalClass";
	blockElement.style.display = "block";
	//此处添加点击方法...
	var flag = true;
	openElement.onclick = function() {
		if(flag) {
			var fontElement = dlElement.getElementsByClassName('titleClass')[0];
			fontElement.className = "titleCloseClass";
			blockElement.style.display = "none";
			openElement.className = "rotationClass";
			flag = false;
		} else {
			var fontElement = dlElement.getElementsByClassName('titleCloseClass')[0];
			fontElement.className = "titleClass";
			blockElement.style.display = "block";
			openElement.className = "normalClass";
			flag = true;
		}
	}
}

var setOnclickMethodToOC = function(ElementId, ocMethodName) {
	var elment = document.getElementById(ElementId);
	elment.onclick = function() {
		location.href = "localmethod://" + ocMethodName + "?ElementId=" + elment.id + "&index=" + elment.index;
	}
}

function addBreakLine(element){
    var breakLineDiv = document.createElement("div");
    breakLineDiv.className = "breakLine";
    element.appendChild(breakLineDiv);
}


function hidElementWithId(elementId){
    var needHidElement = document.getElementById(elementId);
    needHidElement.style.display = "none";
}

var setElementValueWitElementId = function(ElementId, value) {
    var elment = document.getElementById(ElementId);
    if(elment.tagName == 'INPUT'){
        elment.value = value;
        
    }else{
        elment.innerHTML = value;
    }
}

function setEmergency(){
    document.getElementById("emergencyDiv").style.display = "block";
}

