let main=document.getElementsByClassName("main").item(0);
window.onload=function () {
    let promise = fetch("/getSCPArticleTitles").
        then(response => {
            return response.json();
        }).then((data) =>{
            createArticleTitles(data);
        });
}
function createArticleTitles(titlesObj){
    let titlesDiv = document.createElement("div");
    titlesDiv.className = "SCPTitles";
    let mainH = "";
    for(let i = 0; i < titlesObj.length; i++){
       mainH += "<div id = "+ titlesObj[i] +">" +
           "<button type='submit' class='button' onclick = createArticle('" + titlesObj[i] +"') >" + titlesObj[i] +"</button>" +
           "</div>"
    }
    titlesDiv.innerHTML = mainH;
    main.append(titlesDiv)

}
function createArticle(name){
    let promise = fetch("/getSCPArticle",{
        method : 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body:  JSON.stringify({name: name})
    }).
    then(response => {
        return response.json();
    }).then((articleObj) =>{
        let mainDiv = document.createElement('div');
        mainDiv.className = "SCPArticle";
        mainDiv.innerHTML = "" +
            "        <div class = \"SCPPic\">\n" +
            "            <img src =" + articleObj.picUrl + " height = 200 width = 300>\n" +
            "        </div>\n" +
            "        <div class = \"articleText\">\n" +
            "            <p>" + articleObj.name + "</p>\n" +
            "            <p>Класс:" + articleObj.dangerClass + "</p>" +
            "            <p>Разумно:" + (articleObj.intelligence ? "да" : "нет") + "</p>" +
            "            <p>" + articleObj.text + "</p>\n" +
            "        </div>"
        document.getElementById(name).append(mainDiv);
    });
}