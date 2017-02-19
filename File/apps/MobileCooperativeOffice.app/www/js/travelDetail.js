window.onload=function(){
    
   setUI();
    
}

var setUI = function() {
    setColseAndOpenDiv('Control_zhushuju', 'Applicant_informationList2', 'zhushuju');
    setColseAndOpenDiv('Control_chailvshenqing', 'Applicant_informationList5', 'chailvshenqing');
    setColseAndOpenDiv('Control_chengbenfenpei', 'Applicant_informationList6', 'chengbenfenpei');
    setColseAndOpenDiv('Control_zhichujihua', 'table_informationList4', 'zhichujihua');
    setColseAndOpenDiv('Control_fujiamudidi', 'table_informationList5', 'fujiamudidi');
    setColseAndOpenDiv('Control_lishishenpiyijian', 'table_informationList9', 'lishishenpiyijian');
}


//设置主数据
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

//设置差旅申请
var setSecondData=function(index){
    var getArr = index.split("|");
    if (getArr[0] == " ") {
        document.getElementById("Applicant_informationList5").style.display="none";
        document.getElementById("chailvshenqing").style.display="none";
    }
    setNomalRowDivDataWriteByPTag('Applicant_informationList5',index);
}

//设置成本分配
var setThirdData=function(index){
    var getArr = index.split("|");
    if (getArr[1] == " ") {
        document.getElementById("Applicant_informationList6").style.display="none";
        document.getElementById("chengbenfenpei").style.display="none";
    }
    setNomalRowDivDataWriteByPTag('Applicant_informationList6',index);
}

//设置支出计划
var setExpenditurePlan=function(index){
    var oApplicant_informationList = document.getElementById("table_informationList4");
    var tb=oApplicant_informationList.getElementsByTagName("table")[0];
    var getArr = index.split("|");
    var th=tb.getElementsByTagName("th");
    if (getArr.length == 4 && th.length != 4) { //如果是四条数据
        for (var j = 0; j < 3; j++) {
            th[th.length - 3].parentNode.removeChild(th[th.length - 3]);
        }
        tb = oApplicant_informationList.getElementsByTagName("table")[0];
        th = tb.getElementsByTagName('th');
        th[0].style.width = '25%';
        th[1].style.width = '18%';
        th[2].style.width = '16%';
        th[3].style.width = '41%';
    }
    setNomalTableDivData('table_informationList4',index);
}
//设置附加目的地
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList5',index);
}
//设置历史审批意见
var setAprroveOpinion=function(index){
    setNomalTableDivData('table_informationList9',index);
}

