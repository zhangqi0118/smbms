var userObj;
//�û�����ҳ���ϵ��ɾ����ť����ɾ����(userlist.jsp)
function deleteUser(obj){
 if(obj.attr("sessionId")==obj.attr("userid")){
 	alert("ȷ��Ҫɾ���Լ�?")
 }
	$.ajax({
		type:"GET",
		url:path+"/delUserById",
		data:{method:"delUserById",id:obj.attr("userid")},
		dataType:"text",
		success:function(data){
			if(data == "true"){//ɾ���ɹ����Ƴ�ɾ����
				cancleBtn();
				alert("ɾ���û���"+obj.attr("username")+"���ɹ�");
				location.href=path+"/getUserByUserNameAndroleName";
				//	obj.parents("tr").remove();
			}else if(data == "false"){//ɾ��ʧ��
				alert("�Բ���ɾ���û���"+obj.attr("username")+"��ʧ��");
				changeDLGContent("�Բ���ɾ���û���"+obj.attr("username")+"��ʧ��");
			}else if(data == "notexist"){
				alert("�Բ����û���"+obj.attr("username")+"��������");
				changeDLGContent("�Բ����û���"+obj.attr("username")+"��������");
			}
		},
		error:function(data){
			//alert("�Բ���ɾ��ʧ��");
			changeDLGContent("�Բ���ɾ��ʧ��");
		}
	});
// }else {
// 	alert("����ɾ���Լ�")
//
// 	cancleBtn();
// }
}
function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//ͨ��jquery��classѡ���������飩
	//��ÿ��classΪviewUser��Ԫ�ؽ��ж����󶨣�click��
	/**
	 * bind��live��delegate
	 * on
	 */
	$(".viewUser").on("click",function(){
		//�����󶨵�Ԫ�أ�a��ת����jquery���󣬿���ʹ��jquery����
		var obj = $(this);
		window.location.href=path+"/viewUser?id="+obj.attr("userid");
	});
	
	$(".modifyUser").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/toUserModify?id="+ obj.attr("userid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	


	$(".deleteUser").on("click",function(){
		userObj = $(this);

		changeDLGContent("��ȷ��Ҫɾ���û���"+userObj.attr("username")+"����");
		openYesOrNoDLG();
	});
	$('#yes').click(function () {
		deleteUser(userObj);
	});
	// $(".deleteUser").on("click",function(){
	// 	var obj = $(this);
	// 	if(confirm("��ȷ��Ҫɾ���û���"+obj.attr("username")+"����")){
	// 		$.ajax({
	// 			type:"GET",
	// 			url:path+"/delUserById",
	// 			data:{method:"delUserById",id:obj.attr("userid")},
	// 			dataType:"text",
	// 			success:function(data){
	// 				if(data == "true"){//ɾ���ɹ����Ƴ�ɾ����
	// 					alert("ɾ���ɹ�");
	// 					obj.parents("tr").remove();
	// 				}else if(data == "false"){//ɾ��ʧ��
	// 					alert("�Բ���ɾ���û���"+obj.attr("username")+"��ʧ��");
	// 				}else if(data == "notexist"){
	// 					alert("�Բ����û���"+obj.attr("username")+"��������");
	// 				}
	// 			},
	// 			error:function(data){
	// 				alert("�Բ���ɾ��ʧ��");
	// 			}
	// 		});
	// 	}
	// });
});