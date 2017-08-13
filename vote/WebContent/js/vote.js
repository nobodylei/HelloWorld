$(document).ready(function(){
	$("#leftDiv").on('click','#btn-start',toVote);
	doGetObjects();
});
//删除投票
function deleteVote(){
	var url = 'deleteVote.do';
	var vote = $(this).parent().parent().parent().data('list');
	var params = {'id':vote.id};
	$.post(url,params,function(){
		//alert('已删除');
		//console.log('del');
		doGetObjects();
		var rightDiv = $('#rightV');
		rightDiv.empty();
	});
	
}
//添加投票
function toVote(){
	var url = "newWin.do";
	$('#modal-dialog .modal-body').load(url,function(){
		$('#modal-dialog').modal('show');
	});	
}
//显示投票选项
function doGetOptions(){
	var url = 'findOptions.do';
	var voteList = $(this).parent().parent().parent().data('list');
	console.log(voteList);
	var params = {'id':voteList.id};
	$.post(url,params,function(result){
		//console.log(result);
		setOptionsTable(result,voteList);
	});
}
//填充选项表单
function setOptionsTable(options,vote){
	var rightDiv = $('#rightV');
	rightDiv.empty();
	var table = $('<table></table>');
	table.data('list',vote);
	var temp = '<tr><td>'+vote.theme+'</td></tr><tr><td>'+(vote.option_states==1?"单选":"多选")+'</td></tr>';
	table.append(temp)
	var tOption = '<tr><td><input type='+(vote.option_states==1?"radio":"checkbox")+' name="option" value=[id]/>[option]</td><td>[num]</td></tr>';
	for(var i in options){
		//console.log(options[i]);
		table.append(tOption.replace('[option]',options[i].option).replace('[id]',options[i].id).replace('[num]',options[i].num));
	}
	var foot = '<tr><td><input type="button" id="doVote" value="投票"></td></tr>'
			+'<tr><td><a href="#" class="delVote">×删除投票</a></td>&nbsp;<td>'+vote.endTime+'</td></tr>';
	table.append(foot);
	rightDiv.append(table);
	$('.delVote').click(deleteVote);
	$('#doVote').click(doVote).click(doGetOptions);
}

//投票
function doVote(){
	var url = "doVote.do";
	var arr = $('input[name="option"]:checked').toArray();
  var params;
	for(var i=0;i<arr.length;i++){
		params = {'id':parseInt(arr[i].value)};
		$.post(url,params,function(){
		});
	}
}
//显示投票选项
function doGetObjects(){
	var url = "findVotes.do";
	//console.log(url);
	$.post(url,function(result){
		setVoteTable(result);
	});
}
//填充表单
function setVoteTable(list){
	var vDiv=$('#vote');
	vDiv.empty();
var temp='<tr><td><a href="#" class="voteTitle">[title]</a><td>'+
			 '<td><a href="#" class="delVote">x</a><td></tr>'+
			 '<tr><td>[createTime]</td>&nbsp;<td>进行中</td></tr><br/><hr/>';
	//追加新的数据
	for(var i in list){//循环一次取一行数据(对应一对tr对象)
		var time = new Date(list[i].createTime);
		var tr=$('<table></table>');//创建一对table对象
		tr.data('list',list[i]);
		//tr.data("id",list[i].id);//绑定数据,便于后续获得此数据进行修改等操作
		tr.append(temp
				.replace('[title]',list[i].theme)
				.replace('[createTime]',time.toLo
caleString())
		);
		vDiv.append(tr);//将tr对象追加tbody
	}
	$('.delVote').click(deleteVote);
	$('.voteTitle').click(doGetOptions);
}




