let canvas = document.getElementById('canvas');
let chart = document.getElementsByClassName('chart')[0];
let ctx = canvas.getContext('2d');

canvas.width = chart.clientWidth;
canvas.height = chart.clientHeight;

let x;
let y;
let xMax = canvas.width;
let yMax = canvas.height;
let xMin = 0;
let yMin = 0;
let xNull = canvas.width / 2;
let yNull = canvas.height / 2;
let offsetX = 0;
let offsetY = 0;
let size = 10;
let scale = 100;
let xScale = scale;
let yScale = scale;
ctx.lineWidth = 1;
ctx.fillStyle = "#ffffff";
ctx.strokeStyle = "rgba(255,255,255,.25)"
ctx.font = 'bold 15px sans-serif';
let currentFunc = document.getElementById('function');
let density = 0.01;
let dotsSetBelowZero = [];
let dotsSetAboveZero = [];
function createXAxis(){
    ctx.setLineDash([1, 1]);
    ctx.beginPath();
    ctx.moveTo(xMin, yNull);
    ctx.lineTo(xMax, yNull );
    ctx.closePath();
    ctx.stroke()
    let linesLessNull = div((xNull - xMin), xScale);
    ctx.setLineDash([4, 16]);
    function paintLineLessNull(i) {
        ctx.beginPath();
        ctx.moveTo(xNull - xScale * i, yMin);
        ctx.lineTo(xNull - xScale * i, yMax);
        ctx.closePath();
        ctx.stroke();
        ctx.fillText("-" + i, xNull - xScale * i - 20, yNull + 20, 20);
    }
    for(let i = 1; i < linesLessNull; i++){
        if(xScale > 70) {
            paintLineLessNull(i);
        }
        else if(xScale > 40) {
            if(i % 2 == 0) {
                paintLineLessNull(i);
            }
        }
        else {
            if(i % 10 == 0) {
                paintLineLessNull(i);
            }
        }
    }
    function paintLineMoreNull(i) {
        ctx.beginPath();
        ctx.moveTo(xNull + xScale * i, yMin);
        ctx.lineTo(xNull + xScale * i, yMax);
        ctx.closePath();
        ctx.stroke();
        ctx.fillText(i, xNull + xScale * i - 20, yNull + 20, 20);
    }
    let linesMoreNull = div((xMax - xNull), xScale);
    for(let i = 1; i < linesMoreNull; i++){
        if(xScale > 70) {
            paintLineMoreNull(i);
        }
        else if(xScale > 40) {
            if(i % 2 == 0) {
                paintLineMoreNull(i);
            }
        }
        else {
            if(i % 10 == 0) {
                paintLineMoreNull(i);
            }
        }
    }
    ctx.fillText('0',xNull - 20, yNull + 20, 20 );
}
function createYAxis(){
    ctx.setLineDash([1, 1]);
    ctx.beginPath();
    ctx.moveTo(xNull, yMax);
    ctx.lineTo(xNull, yMin );
    ctx.closePath();
    ctx.stroke()
    let linesLessNull = div((yMax - yNull), yScale);
    ctx.setLineDash([4, 16]);
    function paintLineLessNull(i) {
        ctx.beginPath();
        ctx.moveTo(xMin, yNull + yScale * i);
        ctx.lineTo(xMax, yNull + yScale * i);
        ctx.closePath();
        ctx.stroke();
        ctx.fillText("-" + i, xNull - 20, yNull + yScale * i, 20);
    }
    for(let i = 1; i < linesLessNull; i++){
        if(yScale > 70) {
            paintLineLessNull(i)
        }
        else if(yScale > 40) {
            if(i % 2 == 0) {
                paintLineLessNull(i)
            }
        }
        else {
            if(i % 10 == 0) {
                paintLineLessNull(i)
            }
        }
    }
    function paintLineMoreNull(i) {
        ctx.beginPath();
        ctx.moveTo(xMin, yNull - yScale * i);
        ctx.lineTo(xMax, yNull - yScale * i);
        ctx.closePath();
        ctx.stroke();
        ctx.fillText(i, xNull - 20, yNull - yScale * i, 20);
    }
    let linesMoreNull = div((yNull - yMin), yScale);
    for(let i = 1; i < linesMoreNull; i++){
        if(yScale > 70) {
            paintLineMoreNull(i)
        }
        else if(yScale > 40) {
            if(i % 2 == 0) paintLineMoreNull(i)
        }
        else {
            if(i % 10 == 0) paintLineMoreNull(i)
        }
    }
}
function div(val, by){
    return (val - val % by) / by;
}
canvas.onmousedown = function(event) {
    let x1 = event.offsetX;
    let y1 = event.offsetY;
    canvas.onmouseup = function (event2){
        xNull = xNull + event2.offsetX - x1;
        yNull = yNull - (y1 - event2.offsetY) ;
        reload()
    }

}
document.getElementById('XSIZE').onchange = function (){
    xScale = this.value;
}
document.getElementById('YSIZE').onchange = function (){
    yScale = this.value;
}
function createDots(){
   switch (currentFunc.value){
       case '1/x':{

           dotsSetBelowZero.splice(0,dotsSetBelowZero.length);
           for(let i = xMin; i < xNull; i += density){
               let x =-i;
               let dot = {
                   x: x,
                   y: 1/x
               };
               dotsSetBelowZero.push(dot);
           }
           dotsSetBelowZero.sort(compare);
           dotsSetAboveZero.splice(0,dotsSetAboveZero.length);
           for(let i = 0; i < xMax-xNull; i += density){
               let x = i;
               let dot = {
                   x: x,
                   y: 1/x
               };
               dotsSetAboveZero.push(dot);
           }
           dotsSetAboveZero.sort(compare);
           break;
       }
       case 'ln(x)':{
           dotsSetBelowZero.splice(0,dotsSetBelowZero.length);
           for(let i = xMin; i < xNull; i += density){
               let x =-i;
               let dot = {
                   x: x,
                   y: Math.log(x)
               };
               dotsSetBelowZero.push(dot);
           }
           dotsSetBelowZero.sort(compare);

           dotsSetAboveZero.splice(0,dotsSetAboveZero.length);
           for(let i = 0; i < xMax-xNull; i += density){
               let x = i;
               let dot = {
                   x: x,
                   y: Math.log(x)
               };
               dotsSetAboveZero.push(dot);
           }
           dotsSetAboveZero.sort(compare);
           break;
       }
       case 'x^3-3*x^2+6*x-19':{
           dotsSetBelowZero.splice(0,dotsSetBelowZero.length);
           for(let i = xMin; i < xNull; i += density){
               let x =-i;
               let dot = {
                   x: x,
                   y: Math.pow(x,3)-3 * Math.pow(x,2) + 6 * x - 19
               };
               dotsSetBelowZero.push(dot);
           }
           dotsSetBelowZero.sort(compare);

           dotsSetAboveZero.splice(0,dotsSetAboveZero.length);
           for(let i = 0; i < xMax-xNull; i += density){
               let x = i;
               let dot = {
                   x: x,
                   y: Math.pow(x,3)-3 * Math.pow(x,2) + 6 * x - 19
               };
               dotsSetAboveZero.push(dot);
           }
           dotsSetAboveZero.sort(compare);
           break;

       }
   }
}
function compare(a, b){
    if (a.x > b.x) return 1;
    if (b.x > a.x) return -1;

    return 0;
}
function drawFunc(){
    ctx.setLineDash([1, 0]);
    ctx.strokeStyle = "rgb(255,255,255)"
    ctx.lineWidth = 3;
    ctx.moveTo(dotsSetBelowZero[0].x, dotsSetBelowZero[0].y);
    ctx.beginPath();
    for (let i = 1; i < dotsSetBelowZero.length; i++) {
        let x = xNull + xScale * dotsSetBelowZero[i].x;
        let y = yNull - yScale * dotsSetBelowZero[i].y;
        let dot = checkCoord(x, y);
        ctx.lineTo(dot.x, dot.y);

    }
    ctx.stroke();

    ctx.moveTo(dotsSetAboveZero[0].x, dotsSetAboveZero[0].y);
    ctx.beginPath();
    for (let i = 1; i < dotsSetAboveZero.length; i++) {
        let x = xNull + xScale * dotsSetAboveZero[i].x;
        let y = yNull - yScale * dotsSetAboveZero[i].y;
        let dot = checkCoord(x, y);
        ctx.lineTo(dot.x, dot.y);

    }
    ctx.stroke();
    ctx.strokeStyle = "rgba(255,255,255,.25)";
    ctx.setLineDash([4, 16]);
    ctx.lineWidth = 1;
}
function checkCoord(x, y){
    let newX = x;
    let newY = y;
    if(x > xMax) newX = xMax;
    if(x < xMin) newX = xMin;
    if(y > yMax) newY = yMax;
    if(y < yMin) newY = yMin;
    return {
        x: newX,
        y: newY
    };
}
function drawZone() {
    let  left = Number(document.getElementById('left').value);
    let right = Number(document.getElementById('right').value);
    ctx.setLineDash([1, 0]);
    ctx.lineWidth = 3;
    ctx.moveTo(xNull + xScale * left, yNull);;
    ctx.beginPath();
    for(let i = 0; i < dotsSetBelowZero.length - 1; i++){
        if(dotsSetBelowZero[i].x >= left && dotsSetBelowZero[i].x <= right){
            let x = xNull + xScale * dotsSetBelowZero[i].x;
            let y = yNull - yScale * dotsSetBelowZero[i].y;
            let dot = checkCoord(x, y);
            ctx.lineTo(dot.x, dot.y);
        }
    }
    for(let i = 0; i < dotsSetAboveZero.length - 1; i++){
        if(dotsSetAboveZero[i].x >= left && dotsSetAboveZero[i].x <=  right){
            let x = xNull + xScale * dotsSetAboveZero[i].x;
            let y = yNull - yScale * dotsSetAboveZero[i].y;
            let dot = checkCoord(x, y);
            ctx.lineTo(dot.x, dot.y);
        }
    }
    ctx.lineTo(xNull + xScale * right, yNull);
    ctx.lineTo(xNull + xScale * left, yNull);
    ctx.fillStyle = "rgba(255, 255, 255, 0.3)";
    ctx.fill();
    ctx.setLineDash([4, 16]);
    ctx.lineWidth = 1;
}
function reload(){
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    createXAxis();
    createYAxis();
    createDots();
    drawFunc();
    drawZone();
}
reload();