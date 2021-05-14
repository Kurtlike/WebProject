window.onload=function () {
    let promise = fetch("/getOnload", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        updateForms(data);
    });
}

function updateForms(data) {
    let func = data.functions;
    let meth = data.methods;

    for(let i = 0; i < func.length; i++){
        let funkO = document.createElement("option");
        funkO.value = func[i];
        funkO.text = func[i];
        document.getElementById("function").append(funkO);
    }
    for(let i = 0; i < meth.length; i++){
        let methO = document.createElement("option");
        methO.value = meth[i];
        methO.text = meth[i];
        document.getElementById("method").append(methO);
    }
    reload();
}
