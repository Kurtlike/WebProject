
document.getElementById('inputFile').onchange = function () {
    const selectedFile = this.files[0];
    let reader = new FileReader();
    if(selectedFile != null) {
        reader.readAsText(selectedFile);
        reader.onload = function () {
            setDots(parseTxt(reader.result));
        };
    }
}
function parseTxt(string){
    let dots = [];
    let dotsString = string.split('\r\n');
    for(let i = 0; i < dotsString.length; i++){
        let x = dotsString[i].split(';')[0];
        let y = dotsString[i].split(';')[1];
        dots.push({x, y});
    }
   return dots;
}