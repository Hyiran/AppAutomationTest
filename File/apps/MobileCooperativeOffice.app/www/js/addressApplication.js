window.onload=function(){
    setUI();
}

var setUI = function() {
    setColseAndOpenDiv('Control_zhushuju', 'Applicant_informationList2', 'zhushuju');
    setColseAndOpenDiv('Control_weihuanjiekuan', 'table_informationList4', 'weihuanjiekuan');
    setColseAndOpenDiv('Control_yibanxinxi', 'Applicant_informationList4', 'yibanxinxi');
    setColseAndOpenDiv('Control_chengbenfenpei', 'Applicant_informationList5', 'chengbenfenpei');
    setColseAndOpenDiv('Control_lishishenpiyijian', 'table_informationList5', 'lishishenpiyijian');
}

//设置主数据
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

//设置一般信息
var setnormalData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList4',index);
}

//设置未还借款
var setBorrowMoneyData=function(index){
    setNomalTableDivData('table_informationList4',index);

}
//设置成本分配
var setCostData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList5',index);
}

//设置历史审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList5',index);
}





