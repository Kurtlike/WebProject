
let presetsSelect = document.getElementById("presets");
window.onload=function () {
    for(let i = 0; i < 12; i++){
        addDotForm(i);
    }
    addPresets();
    let event = new Event("change");
    presetsSelect.dispatchEvent(event);
}

function addDotForm(i) {
    let dotForm = document.createElement("div");
    let label = document.createElement("label");
    let xForm = document.createElement("input");
    let yForm = document.createElement("input");
    dotForm.className = "dotForms";
    label.innerText = i +":";
    xForm.type = "text";
    yForm.type = "text";
    dotForm.append(label, xForm, yForm);
    dynamicDotsForm.append(dotForm);
}

function addPresets(){
    let presetParabola = document.createElement("option");
    presetParabola.text = "Парабола";
    presetParabola.value = "Parabola";
    let presetSin = document.createElement("option");
    presetSin.text = "Синусоида";
    presetSin.value = "Sin";
    let presetLinear = document.createElement("option");
    presetLinear.text = "Линейная функция";
    presetLinear.value = "Linear";
    presetsSelect.append(presetParabola, presetSin, presetLinear);
}