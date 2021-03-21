let main=document.getElementsByClassName("main").item(0);
window.onload=function () {
let promise = fetch("/getSCPArticle").
    then(response => {
        return response.json();
    }).then((data) =>{
        console.log(data);
        main.append(createArticle(data));
    });
}

function createArticle(articleObj){
    let mainDiv = document.createElement('div');
    mainDiv.className = "SCPArticle";
    mainDiv.innerHTML = "" +
        "        <div class = \"SCPPic\">\n" +
        "            <img src =" + articleObj.picUrl + " height = 200 width = 300>\n" +
        "        </div>\n" +
        "        <div class = \"articleText\">\n" +
        "            <p>SCP-" + articleObj.number + "</p>\n" +
        "            <p>Класс:" + articleObj.scpclass + "</p>\n" +
        "            <p>" + articleObj.text + "</p>\n" +
        "        </div>"
    return mainDiv;
}