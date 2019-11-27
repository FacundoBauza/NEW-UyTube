$(document).ready(function(){
    $("#email").keyup(function(){
        $.ajax({
            url : 'CheckMail',
            type: 'POST',
            data : {mail : $('#email').val()},
            success : function(responseText){
                $("#UsedMail").text(responseText);
            }
        });
    });
});

$(document).ready(function(){
    $("#nickname").keyup(function(){
        $.ajax({
            url : 'CheckNick', data:{
            nick : $('#nickname').val()
            },
            success : function(responseText){
                $("#UsedNick").text(responseText);
            }
        });
    });
});
