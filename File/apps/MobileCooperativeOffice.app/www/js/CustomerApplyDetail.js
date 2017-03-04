window.onload=function(){
    setUI();
}
var setUI = function() {
    setColseAndOpenDiv('Control_keHuXinXi', 'Applicant_informationList2', 'keHuXinXi');
    setColseAndOpenDiv('Control_shangJiXinXi', 'Applicant_informationList3', 'shangJiXinXi');
    setColseAndOpenDiv('Control_fujiaxinxi', 'table_informationList9', 'fujiaxinxi');
    
    
}

var setElementValueWitElementId = function(ElementId, value) {
    var elment = document.getElementById(ElementId);
    elment.innerHTML = value;
}
//设置资产借用申请表
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}
//
var setMobilTableData=function(index){
    setNomalTableDivData('Applicant_informationList3',index);
}

//总裁办资产管理员确认资产已下发(已办)
var setSecondData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList3',index);
}

//设置附加信息
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}
