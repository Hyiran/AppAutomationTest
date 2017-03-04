window.onload=function(){
   setUI();
}

var setUI = function() {
    setColseAndOpenDiv('Control_ziyuanxuqiu', 'Applicant_informationList2', 'ziyuanxuqiu');
    setColseAndOpenDiv('Control_zongcaiban', 'Applicant_informationList5', 'zongcaiban');
    setColseAndOpenDiv('Control_shenqingren', 'Applicant_informationList6', 'shenqingren');
    setColseAndOpenDiv('Control_chuliguocheng', 'table_informationList7', 'chuliguocheng');
}

//设置授权申请表
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

//设置领取通知
var setSecondData=function(index){
    var getArr = index.split("|");
    if (getArr[0] == " ") {
        document.getElementById("Applicant_informationList5").style.display="none";
        document.getElementById("zongcaiban").style.display="none";
    }
    setNomalRowDivDataWriteByPTag('Applicant_informationList5',index);
}

//设置领取信息
var setThirdData=function(index){
    var getArr = index.split("|");
    if (getArr[1] == " ") {
        document.getElementById("Applicant_informationList6").style.display="none";
        document.getElementById("shenqingren").style.display="none";
    }
    setNomalRowDivDataWriteByPTag('Applicant_informationList6',index);
}


//设置审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList7',index);
}


function setEmergency(){
    document.getElementById("emergencyDiv").style.display = "block";
}

