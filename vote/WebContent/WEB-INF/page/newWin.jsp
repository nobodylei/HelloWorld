<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<form  method="post"> 
	<table align="center">
	<tr>
	<td>投票主题</td>
	<td><textarea id="title"  name="name" cols="22" rows="2"></textarea></td>
	</tr>
	
	<tr>
	<td>投票选项</td>
	<td>
		<table id="options">
		<tr><td><input  class="option" /></td><td></td></tr>
		<tr><td><input  class="option" /></td><td></td></tr>
		<tr><td><input  class="option" /></td><td><a href="#" class="del">x</a></td></tr>
		</table>
		<table>
		<tr><td><a href="#" id="addOption">+添加选项</a></td></tr>
		</table>
	</td>
	</tr>
	
	<tr>
	<td>选择模式</td>
	<td><input type="radio"  name="type" id="one" value="1"/>单选 <input type="radio" name="type" id="odd" value="0"/>多选</td>
	</tr>
	
	<tr>
	<td>截止日期</td>
<td><input type="text"  id="time" value="2017-08-01 11:00:00"/></td>
	</tr>
	
	<tr>
	<td>提醒时间</td>
	<td>
		<select id="alert">
			<option value="1">提前10分钟</option>
			<option value="2">提前20分钟</option>
			<option value="3">提前30分钟</option>
			<option value="4">不提醒</option>	
		</select>
	</td>
	</tr>
	
	<tr>
	<td>投票隐私</td>
	<td><input type="radio" name="isHidden" id="public" value="0"/>公开<br/>
  <input type="radio" name="isHidden" id="private" value="1"/>匿名</td>
	</tr>
	</table>
</form>
<c:url var="url" value="/js/newWin.js"></c:url>
<script type="text/javascript" src="${url}"></script>

