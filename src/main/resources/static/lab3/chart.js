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
let scale = 50;
let lineScale = 1 * scale; // 50px = 1;
ctx.fillStyle = "#ffffff";
ctx.strokeStyle = "rgba(255,255,255,.25)"
ctx.font = 'bold 15px sans-serif';
function createXAxis(){
    ctx.setLineDash([1, 1]);
    ctx.beginPath();
    ctx.moveTo(xMin, yNull);
    ctx.lineTo(xMax, yNull );
    ctx.closePath();
    ctx.stroke()
    let linesLessNull = div((xNull - xMin), lineScale);
    ctx.setLineDash([4, 16]);
    for(let i = 1; i < linesLessNull; i++){
        ctx.beginPath();
        ctx.moveTo(xNull - lineScale * i, yMin);
        ctx.lineTo(xNull - lineScale * i, yMax);
        ctx.closePath();
        ctx.stroke();
        ctx.fillText("-" + i,xNull - lineScale * i - 20, yNull + 20, 20 );
    }
    let linesMoreNull = div((xMax - xNull), lineScale);
    for(let i = 1; i < linesMoreNull; i++){
        ctx.beginPath();
        ctx.moveTo(xNull + lineScale * i, yMin);
        ctx.lineTo(xNull + lineScale * i, yMax);
        ctx.closePath();
        ctx.stroke();
        ctx.fillText( i,xNull + lineScale * i - 20, yNull + 20, 20 );
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
    let linesLessNull = div((yMax - yNull), lineScale);
    ctx.setLineDash([4, 16]);
    for(let i = 1; i < linesLessNull; i++){
        ctx.beginPath();
        ctx.moveTo(xMin, yNull + lineScale * i);
        ctx.lineTo(xMax, yNull + lineScale * i);
        ctx.closePath();
        ctx.stroke();
        ctx.fillText("-" + i,xNull - 20, yNull + lineScale * i, 20 );
    }
    let linesMoreNull = div((yNull - yMin), lineScale);
    for(let i = 1; i < linesMoreNull; i++){
        ctx.beginPath();
        ctx.moveTo(xMin, yNull - lineScale * i);
        ctx.lineTo(xMax, yNull - lineScale * i);
        ctx.closePath();
        ctx.stroke();
        ctx.fillText( i,xNull - 20, yNull - lineScale * i, 20 );
    }
}
function div(val, by){
    return (val - val % by) / by;
}
canvas.onclick = function(event) {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    xNull = event.offsetX;
    yNull = event.offsetY;
    reload()
}
document.getElementById('SIZE').onchange = function (){
    scale = this.value;
    lineScale = 1 * scale;
}
function reload(){
    createXAxis();
    createYAxis();
}
reload();