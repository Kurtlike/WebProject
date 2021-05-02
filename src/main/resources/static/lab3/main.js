function getAnswer(){
    let promise = fetch("/getAnswer",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body:  JSON.stringify({
            selectedFunction: document.getElementById("function").value,
            selectedMethod: document.getElementById("method").value,
            leftBorder: document.getElementById("left").value,
            rightBorder: document.getElementById("right").value,
            accuracy: document.getElementById("accuracy").value,
            n: document.getElementById("n").value,
        })
    }).then(response =>{
        return response.json();
    }).then((answer) =>{
        setAnswers(answer);
    });
}
function setAnswers(answer){
    document.getElementsByClassName("answer")[0].innerText = "Ответ =" + answer.answer + "\n Колличество итераций =" + answer.numberOfIterations;
}
