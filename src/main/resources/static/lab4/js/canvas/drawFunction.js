let density = 0.01;

function createDotsForDraw (koefs, method) {
    let Dots = [];
    switch (method){
        case "Степенная:":{
            for(let i = xMin; i < xMax; i += density){
                let x = i < xNull? -i : i - xNull;
                let y = 0;
                for(let j = 0; j < koefs.length; j++){
                    y+= parseFloat(koefs[j]) * Math.pow(x, j);
                }
                let dot = {
                    x: x,
                    y: y
                }
                Dots.push(dot);
            }
            return Dots.sort(compare2);
        }
        case "Линейная:":{
            for(let i = xMin; i < xMax; i += density){
                let x = i < xNull? -i : i - xNull;
                let y = parseFloat(koefs[0]) +  parseFloat(koefs[1]) * x;
                let dot = {
                    x: x,
                    y: y
                }
                Dots.push(dot);
            }
            return Dots.sort(compare2);
        }
        case "Экспоненциальная:":{
            for(let i = xMin; i < xMax; i += density){
                let x = i < xNull? -i : i - xNull;
                let y = parseFloat(koefs[0]) * Math.exp(parseFloat(koefs[1]) * x);
                let dot = {
                    x: x,
                    y: y
                }
                Dots.push(dot);
            }
            return Dots.sort(compare2);
        }
        case "Логарифмическая:":{
            for(let i = xMin; i < xMax; i += density){
                let x = i < xNull? -i : i - xNull;
                let y = parseFloat(koefs[0]) *Math.log(x) + parseFloat(koefs[1]);
                let dot = {
                    x: x,
                    y: y
                }
                Dots.push(dot);
            }
            return Dots.sort(compare2);
        }
        case "Квадратичная:":{
            for(let i = xMin; i < xMax; i += density){
                let x = i < xNull? -i : i - xNull;
                let y = parseFloat(koefs[0]) + parseFloat(koefs[1])* x + parseFloat(koefs[2]) * Math.pow(x, 2);
                let dot = {
                    x: x,
                    y: y
                }
                Dots.push(dot);
            }
            return Dots.sort(compare2);
        }
    }

}
function getKoefs(k){
    let koefs = [];
    for(let i = 0; i <  functionsObjects[k].acoefficients.length; i++){
        if(document.getElementById(k + "" + i + "input") == null){
            koefs[i] = 0;
        }
        else koefs[i] = document.getElementById(k + "" + i + "input").value;
    }
    return koefs;
}
function getChosenBoxes(){
   let chosenN = [];
   let boxes = document.getElementsByClassName("checkBoxes");
   for(let i = 0; i < boxes.length; i++){
       if(boxes[i].checked){
           chosenN.push(i);
       }
   }
   return chosenN;
}
function createDotsSet() {
    let chosenN = getChosenBoxes();
    let dotSet = [];
    for(let i = 0; i < chosenN.length; i++){
        let method = document.getElementById("methodLabel" + chosenN[i]);
        dotSet.push(createDotsForDraw(getKoefs(chosenN[i]), method.innerText));
    }
    return dotSet;
}
function compare2(a, b){
    let x1 = parseFloat(a.x);
    let x2 = parseFloat(b.x);
    if (x1 > x2) return 1;
    if (x2 > x1) return -1;

    return 0;
}
