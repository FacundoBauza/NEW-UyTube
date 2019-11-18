/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkExist() {
    var xmlhttp = new XMLHttpRequest();
    var nickname = document.forms["regF"]["nickname"].value;
    var url = "exist.jsp?nickname=" + nickname;
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            if (xmlhttp.responseText === "\n\n\n\n\nUser already exists")
                document.getElementById("isE").style.color = "red";
            else
                document.getElementById("isE").style.color = "green";
            document.getElementById("isE").innerHTML = xmlhttp.responseText;
        }

    };
    try {
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    } catch (e) {
        alert("unable to connect to server");
    }
}                   

