window.onload=function(){
	setUI();
}

var setUI = function() {
    
    setColseAndOpenDiv('Control_zhushuju', 'Applicant_informationList1', 'zhushuju');
    setColseAndOpenDiv('Control_yibanxinxi', 'Applicant_informationList2', 'yibanxinxi');
    setColseAndOpenDiv('Control_chengbenfenpei', 'Applicant_informationList3', 'chengbenfenpei');
    setColseAndOpenDiv('Control_shoujuxinxi', 'table_informationList4', 'shoujuxinxi');
    setColseAndOpenDiv('Control_lishishenpiyijian', 'table_informationList5', 'lishishenpiyijian');
}

//设置主数据
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList1',index);
}
//设置一般信息
var setGeneralInfo=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

//设置成本分配
var setCostInfo=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList3',index);
}

//设置收据信息
var setReceiptInfo=function(index){
    setNomalTableDivData('table_informationList4',index);
}

//设置历史审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList5',index);
}







