window.onload = function() {
    setUI();
}


var setUI = function() {
    setColseAndOpenDiv('Control_form1', 'Applicant_form1', 'form1');
    setColseAndOpenDiv('Control_form2', 'Table_form2', 'form2');

    setColseAndOpenDiv('Control_shenpiyijian', 'Table_shenpiyijian', 'shenpiyijian');
}

//设置变更说明
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_form1',index);
}

//设置历史审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('Table_shenpiyijian',index);
}