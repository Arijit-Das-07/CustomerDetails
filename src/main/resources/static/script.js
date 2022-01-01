
$(document).ready(function() {
	$("#primary").on('click',function(){
	var $mail = $('#search').val();
	$.ajax({
		type: 'GET',
		url: '/getbymailid/'+$mail,
		success: function(data){
		console.log(JSON.stringify(data))
      	alert("Data: " + JSON.stringify(data) + "\nStatus: " + status);
		}
	});
});

});