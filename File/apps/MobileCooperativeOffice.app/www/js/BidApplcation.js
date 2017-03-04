window.onload=function(){
    
    setUI();
     setOnclickMethodToOC("didIsAotoApprSelected", "didIsAotoApprSelected");
    
}

var setUI = function() {
    setColseAndOpenDiv('Control_jibenxinxi', 'Applicant_informationList2', 'jibenxinxi');
    setColseAndOpenDiv('Control_fashouxinxi', 'Applicant_informationList3', 'fashouxinxi');
    setColseAndOpenDiv('Control_xiangguanfujian', 'Applicant_informationList4', 'xiangguanfujian');
    setColseAndOpenDiv('Control_fujiaxinxi', 'table_informationList9', 'fujiaxinxi');
}

//设置基本信息
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

//设置法授信息
var setSecondData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList3',index);
}

//设置相关附件
var setThridData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList4',index);
}



//设置审批意见
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}

