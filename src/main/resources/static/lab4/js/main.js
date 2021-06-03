let functionsObjects;
function getAnswer(){

    let dots = getDots()
    console.log(JSON.stringify({
        dots : dots
    }))
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
    pierceKoef.innerText = "Коэффициент Пирсона: " + answer.pierceKoef;
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
        methodLabel.id = "methodLabel" + i;
        methodLabel.innerHTML = "<sup></sup>"+functionsObjects[i].methodName +": ";
        funcForm.append(methodLabel);

        let koefs = functionsObjects[i].acoefficients;
        switch (functionsObjects[i].methodName){
            case "Линейная":{
                let kform = document.createElement("input");
                kform.id = i + "" + 0 + "input";
                kform.type = "text";
                kform.value = koefs[0]
                let kLabel = document.createElement("label");
                kLabel.innerHTML = "<sup></sup> +";
                funcForm.append(kform, kLabel);

                let kform1 = document.createElement("input");
                kform1.id = i + "" + 1 + "input";
                kform1.type = "text";
                kform1.value = koefs[1]
                let kLabel1 = document.createElement("label");
                kLabel1.innerHTML = "x<sup></sup>";
                funcForm.append(kform1, kLabel1);
                break;
            }
            case "Степенная":{
                let kform = document.createElement("input");
                kform.id = i + "" + 0 + "input";
                kform.type = "text";
                kform.value = koefs[0]
                let kLabel = document.createElement("label");
                kLabel.innerHTML = "x<sup> <input id=\""+ i +"1input\" type=\"text\" value=\""+koefs[1]+"\"></sup>";
                funcForm.append(kform, kLabel);
                break;
            }
            case "Экспоненциальная":{
                let kform = document.createElement("input");
                kform.id = i + "" + 0 + "input";
                kform.type = "text";
                kform.value = koefs[0]
                let kLabel = document.createElement("label");
                kLabel.innerHTML = "e<sup> <input id=\""+ i +"1input\" type=\"text\" value=\""+koefs[1]+"\"> x</sup>";
                funcForm.append(kform, kLabel);
                break;
            }
            case "Логарифмическая":{
                let kform = document.createElement("input");
                kform.id = i + "" + 0 + "input";
                kform.type = "text";
                kform.value = koefs[0]
                let kLabel = document.createElement("label");
                kLabel.innerHTML = "ln(x)<sup></sup> +";
                funcForm.append(kform, kLabel);

                let kform1 = document.createElement("input");
                kform1.id = i + "" + 1 + "input";
                kform1.type = "text";
                kform1.value = koefs[1]
                let kLabel1 = document.createElement("label");
                kLabel1.innerHTML = "<sup></sup>";
                funcForm.append(kform1, kLabel1);
                break;
            }
            case "Квадратичная":{

                let kform = document.createElement("input");
                kform.id = i + "" + 0 + "input";
                kform.type = "text";
                kform.value = koefs[0]
                let kLabel = document.createElement("label");
                kLabel.innerHTML = "<sup></sup> +";
                funcForm.append(kform, kLabel);

                let kform1 = document.createElement("input");
                kform1.id = i + "" + 1 + "input";
                kform1.type = "text";
                kform1.value = koefs[1]
                let kLabel1 = document.createElement("label");
                kLabel1.innerHTML = "x<sup></sup> +";
                funcForm.append(kform1, kLabel1);

                let kform2 = document.createElement("input");
                kform2.id = i + "" + 2 + "input";
                kform2.type = "text";
                kform2.value = koefs[2]
                let kLabel2 = document.createElement("label");
                kLabel2.innerHTML = "x<sup>2</sup>";
                funcForm.append(kform2, kLabel2);
                break;
            }
        }

        answerDiv.append(funcForm);
    }

}