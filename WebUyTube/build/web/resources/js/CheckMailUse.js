$(document).ready(function(){
    $("#userMail").keyup(function(){
        $.ajax({
            url : 'CheckMail', data:{
            mail : $('#userMail').val()
            },
            success : function(responseText){
                $("#UsedMail").text(responseText);
            }
        });
    });
});

$(document).ready(function(){
    $("#userNick").keyup(function(){
        $.ajax({
            url : 'CheckNick', data:{
            nick : $('#userNick').val()
            },
            success : function(responseText){
                $("#UsedNick").text(responseText);
            }
        });
    });
});
