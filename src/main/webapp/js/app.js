$(document).ready(function(event) {	
		$("#role").change(function() {
		alert("123");
		var role=$(this).val();
			$.ajax({
			type : "GET",
			url : "getacc?urole=" + role,
			success : function(html) {
				$('#spd').html(html);
			}
			});
		});
});

$(document).ready(function(e) {
	$("#email").blur(function(event) {
		$("#dupEmail").html("");
		var emailId = $("#email").val();
		$.ajax({
			url : 'validateEmail?email=' + emailId,
			success : function(abc) {
				if (abc == 'Duplicate') {
					$("#dupEmail").html("Email already registered");
					$("#email").focus();
				}
			}
		});
	});
});

function validatePwds() {
	var newPwd = $('#newPwd').val();
	var confirmPwd = $('#cnfPwd').val();
	if (newPwd != confirmPwd) {
		$('#errId').text('New Password & Confirm Password Should Be Same');
		return false;
	}
	return true;
}