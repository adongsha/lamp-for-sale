/*-------�ɼ� ���˽�� ���Ӳ�--------*/

function seeOrder() {
	//var b = $("#examineCompileAndAddDiv").height() + 140;//��ȡ�߶�	 
	$("#seeOrderDiv").dialog( {
		modal : true,
		width : 500,
		height : 250,
		show : "blind",
		hide : "blind",
		buttons : {

			"�޸�" : function() {

				//����޸ĵĲ����ɼ�               
			var makeUpScoreAdd = $("#addInputScore").val();
			var makeUpCountAdd = $("#makeUpCountAdd").html();
			var markIdAdd = $("#markIdAdd").html();

			alert("�޸ĳɹ���");
			//������Ӳ��������ĺ���
			AddScore(markIdAdd, makeUpScoreAdd, makeUpCountAdd);
			$(this).dialog("close");
			//���رնԻ����ʱ�򣬽��޸ĵĿ��˳ɼ���䵽���˽���ĶԻ���				

			//���û�ø��²��������Ĳ�ѯ����
			updateMakeUp(markIdAdd);

		},
		"�ر�" : function() {
			var a = confirm("ȷ��ȡ����");
			if (a == true) {
				$(this).dialog("close");
			} else {
				return false;
			}
		},
		"����" : function() {

		}
		}
	});
}
/*-------�ɼ� ���˽�� �༭ ���Ӳ� ����---------*/