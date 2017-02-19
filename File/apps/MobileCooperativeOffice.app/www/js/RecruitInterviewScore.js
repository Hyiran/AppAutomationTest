window.onload=function(){
    
    setUI();
    setDivSelectable();
    registerAllOcMethod();
    observAllInputValue();
}

var setUI = function() {
    setColseAndOpenDiv('Control_jibenxinxi', 'Applicant_informationList2', 'jibenxinxi');
    setColseAndOpenDiv('Control_beijingdiaocha', 'Applicant_informationList3', 'beijingdiaocha');
    setColseAndOpenDiv('Control_disanfangcepingjieguo', 'Applicant_informationList4', 'disanfangcepingjieguo');
}
var setDivSelectable = function() {
    choiceDivSelectable("OverallImage");
    choiceDivSelectable("ExpressionAbility");
    choiceDivSelectable("SkillMatchingDegree");
    choiceDivSelectable("WorkMatchingDegree");
    choiceDivSelectable("CertificateMatchingDegree");
    choiceDivSelectable("UnderstandingDegree");
    choiceDivSelectable("OverallEvaluation");
    choiceDivSelectable("InterviewResults");
}

var registerAllOcMethod = function() {
    setOnclickMethodToOC("selectInterviewDate", "selectInterviewDate");
}
//设置基本信息
var setMainData=function(index){
    setNomalRowDivDataWriteByPTag('Applicant_informationList2',index);
}

var observAllInputValue = function() {

    var shangJiXinXi = document.getElementById("Applicant_informationList4");
    var inputs_shangJiXinXi = shangJiXinXi.getElementsByTagName("input");
    for(var i = 0; i < inputs_shangJiXinXi.length; i++) {
        inputs_shangJiXinXi[i].oninput = function() {
            location.href = "localmethod://didMianShiJiLuInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value;
        }
    }
}

var changePic = function(element,parent) {
	var index = 0;
	var ddTags = parent.getElementsByClassName("choice");
    for (var i = 0; i < ddTags.length; i++) {
        ddTags[i].getElementsByTagName("img")[0].src = "../img/quan.png";
        ddTags[i].selected = false;
        if (element == ddTags[i]) {
        	index = i;
        }
    }
    var imgElemet = element.getElementsByTagName("img")[0];
    imgElemet.src = "../img/check.png";
    element.selected = !element.selected;
    element.value = element.getElementsByTagName("label")[0].innerHTML;
	location.href = "localmethod://didChoiceListValueChange?ElementId=" + parent.id + "&name=" + element.name + "&value=" + index;
}

var selectIndexInDiv = function(index,divName) {
    var div = document.getElementById(divName);
    var ddTags = div.getElementsByClassName("choice");
    changePic(ddTags[index],div);
}

var setInputValueById = function(value,id) {
    var div = document.getElementById(id);
    div.value = value;
}
var choiceDivSelectable = function(choiceDivName) {
    var elment = document.getElementById(choiceDivName);
    var ddTags = elment.getElementsByClassName("choice");
    for (var i = 0; i < ddTags.length; i++) {
        ddTags[i].onclick = function() {
            changePic(this,elment);
        }
    }
}
