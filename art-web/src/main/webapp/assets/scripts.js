$(function() {
    // Side Bar Toggle
    $('.hide-sidebar').click(function() {
	  $('#sidebar').hide('fast', function() {
	  	$('#content').removeClass('span9');
	  	$('#content').addClass('span12');
	  	$('.hide-sidebar').hide();
	  	$('.show-sidebar').show();
	  });
	});

	$('.show-sidebar').click(function() {
		$('#content').removeClass('span12');
	   	$('#content').addClass('span9');
	   	$('.show-sidebar').hide();
	   	$('.hide-sidebar').show();
	  	$('#sidebar').show('fast');
	});
});


formatDate = function(time) {
	var data = new Date(time);
	var year = data.getFullYear(); //获取年
	var month = data.getMonth() + 1; //获取月
	month = month < 10 ? "0" + month : month;
	var day = data.getDate(); //获取日
	day = day < 10 ? "0" + day : day;
	var hours = data.getHours();
	hours = hours < 10 ? "0" + hours : hours;
	var minutes = data.getMinutes();
	minutes = minutes < 10 ? "0" + minutes : minutes;
	var seconds = data.getSeconds();
	seconds = seconds < 10 ? "0" + seconds : seconds;
	var time = year + "-" + month + "-" + day + " " + hours + ":" + minutes
			+ ":" + seconds;
	return time;
}