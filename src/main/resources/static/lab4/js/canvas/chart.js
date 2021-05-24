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
ctx.font = 'bold 15px sans-serif';
let currentFunc = document.getElementById('function');
function createXAxis(){
    ctx.strokeStyle = "rgba(255,255,255,1)"
    ctx.setLineDash([1, 1]);
    ctx.beginPath();
    ctx.moveTo(xMin, yNull);
    ctx.lineTo(xMax, yNull );
    ctx.closePath();
    ctx.stroke()
    let linesLessNull = div((xNull - xMin), xScale);
    ctx.setLineDash([4, 16]);
    ctx.strokeStyle = "rgba(255,255,255,.25)"
    function paintLineLessNull(i) {
        ctx.beginPath();
        ctx.moveTo(xNull - xScale * i, yMin);
        ctx.lineTo(xNull - xScale * i, yMax);
        ctx.closePath();
        ctx.stroke();
        ctx.strokeStyle = "rgba(255,255,255,1)"
        ctx.fillText("-" + i, xNull - xScale * i - 20, yNull + 20, 20);
        ctx.strokeStyle = "rgba(255,255,255,.25)"
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
        ctx.strokeStyle = "rgba(255,255,255,1)"
        ctx.fillText(i, xNull + xScale * i - 20, yNull + 20, 20);
        ctx.strokeStyle = "rgba(255,255,255,.25)"
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
    ctx.strokeStyle = "rgba(255,255,255,1)"
    ctx.fillText('0',xNull - 20, yNull + 20, 20 );
    ctx.strokeStyle = "rgba(255,255,255,.25)"
}
function createYAxis(){
    ctx.strokeStyle = "rgba(255,255,255,1)"
    ctx.setLineDash([1, 1]);
    ctx.beginPath();
    ctx.moveTo(xNull, yMax);
    ctx.lineTo(xNull, yMin );
    ctx.closePath();
    ctx.stroke()
    let linesLessNull = div((yMax - yNull), yScale);
    ctx.setLineDash([4, 16]);
    ctx.strokeStyle = "rgba(255,255,255,.25)"
    function paintLineLessNull(i) {
        ctx.beginPath();
        ctx.moveTo(xMin, yNull + yScale * i);
        ctx.lineTo(xMax, yNull + yScale * i);
        ctx.closePath();
        ctx.stroke();
        ctx.strokeStyle = "rgba(255,255,255,1)"
        ctx.fillText("-" + i, xNull - 20, yNull + yScale * i, 20);
        ctx.strokeStyle = "rgba(255,255,255,.25)"
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
        ctx.strokeStyle = "rgba(255,255,255,1)"
        ctx.fillText(i, xNull - 20, yNull - yScale * i, 20);
        ctx.strokeStyle = "rgba(255,255,255,.25)"
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
        let x2 = event2.offsetX;
        let y2 = event2.offsetY;
        if(Math.abs(x2 - x1) < 5 && Math.abs(y2 - y1) < 5){
            let x = (x1-xNull)/xScale;
            let y = (-y1+yNull)/yScale;
            addDotForm(count, x ,y);
            drawDot(x, y, 15);
        }
        else {
            xNull = xNull + x2 - x1;
            yNull = yNull - (y1 - y2) ;
        }
        reload()
    }

}
document.getElementById('XSIZE').onchange = function (){
    xScale = this.value;
}
document.getElementById('YSIZE').onchange = function (){
    yScale = this.value;
}
function drawFunc(){
    let dotset = createDotsSet();
    ctx.setLineDash([1, 0]);
    ctx.strokeStyle = "rgb(255,255,255)"
    ctx.lineWidth = 3;
    let strokeStyles = ["rgb(107,188,151)","rgb(43,73,186)","rgb(210,48,48)","rgb(38,172,29)","rgb(255,255,255)","rgb(255,255,255)"]
    for(let i = 0; i < dotset.length; i++){
        ctx.strokeStyle = strokeStyles[i%5];
        let dots = dotset[i];
        ctx.moveTo(dots[0].x, dots[0].y);
        ctx.beginPath();
        for (let j = 1; j < dots.length; j++) {
            let x = xNull + xScale * dots[j].x;
            let y = yNull - yScale * dots[j].y;
            let dot = checkCoord(x, y);
            ctx.lineTo(dot.x, dot.y);
        }
        ctx.stroke();
    }

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
function drawDot(x, y, size){
    ctx.fillStyle = "rgba(255,0,0,0.7)";
    ctx.fillRect(xNull + xScale * x -size/2, yNull - yScale * y - size/2,  size, size);
    ctx.fillStyle = "rgba(255,255,255,1)";
    ctx.fillRect(xNull + xScale * x -size/6, yNull - yScale * y - size/6,  size/3, size/3);
    ctx.fillStyle = "rgba(255, 255, 255, 1)";
}
function reload(){
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    createXAxis();
    createYAxis();
    drawDotsForApproximate();
    drawFunc()
}
reload();