/*-------成绩 考核结果 增加层--------*/

function seeOrder() {
	//var b = $("#examineCompileAndAddDiv").height() + 140;//获取高度	 
	$("#seeOrderDiv").dialog( {
		modal : true,
		width : 500,
		height : 250,
		show : "blind",
		hide : "blind",
		buttons : {

			"修改" : function() {

				//获得修改的补考成绩               
			var makeUpScoreAdd = $("#addInputScore").val();
			var makeUpCountAdd = $("#makeUpCountAdd").html();
			var markIdAdd = $("#markIdAdd").html();

			alert("修改成功！");
			//调用添加补考分数的函数
			AddScore(markIdAdd, makeUpScoreAdd, makeUpCountAdd);
			$(this).dialog("close");
			//当关闭对话框的时候，将修改的考核成绩填充到考核结果的对话框				

			//调用获得更新补考分数的查询数据
			updateMakeUp(markIdAdd);

		},
		"关闭" : function() {
			var a = confirm("确定取消？");
			if (a == true) {
				$(this).dialog("close");
			} else {
				return false;
			}
		},
		"重置" : function() {

		}
		}
	});
}
/*-------成绩 考核结果 编辑 增加层 结束---------*/