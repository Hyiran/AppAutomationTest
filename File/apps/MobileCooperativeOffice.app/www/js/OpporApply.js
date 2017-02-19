window.onload=function(){
    setUI();
    registerAllOcMethod();
    observAllInputValue();

}
var setUI = function() {
    setColseAndOpenDiv('Control_keHuXinXi', 'Applicant_informationList2', 'keHuXinXi');
    setColseAndOpenDiv('Control_shangJiXinXi', 'Row_shangJiXinXi', 'shangJiXinXi');
    
}

var setElementValueWitElementId = function(ElementId, value) {
    var elment = document.getElementById(ElementId);
    elment.innerHTML = value;
}
//设置资产借用申请表
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

var registerAllOcMethod = function() {

    setOnclickMethodToOC("selectCustomerName", "selectCustomerName");

    setOnclickMethodToOC("selectIsNewCustomer", "selectIsNewCustomer");
    setOnclickMethodToOC("selectSalesPerson", "selectSalesPerson");

    setOnclickMethodToOC("selectSJZT", "selectSJZT");
    setOnclickMethodToOC("selectOppType", "selectOppType");
    setOnclickMethodToOC("selectOppStage", "selectOppStage");
    setOnclickMethodToOC("selectOppSource", "selectOppSource");

    setOnclickMethodToOC("selectTaxRate", "selectTaxRate");

    setOnclickMethodToOC("selectOppStartTime", "selectOppStartTime");
    setOnclickMethodToOC("selectOppEndTime", "selectOppEndTime");

    setOnclickMethodToOC("selectSingleQuarter", "selectSingleQuarter");
    setOnclickMethodToOC("selectSalesCycle", "selectSalesCycle");
    setOnclickMethodToOC("selectChancesWinning", "selectChancesWinning");

}

var setOnclickMethodToOC = function(ElementId, ocMethodName) {
    var elment = document.getElementById(ElementId);
    elment.onclick = function() {
        location.href = "localmethod://" + ocMethodName + "?ElementId=" + elment.id + "&index=" + elment.index;
    }
}

var observAllInputValue = function() {

    var shangJiXinXi = document.getElementById("Row_shangJiXinXi");
    var inputs_shangJiXinXi = shangJiXinXi.getElementsByTagName("input");
    for(var i = 0; i < inputs_shangJiXinXi.length; i++) {
        inputs_shangJiXinXi[i].oninput = function() {
            location.href = "localmethod://didShangJiXinXiInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value;
        }
    }

    var textarea_shangJiXinXi = shangJiXinXi.getElementsByTagName("textarea");
    for(var i = 0; i < textarea_shangJiXinXi.length; i++) {
        textarea_shangJiXinXi[i].oninput = function() {
            location.href = "localmethod://didShangJiXinXiInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value;
        }
    }

}

var updateMaoLiJinE = function(money) {
    var maoLiJinE = document.getElementById("OPP_GROSSPROJECT");
    maoLiJinE.value = money;
}