let functionsObjects;
function getAnswer(){
    let dots = getDots()

    let promise = fetch("/lab4/getAnswer", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            dots : dots
        })
    }).then(response => {
        return response.json();
    }).then((answer) => {
       createAnswerForm(answer);
       reload();
    });
}

function createAnswerForm(answer) {
    let answerDiv = document.getElementById("answer");
    answerDiv.innerText="";
    let bestMethName = document.createElement("h5");
    let pierceKoef = document.createElement("h5");
    bestMethName.innerText ="Лучший метод: " + answer.bestMethodName;
    pierceKoef.innerText = "Коэффициент Пирса: " + answer.pierceKoef;
    answerDiv.append(bestMethName, pierceKoef);

    functionsObjects = answer.functionObjects;
    for(let i = 0; i < functionsObjects.length; i++){
        let funcForm = document.createElement("div");
        let chekBox = document.createElement("input");

        chekBox.type = "checkbox";
        chekBox.className = "checkBoxes";
        chekBox.id = "checkBox" + i;
        chekBox.setAttribute('onclick', 'reload()');
        if(answer.bestMethodName === functionsObjects[i].methodName){
            chekBox.checked = true;
        }
        let checkLabel = document.createElement("label");
        checkLabel.append(chekBox);
        funcForm.append(checkLabel);

        let methodLabel = document.createElement("label");
        methodLabel.className = "methodsName"
        methodLabel.innerHTML = "<sup></sup>"+functionsObjects[i].methodName +": ";
        funcForm.append(methodLabel);

        let koefs = functionsObjects[i].acoefficients;
        for(let j = 0; j < koefs.length; j++){
            if(koefs[j] !== 0){

                let kform = document.createElement("input");
                kform.id = i + "" + j + "input";
                kform.type = "text";
                kform.value = koefs[j]
                let kLabel = document.createElement("label");
                if(j < koefs.length -1){
                    if(j === 0){
                        kLabel.innerHTML = "<sup></sup> + "
                    }
                    else if(j === 1){
                        kLabel.innerHTML = "x<sup></sup> + ";
                    }
                    else kLabel.innerHTML = "x<sup>"+j+"</sup> + ";
                }
                else {
                    if(j === 0){
                    }
                    else if(j === 1){
                        kLabel.innerHTML = "x<sup></sup>";
                    }
                    else kLabel.innerHTML = "x<sup>"+j+"</sup>";
                }
                funcForm.append(kform, kLabel);
            }
        }
        answerDiv.append(funcForm);
    }

}