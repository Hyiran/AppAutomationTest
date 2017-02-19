window.onload = function() {

	setUI();
	registerAllOcMethod();
	setAddAndRemoveButton();
	observAllInputValue();
	autoShowExpendElement();
    setkindlyRemindHeight();

}

var setAddAndRemoveButton = function() {
	document.querySelector("#addFijiaMuDiDi").onclick = addSiteFn;
	document.querySelector("#addZhichuJiHua").onclick = addExpendFn;
	document.querySelector("#removeFujiaMuDiDi").onclick = removeSiteFn;
	document.querySelector("#removeZhichuJiHua").onclick = removeExpendFn;
}

var setUI = function() {
	setColseAndOpenDiv('Control_Zhushuju', 'Row_Zhushuju', 'zhushuju');
	setColseAndOpenDiv('Control_Chailvshenqing', 'Row_Chailvshenqing', 'chailvshenqing');
	setColseAndOpenDiv('Control_Chengbenfenpei', 'Row_Chengbenfenpei', 'chengbenfenpei');
	setColseAndOpenDiv('Control_Zhichujihua', 'Row_Zhichujihua', 'zhichujihua');
	setColseAndOpenDiv('Control_Fujiamudidi', 'Row_Fujiamudidi', 'fujiamudidi');
}

var registerAllOcMethod = function() {

	setOnclickMethodToOC("selectTravelType", "selectTravelType");
	setOnclickMethodToOC("selectTravelStartTime", "selectTravelStartTime");
	setOnclickMethodToOC("selectTravelEndTime", "selectTravelEndTime");
	setOnclickMethodToOC("inputTime0", "didZhiChuJiHuaDateSelect");
	setOnclickMethodToOC("selectIsBrrowing", "didSelectIsBrrowing");

	setOnclickMethodToOC("selectConutyOfChailvshenqing", "didSelectCounty");
	setOnclickMethodToOC("selectCostType", "didSelectCostType");
	setOnclickMethodToOC("selectCostCode", "didSelectCostCode");

	setOnclickMethodToOC("selectCostCode0", "didSelectReceiptTypeOfExpendPlan");
	setOnclickMethodToOC("selectCurrency0", "didSelectCurrencyOfExpendPlan");

	setOnclickMethodToOC("destinationStartTime0", "didSelectDestinationStartTime");
	setOnclickMethodToOC("destinationEndTime0", "didSelectDestinationEndTime");
	setOnclickMethodToOC("destinationCountry0", "didSelectDestinationCounty");

}

var setColseAndOpenDiv = function(openId, controlId, titleId) {

	var blockElement = document.getElementById(controlId);
	var openElement = document.getElementById(openId);
	var dlElement = document.getElementById(titleId);
	openElement.src = "../img/up.png";
	openElement.className = "normalClass";
	blockElement.style.display = "block";
	//此处添加点击方法...
	var flag = true;
	openElement.onclick = function() {
		if(flag) {
			var fontElement = dlElement.getElementsByClassName('titleClass')[0];
			fontElement.className = "titleCloseClass";
			blockElement.style.display = "none";
			openElement.className = "rotationClass";
			flag = false;
		} else {
			var fontElement = dlElement.getElementsByClassName('titleCloseClass')[0];
			fontElement.className = "titleClass";
			blockElement.style.display = "block";
			openElement.className = "normalClass";
			flag = true;
		}
	}
}

var setOnclickMethodToOC = function(ElementId, ocMethodName) {
	var elment = document.getElementById(ElementId);
	elment.onclick = function() {
		location.href = "localmethod://" + ocMethodName + "?ElementId=" + elment.id + "&index=" + elment.index;
	}
}

