<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
	
<title>Login</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" 
type="text/css">

<link rel="stylesheet" href="css/style.css" >


</head>
<body>

	<section class="container-fluid bg">

		<section class="row justify-content-center">

			<section class="col-12 col-sm-6 col-md-3">



				

				<form action="<%=request.getContextPath()%>/Login" method="post" class="form-container">
					<h1>Please sign in</h1>
					

					<div class="mb-3">

						<label for="fullname" class="form-label">Fullname</label> 
							<input class="form-control" type="text" name="fullname"
							required="required">

					</div>

					<div class="mb-3">

						<label for="password" class="form-label">Password</label> 
						<input class="form-control" type="password" name="password"
							required="required">
						<br> ${message}
					</div>

					 

					<button type="submit" class="btn btn-primary btn-block">Submit</button>



				</form>



			</section>

		</section>

	</section>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js">


</script>

</body>
</html>