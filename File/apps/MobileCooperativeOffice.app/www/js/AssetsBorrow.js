window.onload=function(){
    setUI();
    setOnclickMethodToOC("didInventoryStatusSelected", "didInventoryStatusSelected");
    abservConfirmInput();
}
var setUI = function() {
    setColseAndOpenDiv('Control_yufukuanshenqing', 'Applicant_informationList2', 'yufukuanshenqing');
    setColseAndOpenDiv('Control_fujiaxinxi', 'table_informationList9', 'fujiaxinxi');
    setColseAndOpenDiv('Control_shenqingren', 'Applicant_informationList6', 'shenqingren');
    setColseAndOpenDiv('Control_zongcaiban', 'Applicant_informationList5', 'zongcaiban');
    
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
    setNomalTableDivData('Applicant_informationList2',index);
}

//总裁办资产管理员确认资产已下发(已办)
var setConfirmSendYet=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList5',index);
}
//已办里确认资产下发的表格
var setConfirmSendTableData=function(index){
    setNomalTableDivData('Applicant_informationList5',index);
}
//设置审批意见
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}
//总裁办资产管理员确认资产已下发(待办)
var setConfirmSendBack=function(index){
    setNomalTableDivData('Applicant_informationList6',index);
}