var setElementValueWitElementId = function(ElementId, value) {
	var elment = document.getElementById(ElementId);
    if(elment.tagName == 'INPUT'){
        elment.value = value;
        
    }else{
        elment.innerHTML = value;
    }

	if(ElementId == "selectTravelType") {
		autoShowExpendElement();
	}
}
var observAllInputValue = function() {

	var chailvshenqing = document.getElementById("Row_Chailvshenqing");
	var inputs_chailvshenqing = chailvshenqing.getElementsByTagName("input");
	for(var i = 0; i < inputs_chailvshenqing.length; i++) {
		inputs_chailvshenqing[i].oninput = function() {
			location.href = "localmethod://didChailvshenqingInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value;
		}
	}

	var zhichujihua = document.getElementById("Row_Zhichujihua");
	var expendDivs = zhichujihua.getElementsByClassName("expend");
	for(var i = 0; i < expendDivs.length; i++) {
		var inputs_expendDivs = expendDivs[i].getElementsByTagName("input");
		for(var j = 0; j < inputs_expendDivs.length; j++) {
			inputs_expendDivs[j].index = i;
			if(inputs_expendDivs[j].id.indexOf("inputParities") >= 0) {
				inputs_expendDivs[j].tValue = inputs_expendDivs[j].value;
			}

			inputs_expendDivs[j].onblur = function() {
				if(this.id.indexOf("inputParities") >= 0) {
					if(this.value.indexOf(".") < 0) {
						if(this.value == "") {
							this.value = "1.000000";
						} else {
							this.value = this.value + ".000000";
						}
					} else {
						var firstNumber = (this.value.split("."))[0];
						var lastNumber = (this.value.split("."))[1];
						if(lastNumber.length < 6) {
							for(var i = lastNumber.length; i < 6; i++) {
								lastNumber = lastNumber + "0";
							}
							this.value = firstNumber + "." + lastNumber;
						}
					}

					location.href = "localmethod://didZhiChuJiHuaInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value + "&index=" + this.index;
				}

			}

			inputs_expendDivs[j].oninput = function() {
				if(this.id.indexOf("inputParities") >= 0) {
					if(this.value.match(/^([1-9][\d]{0,5}|0)(\.[\d]{0,6})?$/) != null) {
						this.tValue = this.value;
					} else {
						if(this.value == "") {
							this.tValue = "";
						} else {
							if(!isNaN(this.value) && this.value.substr(0, 1) != 0 && this.value.length > 6 && this.value.indexOf(".") < 0) {
								var firstNum = this.value.substr(0, 6);
								var lastNum = this.value.substring(6, this.value.length);
								this.value = firstNum + "." + lastNum;
							} else {
								this.value = this.tValue;
							}
						}
					}
				}

				if(this.id.indexOf("inputMoney") >= 0) {
					if(this.value.match(/^([1-9][\d]{0,8}|0)(\.[\d]{0,2})?$/) != null) {
						this.tValue = this.value;
					} else {
						if(this.tValue == undefined || this.value == ""){
							this.tValue = "";
						}
						this.value = this.tValue;
					}
				}

				location.href = "localmethod://didZhiChuJiHuaInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value + "&index=" + this.index;
			}
		}

	}
	var fujiamudidi = document.getElementById("Row_Fujiamudidi");
	var destinationDivs = fujiamudidi.getElementsByClassName("destination");
	for(var i = 0; i < destinationDivs.length; i++) {
		var inputs_destinationDivs = destinationDivs[i].getElementsByTagName("input");
		for(var j = 0; j < inputs_destinationDivs.length; j++) {
			inputs_destinationDivs[j].index = i;
			inputs_destinationDivs[j].oninput = function() {

				location.href = "localmethod://didFuJiaMuDiDiInputValueChange?ElementId=" + this.id + "&name=" + this.name + "&value=" + this.value + "&index=" + this.index;
			}
		}
	}
}

