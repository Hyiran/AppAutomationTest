window.onload=function(){
    
    setUI();
    
}

var setUI = function() {
    setColseAndOpenDiv('Control_jibenxinxi', 'Applicant_informationList2', 'jibenxinxi');
    setColseAndOpenDiv('Control_beijingdiaocha', 'Applicant_informationList3', 'beijingdiaocha');
    setColseAndOpenDiv('Control_disanfangcepingjieguo', 'Applicant_informationList4', 'disanfangcepingjieguo');
}

//设置基本信息
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

//设置背景调查
var setSecondData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList3',index);
}

//设置第三方评测结果
var setThridData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList4',index);
}



//设置审批意见
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}

