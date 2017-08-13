$(function(){
	$('#modal-dialog').on('click','.ok',doSave);
	$('#addOption').click(doAddOption);	
	$('.del').click(deleteDoc);
	$('#modal-dialog').on("hidden.bs.modal",function(){
		$(this).off('click','.ok').removeData('id');
	});
});

function doSaveOption(){
	var optionUrl = 'saveOption.do';
	//console.log(optionUrl);
	var optionParams = getOptionData();
	for(var i=0;i<optionParams.length;i++){
		$.post(optionUrl,optionParams[i],function(result){
			if(result != 1){
				alert('创建失败');
			}
});
	}
	
}
function doSave(){
	var voteUrl = 'save.do';
	var voteParams = getVoteData();
	console.log(voteParams.option_states);
	console.log(voteParams.id);
	//将vote的id绑定到模态框
	$('#modal-dialog').data('id',voteParams.id);
	$.post(voteUrl,voteParams,function(result){
		if(result == 1){
			//隐藏模态框
			$('#modal-dialog').modal('hide');
			doGetObjects();
			doSaveOption();
		}else{
alert('创建失败');
		}
	});
	
	//console.log(voteUrl);
}
function getOptionData(){
	var list = new Array();
	var arr = $('.option').toArray();
	for(var i=0;i<arr.length;i++){
		list[i] = {
			'id':parseInt(Math.random()*1000),
			'voteId':$('#modal-dialog').data('id'),
			'option':$(arr[i]).val()
		};
	}
	return list;
}

function getVoteData(){
	var params = {
'id':parseInt((Math.random())*1000),
		'theme':$('#title').val(),
		'option_states':$('input[name="type"]:checked').val(),
		'endTime':$('#time').val(),
		'vote_states':$('input[name="isHidden"]:checked').val()
	}
	return params;
}
//删除选项
function deleteDoc(){
	$(this).parent().parent("tr").remove();
} 
//添加选项
function doAddOption(){
	$('#options').
	after('<tr><td><input  class="option"/></td><td><a href="#" class="del">x</a></td></tr>')
	$('.del').click(deleteDoc);
}
