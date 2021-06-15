window.onload=function () {
    let promise = fetch("/lab6/getOnload", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        updateForms(data);
    });
}

function updateForms(data) {
    let func = data.functions;

    for(let i = 0; i < Object.keys(func).length; i++){
        let funkO = document.createElement("option");
        funkO.value = i;
        funkO.text = func[i];
        document.getElementById("function").append(funkO);
    }
}
