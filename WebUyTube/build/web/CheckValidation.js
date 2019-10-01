/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var req;
var mail;
var nick;
var mailValid;
var nickValid;


function initValidation(){
    mail = document.getElementById('userMail').value;
    nick = document.getElementById('userNick').value;
    mailValid = document.getElementById('UsedMail');
}

function CheckMail(){
    var url = "checkValidation?action=CheckMail&id=" + escape(mail);
    req = InitRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callbackMail();
    req.send(null);    
}

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function callbackMail(){
    if(req.readyState == 4){
        if(req.status == 200){
            validarMail(req.responseXML);
        }
    }
}

function validarMail(responseXML){
    if(responseXML == null){
        mailValid.innerHTML = 'Mail en uso';
        return false;
    }
    else{
        mailValid.innerHTML = '';
        return true;
        }
}