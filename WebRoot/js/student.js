$(document).ready(function(){
	$('.list-unstyled').on('click','.btn-search',findStudents);
	$('#pageId').on('click','.pre,.next,.first,.last',jumpToPage);
	$('#studentBodyId').on('click','.btn-select',alertId);
	getClassTable();
	findStudents();
});

function alertId() {
	var id = $(this).parent().parent().data('id');
	alert(id);
}

//得到班级名
function getClassTable() {
	var url = 'findAllClasses.do';
	$.get(url,function(list){
		setClassTables(list);
	});
}

//查询学员列表
function findStudents() {
	var url = 'findAllStudents.do';
	//console.log(url);
	var params = getStudentData();
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(pageCurrent){
		params.pageCurrent = pageCurrent
		//console.log(params);
	};
	/*if(!$(this).hasClass('btn-search')){
		params = {'class_id':$(this).text()};
	}*/
	$.post(url,params,function(result){
		
		setStudentTables(result);
		setPagination(result.pageObject);
	});
}

//得到查询参数
function getStudentData() {
	var params = {
		'studentname':$('#searchNameId').val(),
		'study_type':$('#searchTypeId :selected').val(),
		'class_id':$('#searchClassId :selected').val(),
		'empStatus':$('#searchJobId :selected').val(),
		//'pageCurrent':2
	}
	//console.log('getStudetnData');
	/*var params = {
			'studentname':'小乔',
			'studyType':'VIP',
			'classId':'java1708',
			'empStatus':'2',
	}*/
	return params;
}

function setClassTables(list) {
	var sel = $('#searchClassId');
	var option = '<option value="[id]">[class_name]<option>';
	for(var i in list) {
		sel.append(option.replace('[id]',list[i].id).replace('[class_name]',list[i].class_name));
	}
}

//填充学员表
function setStudentTables(result) {
	var list = result.list;
	var num = result.pageObject.rowCount;
	$('#num').html(num);
	var tBody = $('#studentBodyId');
	tBody.empty();
	var temp = '<td><input type="radio" name="student" value=[id]></td>'
			+'<td>[studentname]</td>'
			+'<td>[age]</td>'
			+'<td>[gender]</td>'
			+'<td>[tel]</td>'
			+'<td>[education]</td>'
			+'<td><input type="button" class="btn-select" id=[id] value="详情"></td>'
			+'<td>[remark]</td>'
			//追加新数据
	for(var i in list){//循环一次去一行数据
		var tr = $('<tr></tr>');//创建一对tr对象
		tr.data('id',list[i].id);//绑定数据备用
		tr.append(temp.replace('[id]',list[i].id).replace('[studentname]',list[i].studentname)
				.replace('[age]',list[i].age).replace('[gender]',list[i].gender)
				.replace('[tel]',list[i].tel).replace('[education]',list[i].education)
				.replace('[remark]',list[i].remark));
		tBody.append(tr);//将tr对象追加tBody
	}
}


function jumpToPage(){
	//获得点击对象的class对应的属性
	var cl = $(this).attr('class');
	//获得pageID对象上绑定的pageCurrent对应的值
	var pageCurrent = $('#pageId').data('pageCurrent');
	//获得pageId对象上绑定的pageCount对应的值
	var pageCount = $('#pageId').data('pageCount');
	//判断点击的是否是上一页
 	if(cl == 'pre' && pageCurrent > 1){
		pageCurrent--;
	}
	//判断点击是否是下一页
	if(cl == 'next' && pageCurrent < pageCount){
		pageCurrent++;
	}
	if(cl == 'first'){
		pageCurrent = 1;
	}
	if(cl == 'last'){
		pageCurrent = pageCount;
	}
	//重新绑定pageCurrent的值
	$('#pageId').data('pageCurrent',pageCurrent);
	findStudents();
}
function setPagination(pageObject){
	$("#pageId").data("pageCount",pageObject.pageCount);
	$("#pageId").data("pageCurrent",pageObject.pageCurrent);
	//console.log(pageObject.pageCount);
}











