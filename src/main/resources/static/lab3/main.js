function getAnswer(){
    let left = document.getElementById("left").value;
    let right = document.getElementById("right").value;
    let accuracy = document.getElementById("accuracy").value;
    let n = document.getElementById("n").value;
    if(validateNum(left) && validateNum(right) && validatePositive(accuracy) && validateNatural(n)) {
        let promise = fetch("/lab3/getAnswer", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                selectedFunction: document.getElementById("function").value,
                selectedMethod: document.getElementById("method").value,
                leftBorder: left,
                rightBorder: right,
                accuracy: accuracy,
                n: n,
            })
        }).then(response => {
            return response.json();
        }).then((answer) => {
            setAnswers(answer);
        });
        document.getElementById("errorsText").innerText = "Отправленно";
    }
    else {
        document.getElementById("errorsText").innerText = "Ошибка ввода";
    }
}
function setAnswers(answer){
    document.getElementsByClassName("answer")[0].innerText = "Ответ =" + answer.answer + "\n Количество итераций =" + answer.numberOfIterations;
}

function validateNum(string){
    let re = new RegExp("^-?[0-9]*(,|\.)?[0-9]?$")
    return re.test(string);
}
function validatePositive(string) {
    let re = new RegExp("^0(,|\.)[0-9]*[1-9]$")
    return re.test(string);
}
function validateNatural(string) {
    let re = new RegExp("^[0-9]+$")
    return re.test(string);
}