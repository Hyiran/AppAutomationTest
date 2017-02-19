window.onload=function(){
    setUI();
}

var setUI = function() {
    setColseAndOpenDiv('Control_yufukuanshenqing', 'Applicant_informationList2', 'yufukuanshenqing');
    setColseAndOpenDiv('Control_gudingzichan', 'table_informationList4', 'gudingzichan');
    setColseAndOpenDiv('Control_dizhiyihao', 'table_informationList5', 'dizhiyihao');
    setColseAndOpenDiv('Control_lishishenpiyijian', 'table_informationList9', 'lishishenpiyijian');
}

//设置申请单
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

var setElementValueWitElementId = function(ElementId, value) {
    var elment = document.getElementById(ElementId);
    elment.innerHTML = value;
}

var setExpenditurePlan=function(index){
    setNomalTableDivData('table_informationList4',index);
}

//设置低值易耗
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList5',index);
}

//设置历史审批意见
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}

