var funcDots =[]
function getAnswer(){
    let methods = document.getElementById("methods")
    let dots = getDots()
    let promise = fetch("/lab5/getAnswer", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            methodName: methods.value,
            dots : dots
        })
    }).then(response => {
        return response.json();
    }).then((answer) => {
        dotsFromJson(answer)
       createAnswerForm();
       reload();
    });
}
function dotsFromJson(answer) {
    funcDots = [];
    let dots = answer.dots;
    for(let i = 0; i < dots.length; i++){
        var dot = {
            x: dots[i].x,
            y: dots[i].y
        }
        funcDots.push(dot);
    }
}
function createAnswerForm() {
    let answerDiv = document.getElementById("getAnswer");
    answerDiv.innerHTML ="";
    let funcForm = document.createElement("div");
    funcForm.id = "funcForm"
    let xValue = document.createElement("input")
    xValue.type = "number"
    xValue.id = "xValue"
    xValue.className ="input"
    xValue.width = 150
    let button = document.createElement("button")
    button.id = "getXValue"
    button.innerText = "Найти Y"
    button.className = "inputForm button"
    button.setAttribute('onclick', 'getXValue()');
    funcForm.append(xValue, button)
    answerDiv.append(funcForm);


}
function getXValue() {
    let answerDiv = document.getElementById("answer");
    answerDiv.innerText =""
    let xValue = document.getElementById("xValue")
    let yAnswer = document.createElement("h5")
    let promise = fetch("/lab5/getXValue", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
          xValue : xValue.value
        })
    }).then(response => {
        return response.json();
    }).then((answer) => {
        yAnswer.innerText = "y = " + answer.xValue
        answerDiv.append(yAnswer)
    });
}
