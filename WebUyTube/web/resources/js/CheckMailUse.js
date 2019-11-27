$(document).ready(function(){
    $("#email").keyup(function(){
        $.ajax({
            url : 'CheckMail', data:{
            email : $('#email').val()
            },
            success : function(responseText){
                $("#mail").text(responseText);
            }
        });
    });
});

$(document).ready(function(){
    $("#nickname").keyup(function(){
        $.ajax({
            url : 'CheckNick', data:{
            usernick : $('#nickname').val()
            },
            success : function(responseText){
                $("#nick").text(responseText);
            }
        });
    });
});
