$(function() {

	/**
	 * 登录表单提交事件
	 */
	$("#loginSubmit").click(function() {
		$("#loginSubmit").attr("disabled", "diasbled");
		var userName = $("#userName").val();
		var password = $("#password").val();
		var regu = "^[a-zA-Z0-9]{6,18}$";
		if (!isPattern(userName, regu)) {
			$("#userName").select();
			$("#errorShow").html("用户名由6-18位数字或字母组成");
			$("#loginSubmit").attr("disabled", false);
			return;
		}
		if (!isBettweenLength(password, 6, 18)) {
			$("#password").select();
			$("#errorShow").html("密码由6-18位字符组成");
			$("#loginSubmit").attr("disabled", false);
			return;
		}
		password = hex_md5($("#password").val());
		$.ajax({
			type : "POST",
			url : "loginSubmit.jhtml",
			data : {
				"userName" : userName,
				"password" : password
			},
			dataType : "json",
			error : function() {
				$("#errorShow").html("连接失败..");
				$("#loginSubmit").attr("disabled", false);
			},
			success : function(data) {
				data = eval("("+data+")");
				if (data.result != undefined && data.result == "true") {
					window.location.href = $("#loginForm").attr("action");
				} else {
					$("#errorShow").html(data.error);
					$("#loginSubmit").attr("disabled", false);
				}
			}
		});
		return true;
	});

});