window.onload=function () {
    let promise = fetch("/getOnload", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        updateForms(data);
    });
}

function updateForms() {

}
