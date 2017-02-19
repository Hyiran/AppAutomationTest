window.onload=function(){
   setUI();
}


var setUI = function() {
    setColseAndOpenDiv('Control_qingjiashenqingdan', 'Applicant_informationList', 'qingjiashenqingdan');
    setColseAndOpenDiv('Control_shenpiyijian', 'table_informationList7', 'shenpiyijian');
}
//设置请假申请单
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList',index);
}

//设置审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList7',index);
}






