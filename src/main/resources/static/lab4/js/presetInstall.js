
let numberOfDots = 12;
let dots = [];
presetsSelect.onchange = function (){
    setPreset(presetsSelect.value);
}
function setPreset(Name){
    switch (Name){
        case "Parabola":{
            for(let i = 0; i <= numberOfDots; i++){
                let x = i - numberOfDots/2
                let y = Math.pow(x,2);
                dots[i] = {x, y}
            }
            break;
        }
        case "Sin":{
            for(let i = 0; i <= numberOfDots; i++){
                let x = i - numberOfDots/2
                let y = Math.sin(x);
                dots[i] = {x, y}
            }
            break;
        }
        case "Linear":{
            for(let i = 0; i <= numberOfDots; i++){
                let x = i - numberOfDots/2
                let y = x;
                dots[i] = {x, y}
            }
            break;
        }
    }
}