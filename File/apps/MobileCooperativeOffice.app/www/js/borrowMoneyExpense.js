window.onload=function(){
	setUI();
}

var setUI = function() {
    setColseAndOpenDiv('Control_zhushuju', 'Applicant_informationList', 'zhushuju');
    setColseAndOpenDiv('Control_shoujuxinxi', 'table_informationList4', 'shoujuxinxi');
    setColseAndOpenDiv('Control_chengbenfenpei', 'Applicant_informationList3', 'chengbenfenpei');
    setColseAndOpenDiv('Control_lishishenpiyijian', 'table_informationList5', 'lishishenpiyijian');
}

//设置主数据
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList',index);
}

//设置未还借款
var setGeneralInfo=function(index){
    setNomalTableDivData('table_informationList4',index);
}


//设置借款信息
var setCostInfo=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList3',index);
}


//设置历史审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList5',index);
}







