function getAnswer(){
    let promise = fetch("lab4/getAnswer", {
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
}
