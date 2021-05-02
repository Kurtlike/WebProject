window.onload=function () {
    let promise = fetch("/getMethods", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        updateForms(data);
    });
}

function updateForms() {

}
