window.onload=function(){
    setUI();
    registerAllOcMethod();
    setAddAndRemoveButton();
    observAllInputValue();

}
var setUI = function() {
    setColseAndOpenDiv('Control_keHuXinXi', 'Applicant_informationList2', 'keHuXinXi');
    setColseAndOpenDiv('Control_lxyXinXi', 'Row_lxyXinXi', 'lxyXinXi');
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
    setOnclickMethodToOC("selectIsGroup", "selectIsGroup");
    setOnclickMethodToOC("selectUpperUnit", "selectUpperUnit");
    setOnclickMethodToOC("selectCountry", "selectCountry");
    setOnclickMethodToOC("selectDiQu", "selectDiQu");
    setOnclickMethodToOC("selectIndustry", "selectIndustry");
    setOnclickMethodToOC("selectRelaType", "selectRelaType");
    setOnclickMethodToOC("selectCate", "selectCate");

  
}

var setAddAndRemoveButton = function() {
    document.querySelector("#addLianXiRen").onclick = addLianXiRenFn;
    document.querySelector("#removeLianXiRen").onclick = removeLianXiRenFn;
}

var setOnclickMethodToOC = function(ElementId, ocMethodName) {
    var elment = document.getElementById(ElementId);
    elment.onclick = function() {
        location.href = "localmethod://" + ocMethodName + "?ElementId=" + elment.id + "&index=" + elment.index;
    }
}

var observAllInputValue = function() {

    var lxyXinXi = document.getElementById("Applicant_informationList2");
    var inputs_lxyXinXi = lxyXinXi.getElementsByTagName("input");
    for(var i = 0; i < inputs_lxyXinXi.length; i++) {
        inputs_lxyXinXi[i].oninput = function() {
            location.href = "localmethod://didKeHuXinXiInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value;
        }
    }

    var textarea_lxyXinXi = lxyXinXi.getElementsByTagName("textarea");
    for(var i = 0; i < textarea_lxyXinXi.length; i++) {
        textarea_lxyXinXi[i].oninput = function() {
            location.href = "localmethod://didKeHuXinXiInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value;
        }
    }
    
    var secondDiv = document.getElementById("Row_lxyXinXi");
    var lianxirenDivs = secondDiv.getElementsByClassName("lianxiren");
    for(var i = 0; i < lianxirenDivs.length; i++) {
        var inputs_lianxirenDivs = lianxirenDivs[i].getElementsByTagName("input");
        for(var j = 0; j < inputs_lianxirenDivs.length; j++) {
            inputs_lianxirenDivs[j].index = i;
            inputs_lianxirenDivs[j].oninput = function() {
                
                location.href = "localmethod://didlxyXinXiInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value + "&index=" + this.index;
            }
        }
    }
}

//添加目的地
var addLianXiRenFn = function() {
    var lxrTemplate = document.querySelector("#lianxirenTemplate");
    if(lxrTemplate.number == undefined) {
        lxrTemplate.number = 0;
    }
    var idNumber = ++lxrTemplate.number;
    var copy = lxrTemplate.cloneNode(true);
    copy.id = "lxyBlock" + idNumber;
    copy.style.display = "block";

    var breakLine = document.createElement("div");
    breakLine.className = "breakLine";
    breakLine.id = "lxyBreakLine" + idNumber;

    var nameId = "lxrInputName" + idNumber;
    copy.querySelector("#lxrInputNameTemplate").id = nameId;

    var depId = "lxrInputDepDep" + idNumber;
    copy.querySelector("#lxrInputDepDepTemplate").id = depId;

    var jobId = "lxrInputJob" + idNumber;
    copy.querySelector("#lxrInputJobTemplate").id = jobId;
    
    var mailId = "lxrInputMail" + idNumber;
    copy.querySelector("#lxrInputMailTemplate").id = mailId;

    var busphoneId = "lxrInputBusphone" + idNumber;
    copy.querySelector("#lxrInputBusphoneTemplate").id = busphoneId;
    
    var phoneId = "lxrInputPhone" + idNumber;
    copy.querySelector("#lxrInputPhoneTemplate").id = phoneId;

    var lxrXinXi = document.querySelector("#Row_lxyXinXi");
    lxrXinXi.insertBefore(breakLine, this.parentNode);
    lxrXinXi.insertBefore(copy, this.parentNode);
    var removeSiteBtn = document.querySelector("#removeLianXiRen");
    removeSiteBtn.style.display = "table-cell";

    observAllInputValue();
    location.href = "localmethod://didAddLianXiRen?ElementId=" + copy.id + "&index=" + idNumber;
};


//删除目的地
var removeLianXiRenFn = function() {
        var destinationTemplate = document.querySelector("#lianxirenTemplate");
        var idNumber = destinationTemplate.number--;
        var removDestinationId = "lxyBlock" + idNumber;
        var removBreakLineId = "lxyBreakLine" + idNumber;
        var removeDestination = document.getElementById(removDestinationId);
        var removeBreakLine = document.getElementById(removBreakLineId);
        removeBreakLine.remove();
        removeDestination.remove();
        if(idNumber == 1) {
            this.style.display = "none";
        }
        observAllInputValue();
        location.href = "localmethod://didRemoveLianXiRen?ElementId=" + removDestinationId + "&index=" + idNumber;
}
