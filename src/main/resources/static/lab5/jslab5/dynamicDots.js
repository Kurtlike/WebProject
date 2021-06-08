let dynamicDotsForm = document.getElementById("dynamicDots");
let count = 0;
function setDots(dots) {
    deleteAll();

    for( let i = 0; i < dots.length; i++){
        addDotForm(i, dots[i].x, dots[i].y);
    }
}
function addDotForm(i, x, y) {
    let dotForm = document.createElement("div");
    let label = document.createElement("label");
    let xForm = document.createElement("input");
    let yForm = document.createElement("input");
    let deleteButton = document.createElement("button");
    dotForm.className = "dotForms";
    label.innerText = i +":";
    label.value = i;
    xForm.type = "text";
    xForm.value = x;
    yForm.type = "text";
    yForm.value = y;
    deleteButton.className = "deleteDotButtons";
    deleteButton.setAttribute('onclick', 'deleteDotForm('+ i +')');
    dotForm.append(label, xForm, yForm, deleteButton);
    dynamicDotsForm.append(dotForm);
    count++;
}
document.getElementById("addDot").onclick = function (){
    addDotForm(count,"", "");
}
function deleteDotForm(i){
    dynamicDotsForm.childNodes.forEach(element => deleteIfMatch(element, i))
}
function deleteIfMatch(element, i){
    if(element.getElementsByTagName("label")[0].value === (i)){
        element.remove();
    }
}
function getDots(){
    let dots = [];
    let dotForms = dynamicDotsForm.childNodes;
    for (let i = 0; i <dotForms.length; i++){
        let x = dotForms.item(i).getElementsByTagName("input")[0].value;
        let y = dotForms.item(i).getElementsByTagName("input")[1].value;
        dots.push({x,y});
    }
    dots.sort(compare);
    return dots;
}
function compare(a, b){
    let x1 = parseFloat(a.x);
    let x2 = parseFloat(b.x);
    if (x1 > x2) return 1;
    if (x2 > x1) return -1;

    return 0;
}
function deleteAll() {
    dynamicDotsForm.innerHTML = '';
    count = 0;
}