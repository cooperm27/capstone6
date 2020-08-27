<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Auth Demo</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<%@include file="partials/header.jsp" %>
	<h1>My Tasks</h1>
	
	<div class = "container">
		<table class="table">
			<thead>
				<tr>
					<th>Description</th><th>Due Date</th><th>Completed</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tasks" items="${tasks}">
				<tr>
					<td>${tasks.description}</td>
					<td>${tasks.dueDate}</td>
					<td> ${true == tasks.complete ? 'Yes' : 'No' }</td>
					<td><a class="btn btn-secondary" href="/completeTask?id=${tasks.id}">Mark Complete</a></td>
					<td><a class="btn btn-secondary" href="/deleteTask?id=${tasks.id}">Remove Task</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
		<form action="/add-task">
		<table class="table">
			<tr>
				<th>Description</th>
				<td><input type="text" name="description" autofocus/></td>
				<th>Date</th>
				<td><input type="Date" name="Date" /></td>
				</tr>
		</table>
		<button type="submit" class="btn btn-primary">Add a Task</button>
		</form>
	</p>
</body>
</html>