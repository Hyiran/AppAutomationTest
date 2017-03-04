window.onload=function(){
    setUI();
    setOnclickMethodToOC("didUseConditionSelected", "didUseConditionSelected");
    abservConfirmInput();
}

var setUI = function() {
    setColseAndOpenDiv('Control_ziyuanxuqiu', 'Applicant_informationList2', 'ziyuanxuqiu');
    setColseAndOpenDiv('Control_zongcaiban', 'Applicant_informationList5', 'zongcaiban');
    setColseAndOpenDiv('Control_shenqingren', 'Applicant_informationList6', 'shenqingren');
    setColseAndOpenDiv('Control_chuliguocheng', 'table_informationList7', 'chuliguocheng');
}

function abservConfirmInput(){
    document.getElementById("confirmOption").oninput = function() {
        location.href = "localmethod://didconfirmOptionInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value;
    }
}



//设置印章申请表
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}
//印章保管人确认信息(已办)
var setConfirmInfoYet=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList5',index);
}

//设置审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList7',index);
}





