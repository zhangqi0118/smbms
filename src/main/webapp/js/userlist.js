var userObj;
//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteUser(obj){
 if(obj.attr("sessionId")==obj.attr("userid")){
 	alert("确定要删除自己?")
 }
	$.ajax({
		type:"GET",
		url:path+"/delUserById",
		data:{method:"delUserById",id:obj.attr("userid")},
		dataType:"text",
		success:function(data){
			if(data == "true"){//删除成功：移除删除行
				cancleBtn();
				alert("删除用户【"+obj.attr("username")+"】成功");
				location.href=path+"/getUserByUserNameAndroleName";
				//	obj.parents("tr").remove();
			}else if(data == "false"){//删除失败
				alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除用户【"+obj.attr("username")+"】失败");
			}else if(data == "notexist"){
				alert("对不起，用户【"+obj.attr("username")+"】不存在");
				changeDLGContent("对不起，用户【"+obj.attr("username")+"】不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
// }else {
// 	alert("不能删除自己")
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
	//通过jquery的class选择器（数组）
	//对每个class为viewUser的元素进行动作绑定（click）
	/**
	 * bind、live、delegate
	 * on
	 */
	$(".viewUser").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
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

		changeDLGContent("你确定要删除用户【"+userObj.attr("username")+"】吗？");
		openYesOrNoDLG();
	});
	$('#yes').click(function () {
		deleteUser(userObj);
	});
	// $(".deleteUser").on("click",function(){
	// 	var obj = $(this);
	// 	if(confirm("你确定要删除用户【"+obj.attr("username")+"】吗？")){
	// 		$.ajax({
	// 			type:"GET",
	// 			url:path+"/delUserById",
	// 			data:{method:"delUserById",id:obj.attr("userid")},
	// 			dataType:"text",
	// 			success:function(data){
	// 				if(data == "true"){//删除成功：移除删除行
	// 					alert("删除成功");
	// 					obj.parents("tr").remove();
	// 				}else if(data == "false"){//删除失败
	// 					alert("对不起，删除用户【"+obj.attr("username")+"】失败");
	// 				}else if(data == "notexist"){
	// 					alert("对不起，用户【"+obj.attr("username")+"】不存在");
	// 				}
	// 			},
	// 			error:function(data){
	// 				alert("对不起，删除失败");
	// 			}
	// 		});
	// 	}
	// });
});