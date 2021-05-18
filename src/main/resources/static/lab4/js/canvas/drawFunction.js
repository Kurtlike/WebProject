let density = 0.01;

function createDotsForDraw (koefs) {
    let Dots = [];
    for(let i = xMin; i < xMax; i += density){
        let x = i < xNull? -i : i - xNull;
        let y = 0;
        for(let j = 0; j < koefs.length; j++){
            y+= koefs[j] * Math.pow(x, j);
        }
        let dot = {
            x: x,
            y: y
        }
        Dots.push(dot);
    }
    return Dots.sort(compare2);
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
        dotSet.push(createDotsForDraw(getKoefs(chosenN[i])));
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
