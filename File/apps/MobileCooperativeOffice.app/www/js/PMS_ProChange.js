window.onload=function(){
	setUI();
}

var setUI = function() {
    setColseAndOpenDiv('Control_form1', 'Applicant_form1', 'form1');
    setColseAndOpenDiv('Control_form2', 'Table_form2', 'form2');
    setColseAndOpenDiv('Control_form3', 'Table_form3', 'form3');
    setColseAndOpenDiv('Control_form4', 'Table_form4', 'form4');
    setColseAndOpenDiv('Control_form5', 'Applicant_form5', 'form5');

    setColseAndOpenDiv('Control_shenpiyijian', 'Table_shenpiyijian', 'shenpiyijian');
}

//设置变更说明
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList',index);
}

//设置预算变更
var setSecondData=function(index){
    setNomalTableDivData('Table_form2',index);
}
//设置成本变更
var setThirdData=function(index){
    setNomalTableDivData('Table_form3',index);
}
//设置计划变更
var setFourthData=function(index){
    setNomalTableDivData('Table_form4',index);
}
//设置子项目变更
var setFifthData=function(json){
    setNomalTableDivData('Table_form3',index);
}
//设置历史审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('Table_shenpiyijian',index);
}

var setZiXiangMu=function(title){
    var template = document.querySelector("#zxmxx");
    if(template.number == undefined) {
        template.number = 0;
    }
    var idNumber = template.number++;
    var copy = template.cloneNode(true);
    copy.id = "zxmBlock" + idNumber;
    copy.index = idNumber;
    copy.style.display = "table";

    copy.querySelector("#zxmText").innerHTML = title;
    copy.onclick = function() {
        location.href = "localmethod://ziXiangMuXinXiDidClicked?ElementId=" + this.id + "&index=" + this.index;
    }

    var zxmXinXi = document.querySelector("#ZXMXX_List");
    zxmXinXi.insertBefore(copy, this.parentNode);

    var zxmBreakline = document.getElementById("zxmBreakLine");
    zxmBreakline.style.cssText = "border-top: 0.5px solid #E1E1E1;";
}

//设置设置为子项目
var changeToSubProject=function(){
    hidElementWithId("form1");
    hidElementWithId("Applicant_form1");

    hidElementWithId("form5");
    hidElementWithId("Applicant_form5");
    hidElementWithId("shenpiyijian");
    hidElementWithId("Table_shenpiyijian");
}

