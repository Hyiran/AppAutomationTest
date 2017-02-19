window.onload=function(){
    setUI();
}
var setUI = function() {
	
	setTwoTableChage('tabchange1','tabchange2','tabchange1Div','tabchange2Div');
    setTwoTableChage('tabchange2_1','tabchange2_2','tabchange2_1Div','tabchange2_2Div');
    
    setColseAndOpenDiv('Control_zhushuju', 'Applicant_informationList1', 'zhushuju');
    setColseAndOpenDiv('Control_chailvshenqing', 'Applicant_informationList2', 'chailvshenqing');
    setColseAndOpenDiv('Control_chengbenfenpei', 'Applicant_informationList3', 'chengbenfenpei');
    setColseAndOpenDiv('Control_zhichujihua', 'Applicant_informationList4', 'zhichujihua');
    
    setColseAndOpenDiv('Control_chailvbaoxiao', 'Applicant_informationList5', 'chailvbaoxiao');
    setColseAndOpenDiv('Control_shijizhichu', 'Applicant_informationList6', 'shijizhichu');
    setColseAndOpenDiv('Control_lishishenpiyijian', 'table_informationList7', 'lishishenpiyijian');
}

//设置主数据
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList1',index);
}
//设置差旅申请数据
var setChaiLvShenQingData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

//设置成本分配
var setReceiptInfo=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList3',index);
}

//设置支出计划
var setExpenditurePlan=function(index){
    var oApplicant_informationList = document.getElementById("tabchange1Div");
    var tb=oApplicant_informationList.getElementsByTagName("table")[0];
    var getArr = index.split(",");
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
    setNomalTableDivData('tabchange1Div',index);
}
//设置附加目的地计划
var setAditionAddressPlan=function(index){
    setNomalTableDivData('tabchange2Div',index);
}

//设置差旅报销
var setEvectionApply=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList5',index);
}

//设置实际支出数据
var setExpenditureReal=function(index){
    var oApplicant_informationList = document.getElementById("tabchange2_1Div");
    var tb=oApplicant_informationList.getElementsByTagName("table")[0];
    var th=tb.getElementsByTagName("th");
    var getArr = index.split(",");
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
    setNomalTableDivData('tabchange2_1Div',index);

    
}
//设置实际附加目的地计划
var setAditionAddressReal=function(index){
    setNomalTableDivData('tabchange2_2Div',index);
}


//设置历史审批意见
var setAprroveProc=function(index){
    setNomalTableDivData('table_informationList7',index);
}






