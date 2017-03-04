window.onload = function() {
    setUI();
}


var setUI = function() {
    setColseAndOpenDiv('Control_form1', 'Applicant_form1', 'form1');
    setColseAndOpenDiv('Control_form2', 'Table_form2', 'form2');
    setColseAndOpenDiv('Control_form3', 'Table_form3', 'form3');
    setColseAndOpenDiv('Control_form4', 'Table_form4', 'form4');

    setColseAndOpenDiv('Control_shenpiyijian', 'Table_shenpiyijian', 'shenpiyijian');
}

//设置变更说明
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList',index);
}

//设置预算变更
var setSecondData=function(index){
    setNomalRowDivDataWriteByPTag('Table_form2',index);
}
//设置成本变更
var setThirdData=function(index1,index2){
    setNomalTableData('table1',index1);
    setNomalTableData('table2',index2);
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

var setLiChengBeiJiHua=function(title,content){
    var template = document.querySelector("#lcbjh_item");
    if(template.number == undefined) {
        template.number = 0;
    }
    var idNumber = template.number++;
    var copy = template.cloneNode(true);
    copy.id = "zxmBlock" + idNumber;
    copy.index = idNumber;
    copy.style.display = "block";

    var titleItem = copy.querySelector("#lbcjh_item_title");
    titleItem.innerHTML = title;
    titleItem.id = "lbcjh_item_title" + idNumber;
    var contentItem = copy.querySelector("#lcbjh_item_content");
    contentItem.innerHTML = content;
    contentItem.id = "lcbjh_item_content" + idNumber;

    var lichengbeiJiHua = document.querySelector("#lcbjh_list");
    lichengbeiJiHua.insertBefore(copy, this.parentNode);

    var lcbBreakLine = document.getElementById("lcbBreakLine");
    lcbBreakLine.style.cssText = "border-top: 0.5px solid #E1E1E1;";
}

