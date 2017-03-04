window.onload=function(){
   setUI(); 
}

var setUI = function() {
    setColseAndOpenDiv('Control_ziyuanxuqiu', 'Applicant_informationList2', 'ziyuanxuqiu');
    setColseAndOpenDiv('Control_chuliguocheng', 'table_informationList7', 'chuliguocheng');
}
//设置资源需求
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

var deleteElementById = function(index){
    
    var element = document.getElementById(index);
    element.parentNode.removeChild(element);
}

//设置建议录用人
var setExpectEmployee=function(index){
    setNomalTableDivData('Applicant_informationList2',index);
}

//设置审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList7',index);
}






