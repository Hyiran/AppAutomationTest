
//此处key与value必须对应
function addRowBoxWithIdAndCatgeryAndData(id, categry, keys,values){
    var titleId = "title" + id;
    var openId = "open" + id;
    var mainBox = document.getElementById("mainBox");
    var dlElement = creatTitleDlElementWithId(titleId,openId,categry);
    mainBox.appendChild(dlElement);
    var rowDiv = createDivWithIdAndClass(id,"rowDiv");
    setupRowDivWithElementAndKeysAndValues(rowDiv,keys,values);
    mainBox.appendChild(rowDiv);
    setColseAndOpenDiv(openId,id,titleId);
    addBreakLine(mainBox);
}


//添加table的方法//供外部调用
function addTableWithIdAndCatgeryAndHeader(id, categry, index) {
    
    //1.添加标题----写方法实现
    var titleId = "title" + id;
    var openId = "open" + id;
    var mainBox = document.getElementById("mainBox");
    var dlElement = creatTitleDlElementWithId(titleId,openId,categry);
    mainBox.appendChild(dlElement);
    var tableDiv = createDivWithIdAndClass(id,"tableDiv");
    var tableElement = createTableElementWithData(index);
    tableDiv.appendChild(tableElement);
    mainBox.appendChild(tableDiv);
    setColseAndOpenDiv(openId,id,titleId);
    addBreakLine(mainBox);
}

function addTableDataWithId(id, index) {
    setNomalTableDivData(id,index);
}

function creatTitleDlElementWithId(titleId,openId,categry){
    var dlElement = document.createElement("dl");
    dlElement.className = "Title_Dl";
    dlElement.id = titleId;
    var titleInnerHTML = "<dt ><font class='titleClass'>" + categry + "</font></dt><dd ><a href='###'><img id=" + openId + " '/></a>";
    dlElement.innerHTML = titleInnerHTML;
    return dlElement;
}


function createDivWithIdAndClass(divId,divClass){
    var resultDiv = document.createElement("div");
    resultDiv.className = divClass;
    resultDiv.id = divId;
    return resultDiv;
}

function createTableElementWithData(index){
    var tableElement = document.createElement("table");
    var tbodyElement = document.createElement("tbody");
    var trElement = document.createElement("tr");
    var getArr = index.split("|");
    
    //在此处进行判断table的宽度
    tableElement.className = "tableElement";
    tableElement.style.width = "100%";
    var thWidth = 100 / getArr.length + "%";
    for (var i = 0; i < getArr.length; i++) {
        var thElement = document.createElement("th");
        thElement.style.width = thWidth;
        thElement.className = "tableTh";
        thElement.innerHTML = getArr[i];
        trElement.appendChild(thElement);
    }
    
    tbodyElement.appendChild(trElement);
    tableElement.appendChild(tbodyElement);
    return tableElement;
}

function setupRowDivWithElementAndKeysAndValues(rowDivElement,keys,values){
    var keyArr = keys.split("|");
    var valueArr = values.split("|");
    var isEvenNumber = true;
    for (var i = 0; i < keyArr.length; i++) {
        var pElement = document.createElement("p");
        if(isEvenNumber){//是偶数
            pElement.className = "EvenRowClass";
        }else{
            pElement.className = "oddRowClass";
        }
        isEvenNumber = !isEvenNumber;
        var pInnerHtml = "<span><font class='keyClass'>" + keyArr[i] + "</font></span><i class='fenpei'><font class='valueClass'>" + valueArr[i] + "</font></i>";
        pElement.innerHTML = pInnerHtml;
        rowDivElement.appendChild(pElement);
    }
}





