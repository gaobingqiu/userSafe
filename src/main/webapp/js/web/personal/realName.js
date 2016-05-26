function realNameValid(){
	var realName = $("#userName").val();
	var idNum = $("#certNum").val();
	$.ajax({
		type : "POST",
		url : "/personal/update.do",
		data : {
			"userName" : realName,
			"idNum" : idNum,
		},
		success : function(data) {
			alert("认证成功！");
		},
		error : function() {
			alert("获取连接异常！");
		}
	});
}