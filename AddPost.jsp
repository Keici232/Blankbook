<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="ConnectionDB.postAddDAO"%>
<%@ page import="Controller.PostController"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
	<%
	postAddDAO.isRunning = true;
	%>


	<form action="<%=request.getContextPath()%>/PostController"
		method="get">

		<div class="form-group" style="margin: 3em">
			<input class="form-control" type="text" name="post"
				placeholder="Enter post" />
		</div>
		<br>
		<div class="form-group" style="margin: 3em">
			<input class="form-control" type="text" name="tag"
				placeholder="Enter tag" />
		</div>

		<div style="margin: 3em">

			<button class="btn btn-primary" type="submit">Save Post</button>
		</div>

	</form>





</body>
</html>