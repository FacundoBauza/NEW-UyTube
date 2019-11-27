$(document).ready(function() {
		$('#nickname').blur(function(event) {
			var nickname = $('#nickname').val();
			
			$.post('CheckNick', { nickname : nickname },  function(response){
                                                                        if(response == 0){
                                                                            alert('available')
                                                                        }
                                                                        else {
                                                                            alert('not available')
                                                                        }
                                                                    }
                        );
		});
	});
