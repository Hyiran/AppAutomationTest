window.onload=function(){
    
    setUI();
   
}

var setUI = function() {
    setColseAndOpenDiv('Control_yufukuanshenqing', 'Applicant_informationList2', 'yufukuanshenqing');
    setColseAndOpenDiv('Control_yufukuanxinxi', 'Applicant_informationList3', 'yufukuanxinxi');
    setColseAndOpenDiv('Control_fujiaxinxi', 'table_informationList9', 'fujiaxinxi');
}


//预付款申请
var setAdvanceApprove=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList3',index);
}

//设置附加信息
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}


var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

var setMobilTableData=function(index){
    setNomalTableDivData('Applicant_informationList2',index);
}
