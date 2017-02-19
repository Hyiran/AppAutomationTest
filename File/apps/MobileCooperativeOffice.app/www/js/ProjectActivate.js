window.onload = function() {
    window.addEventListener("orientationchange", function() {
        setTimeout(chageIframeSize, 200); //延时等待旋转完毕
    });
    setUI();

}

var chageIframeSize = function() {
    $("iframe").each(function() {
        $(this).width($(window).width());
    });
}


var setUI = function() {
    setColseAndOpenDiv('Control_jibenxinxi', 'Applicant_jibenxinxi', 'jibenxinxi');
    setColseAndOpenDiv('Control_zixiangmuxinxi', 'Table_zixiangmuxinxi', 'zixiangmuxinxi');
    setColseAndOpenDiv('Control_xiangmucaigou', 'Table_xiangmucaigou', 'xiangmucaigou');

    setColseAndOpenDiv('Control_shouruqingkuang', 'Chart_shouruqingkuang', 'shouruqingkuang');
    setColseAndOpenDiv('Control_lirunqingkuang', 'Chart_lirunqingkuang', 'lirunqingkuang');
    setColseAndOpenDiv('Control_chengbenqingkuang', 'Chart_chengbenqingkuang', 'chengbenqingkuang');


    setColseAndOpenDiv('Control_jinduzhiliang', 'Table_jinduzhiliang', 'jinduzhiliang');
    setColseAndOpenDiv('Control_shenpiyijian', 'Table_shenpiyijian', 'shenpiyijian');
}


//设置基本信息
var setBaseMsg=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_jibenxinxi',index);
}

//设置子项目信息
var setSubProjectData=function(index){
    setNomalTableDivData('Table_zixiangmuxinxi',index);
}

//设置收入情况
var setIncomeCondition=function (index) {
	setChartIframe("Chart_shouruqingkuang",index);
}

//设置利润情况
var setProfitCondition=function (index) {
	setChartIframe("Chart_lirunqingkuang",index);
}

//设置成本情况
var setCostCondition=function (index) {
	setChartIframe("Chart_chengbenqingkuang",index);
}

//设置项目采购
var setProjectPurchase=function(index){
    setNomalTableDivData('Table_xiangmucaigou',index);
}

//设置进度质量
var setScheduleQuality=function(index){
    setNomalTableDivData('Table_jinduzhiliang',index);
}

//设置历史审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('Table_shenpiyijian',index);
}

var createChartControlButton = function (parentId,buttonWidth,index,buttonName) {
	var liElement = document.createElement("li");
	var buttonSelectedClass = "Chart_Control_Selected";
	var buttonNormalClass = "Chart_Control_Normal";
	var controlId = parentId + "_Control_Chart_" + index;
	var controledId = parentId+ "_iframe_id" + 0;
	var iframeClass = parentId + "_iframe";
	liElement.className = index == 0 ? buttonSelectedClass : buttonNormalClass;
	liElement.style.width = buttonWidth;
	liElement.id = controlId;
	liElement.innerHTML = buttonName;
	liElement.controledId = controledId;
	liElement.onclick = function() {
	    //更改当前显示状态
	    $("#" + parentId + " ." + buttonSelectedClass).each(function() {
	        $(this).attr("class", buttonNormalClass);
	    });
	    this.className = buttonSelectedClass;
	    $("#" + this.controledId).hide();
	    $("#" + this.controledId).attr("src",$(this).prop("ownedSrc"));
	}
	return liElement;
}

var createChartIframe=function (parentId,src,index) {
	/* body... */
	var iframeClass = parentId + "_iframe";
	var controledId = parentId+ "_iframe_id" + index;
	var iframeElement = document.createElement("iframe");
	$(iframeElement).width($(window).width());
	iframeElement.id = controledId;
	iframeElement.src = src;
	iframeElement.scrolling = "no";
	iframeElement.className = iframeClass;
	iframeElement.style.display = index == 0 ? "block" : "none" ;
	iframeElement.onload=function () {
		$(this).show();
	}
	return iframeElement;
}

var setChartIframe=function (parentId,jsonValue) {
	var chartObj = JSON.parse(jsonValue);
	var parentEl = document.getElementById(parentId);
	var ulElement = document.createElement("ul");
	var liElementWidth = 100/chartObj.length + "%";
	//创建
	for (var i = 0; i < chartObj.length; i++) {
		var liElement = createChartControlButton(parentId,liElementWidth,i,chartObj[i].chartName);
		liElement.ownedSrc = chartObj[i].src;
		ulElement.appendChild(liElement);		
	}
	parentEl.appendChild(ulElement);
	var divEl = document.createElement("div");
	divEl.className = "iframe_div_class";
	var iframeElement = createChartIframe(parentId,chartObj[0].src,0);
	divEl.appendChild(iframeElement);
	parentEl.appendChild(divEl);
	addBreakLine(parentEl);
}





