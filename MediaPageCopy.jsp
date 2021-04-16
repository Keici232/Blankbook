<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Beans.userBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">




<title>Media center</title>
</head>
<body>

	<div class="container" style="text-align: center">
		<h1>Welcome to Social Media</h1>
		<b>${user.fullname} </b>

<div style="margin: 3em">
<form action="" method="post">
		<table border="1" class="table table-striped table-bordered table-dark" >
		
		
	
			<thead>
			
				<tr class="thead-blue">
				
					<th >Post</th>
					<th>Tag</th>
					<th>Action</th>
				</tr>
			</thead>
			
			
			
			<c:forEach items="${postList}" var="Post">
				<tr>
						<tr>
							
							<td  class="table-secondary">${Post.post}</td>
							<td  class="table-secondary">${Post.tag}</td>
							<td class="table-secondary">
				
							
							<%-- <a href= "${pageContext.request.contextPath }/PostController?action=DELETE&addPost_id=${Post.addPost_id}"><span style = "color:dark">DELETE</span></a>  --%>
							<button class="btn btn-dark " type = "submit" formaction= "PostController?action=DELETE&addPost_id=${Post.addPost_id}">
							<span style = "color:dark">DELETE</span></button>
							 
							</td>
								
						</tr>
						
			 </c:forEach>
			 
			 
		</table>
	</form>
		</div>
		
		

		<form action="<%=request.getContextPath()%>/Logout" method="get">
		
		<button type = "submit" formaction="AddPost.jsp" class="btn btn-dark " style="margin: 2em">Add Post</button>

			<input class="btn btn-dark " type="submit" value="Logout">
		</form>

	</div>



</body>
</html>