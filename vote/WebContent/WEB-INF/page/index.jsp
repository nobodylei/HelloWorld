<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--略简陋--> 
<head>
<title>群投票</title>
<link rel="stylesheet"
	href="${basePath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${basePath}/bootstrap/css/bootstrap-datepicker.min.css" />
<link rel="stylesheet"
 href="${basePath}/static/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${basePath}/bootstrap/css/bootstrap-table.min.css">
<link rel="stylesheet" href="${basePath}/static/css/main.css"> 

<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
<script src="${basePath}/jquery/jquery.validate.min.js"></script>
<script src="${basePath}/jquery/jquery.form.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap-datepicker.min.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${basePath}/js/vote.js"></script>
<style type="text/css">
#rightDiv {
	background-color: #0ff;
	height: 500px;
	width: 600px;
	position: absolute;
	top: 80px;
	left: 500px;
}

#leftDiv {
	background-color: #2af;
	height: 500px;
	width: 200px;
	position: absolute;
	left: 200px;
	top: 80px;
}
</style>
</head>
<body style="font-size: 30px;">
	<div id="leftDiv">
		<div id="start">
			<input type="button" value="发起投票" id="btn-start" />
		</div>
		<hr/>
		<div id="vote">
			<p style="font: 10px;">暂无投票</p>
			<p style="font: 5px; text-align: center">已经没有更多</p>
		</div>
	</div>
	<div id="rightDiv">
		<div id="rightV">
			<p style="text-align: center;">暂无投票</p>
			<p style="font: 5px; text-align: center;">快来发布投票吧</p>
		</div>
	</div>
	<!-- modal dialog -->
	<div class="modal fade" id="modal-dialog" tabindex="-1" role="dialog"
		aria-labelledby="modalTitleLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalTitleLabel">发起新投票</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary ok ">确定</button>
					<button type="button" class="btn btn-default cancel"
						data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
          
          
          
          
          
