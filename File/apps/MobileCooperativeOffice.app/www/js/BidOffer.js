window.onload=function(){
    setUI();
}

var setUI = function() {
    setColseAndOpenDiv('Control_jibenxinxi', 'Applicant_informationList2', 'jibenxinxi');
    setColseAndOpenDiv('Control_fujiaxinxi', 'table_informationList9', 'fujiaxinxi');
}

//设置基本信息
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

//设置审批意见
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}
