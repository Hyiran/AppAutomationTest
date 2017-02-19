window.onload=function(){
    
    setUI();
     setOnclickMethodToOC("didIsAotoApprSelected", "didIsAotoApprSelected");
    
}

var setUI = function() {
    setColseAndOpenDiv('Control_yufukuanshenqing', 'Applicant_informationList2', 'yufukuanshenqing');
    setColseAndOpenDiv('Control_fujiaxinxi', 'table_informationList9', 'fujiaxinxi');
}

//设置预付款申请
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

var setMobilTableData=function(index){
    setNomalTableDivData('Applicant_informationList2',index);
}

//设置附加信息
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}

//隐藏是否自动审批
var hideAutoApprove=function(){
    hidElementWithId('IsAotoApprSelectDiv');
    document.getElementById('xiangMuJinE').className = "topClass";
}
