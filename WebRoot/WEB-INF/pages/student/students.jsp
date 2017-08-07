<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script src="${basePath}/jquery/jquery-1.11.1.js"></script>
<script src="${basePath}/js/students.js"></script>
<div class="row page-search">
	<div class="col-md-12">
		<ul class="list-unstyled list-inline">
			<li><input type="text" id="searchNameId" class="form-control"
				placeholder="姓名"></li>
			<li><select id="searchClassId" class="form-control">
					<option value="">选择班级</option>
					<option value="">全部</option>
			</select></li>
			<li><select id="searchJobId" class="form-control">
					<option value="">就业状态</option>
					<option value="">全部</option>
					<option value="1">已就业</option>
					<option value="2">未就业</option>
			</select></li>
			<li><select id="searchTypeId" class="form-control">
					<option value="">学习状态</option>
					<option value="">全部</option>
					<option value="休学">休学</option>
					<option value="VIP">VIP</option>
					<option value="脱产">脱产</option>
			</select></li>
			<li class='O1'><button type="button"
					class="btn btn-primary btn-search">查询</button>&nbsp;人数：<span
				id='num'></span></li>
		</ul>
	</div>
</div>
<div class="detial cl">
	<form action="">
		<input type="button" value="转班" /> <input type="button" value="VIP" />
	</form>
	<table border="1" cellpadding="0" cellspacing="0" id="table2">
		<thead>
			<tr>
				<th></th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>手机号</th>
				<th>学历</th>
				<th>操作</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody id="studentBodyId">

		</tbody>
	</table>
	<span id="pageId">
	 <a href='#' class="first">首页</a>
	 <a href='#' class="pre">上一页</a>&nbsp;
	 <a href='#' class="next">下一页</a>
	 <a href='#' class="last">尾页</a>
	</span>
</div>