//添加目的地
var addSiteFn = function() {
	var destinationTemplate = document.querySelector("#destinationTemplate");
	if(destinationTemplate.number == undefined) {
		destinationTemplate.number = 0;
	}
	var idNumber = ++destinationTemplate.number;
	var destinationCopy = destinationTemplate.cloneNode(true);
	destinationCopy.id = "destinationBlock" + idNumber;
	destinationCopy.style.display = "block";

	var breakLine = document.createElement("div");
	breakLine.className = "breakLine";
	breakLine.id = "destinationBreakLine" + idNumber;

	var destinationStartTimeId = "destinationStartTime" + idNumber;
	destinationCopy.querySelector("#destinationStartTimeTemplate").index = idNumber;
	destinationCopy.querySelector("#destinationStartTimeTemplate").id = destinationStartTimeId;

	var destinationEndTimeId = "destinationEndTime" + idNumber;
	destinationCopy.querySelector("#destinationEndTimeTemplate").index = idNumber;
	destinationCopy.querySelector("#destinationEndTimeTemplate").id = destinationEndTimeId;

	var destinationCountryId = "destinationCountry" + idNumber;
	destinationCopy.querySelector("#destinationCoutryTemplate").index = idNumber;
	destinationCopy.querySelector("#destinationCoutryTemplate").id = destinationCountryId;

	var destinationInputCityId = "destinationInputCity" + idNumber;
	destinationCopy.querySelector("#destinationInputCityTemplate").id = destinationInputCityId;

	//	var destinationInputMoneyId = "destinationInputMoney" + idNumber;
	//	destinationCopy.querySelector("#destinationInputMoneyTemplate").id = destinationInputMoneyId;

	var destinationInputReasonId = "destinationInputReason" + idNumber;
	destinationCopy.querySelector("#destinationInputReasonTemplate").id = destinationInputReasonId;

	var FujiaMuDiDi = document.querySelector("#Row_Fujiamudidi");
	FujiaMuDiDi.insertBefore(breakLine, this.parentNode);
	FujiaMuDiDi.insertBefore(destinationCopy, this.parentNode);
	var removeSiteBtn = document.querySelector("#removeFujiaMuDiDi");
	removeSiteBtn.style.display = "table-cell";

	setOnclickMethodToOC(destinationStartTimeId, "didSelectDestinationStartTime");
	setOnclickMethodToOC(destinationEndTimeId, "didSelectDestinationEndTime");
	setOnclickMethodToOC(destinationCountryId, "didSelectDestinationCounty");

	observAllInputValue();
	location.href = "localmethod://didAddFuJiaMuDiDi?ElementId=" + destinationCopy.id + "&index=" + idNumber;
};
//添加之出计划
var addExpendFn = function() {

	var expendTemplate = document.querySelector("#expendTemplate");
	if(expendTemplate.number == undefined) {
		expendTemplate.number = 0;
	}
	var idNumber = ++expendTemplate.number;
	var expendCopy = expendTemplate.cloneNode(true);
	expendCopy.id = "expendBlock" + idNumber;
	expendCopy.style.display = "block";

	var breakLine = document.createElement("div");
	breakLine.className = "breakLine";
	breakLine.id = "expandBreakLine" + idNumber;

	var selectCostCodeId = "selectCostCode" + idNumber;
	expendCopy.querySelector("#selectCostCodeTemplate").index = idNumber;
	expendCopy.querySelector("#selectCostCodeTemplate").id = selectCostCodeId;

	var selectCurrencyId = "selectCurrency" + idNumber;
	expendCopy.querySelector("#selectCurrencyTemplate").index = idNumber;
	expendCopy.querySelector("#selectCurrencyTemplate").id = selectCurrencyId;

	var inputMoneyId = "inputMoney" + idNumber;
	expendCopy.querySelector("#inputMoneyTemplate").id = inputMoneyId;

	var inputBaseCurrencyId = "inputBaseCurrency" + idNumber;
	expendCopy.querySelector("#inputBaseCurrencyTemplate").id = inputBaseCurrencyId;

	var inputParitiesId = "inputParities" + idNumber;
	expendCopy.querySelector("#inputParitiesTemplate").id = inputParitiesId;

	var inputTimeId = "inputTime" + idNumber;
	expendCopy.querySelector("#inputTimeTemplate").index = idNumber;
	expendCopy.querySelector("#inputTimeTemplate").id = inputTimeId;

	var inputMessageId = "inputMessage" + idNumber;
	expendCopy.querySelector("#inputMessageTemplate").id = inputMessageId;

	var Zhichujihua = document.querySelector("#Row_Zhichujihua");
	Zhichujihua.insertBefore(breakLine, this.parentNode);
	Zhichujihua.insertBefore(expendCopy, this.parentNode);

	setOnclickMethodToOC(selectCostCodeId, "didSelectReceiptTypeOfExpendPlan");
	setOnclickMethodToOC(selectCurrencyId, "didSelectCurrencyOfExpendPlan");
	setOnclickMethodToOC(inputTimeId, "didZhiChuJiHuaDateSelect");

	var removeExpendBtn = document.querySelector("#removeZhichuJiHua");
	removeExpendBtn.style.display = "table-cell";
	observAllInputValue();
	autoShowExpendElement();
	location.href = "localmethod://didAddZhiChuJiHua?ElementId=" + expendCopy.id + "&index=" + idNumber;
};
//删除目的地
var removeSiteFn = function() {
		var destinationTemplate = document.querySelector("#destinationTemplate");
		var idNumber = destinationTemplate.number--;
		var removDestinationId = "destinationBlock" + idNumber;
		var removBreakLineId = "destinationBreakLine" + idNumber;
		var removeDestination = document.getElementById(removDestinationId);
		var removeBreakLine = document.getElementById(removBreakLineId);
		removeBreakLine.remove();
		removeDestination.remove();
		if(idNumber == 1) {
			this.style.display = "none";
		}
		observAllInputValue();
		location.href = "localmethod://didRemoveFuJiaMuDiDi?ElementId=" + removDestinationId + "&index=" + idNumber;

	}
	//删除支出计划
var removeExpendFn = function() {
	var expendTemplate = document.querySelector("#expendTemplate");
	var idNumber = expendTemplate.number--;
	var removeExpendId = "expendBlock" + idNumber;
	var removeBreakLineId = "expandBreakLine" + idNumber;
	var removeExpend = document.getElementById(removeExpendId);
	var removeBreakLine = document.getElementById(removeBreakLineId);
	removeExpend.remove();
	removeBreakLine.remove();
	if(idNumber == 1) {
		this.style.display = "none";
	}
	observAllInputValue();
	location.href = "localmethod://didRemoveZhiChuJiHua?ElementId=" + removeExpendId + "&index=" + idNumber;
}

var isJingNei = function() {
	var selectTravelType = document.querySelector("#selectTravelType");
	return(selectTravelType.textContent == "境内差旅" || selectTravelType.textContent == "请选择")
}

var autoShowExpendElement = function() {
	var zhichujihua = document.querySelector("#Row_Zhichujihua");
	var hiddenElements = zhichujihua.getElementsByClassName("customHiddenClass");
	for(var i = 0; i < hiddenElements.length; i++) {
		if(isJingNei()) {
			hiddenElements[i].style.display = "none";
		} else {
			hiddenElements[i].style.display = "table";
		}

	}

}

var setkindlyRemindHeight = function(){
    var kindlyRemindElement = document.getElementById("kindlyRemind");
    var width = kindlyRemindElement.offsetWidth;
    var height = width * 50 /414;
    kindlyRemindElement.style.height = height + 'px';
    kindlyRemindElement.style.lineHeight = height + 'px';
    
}


