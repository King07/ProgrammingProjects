<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<!--<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">-->

	<title>Admin Signin</title>

	<!-- Bootstrap core CSS -->
	<link href="/../tourists-information-application/bootstrap/css/bootstrap.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="/../tourists-information-application/bootstrap/css/adminsignin.css" rel="stylesheet">
	<link href="/../tourists-information-application/bootstrap/css/main.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
</head>

<body>
@if(Session::has('flash_notice_success'))
<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
	<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_success') }}</p></div>
@endif

@if(Session::has('flash_notice_error'))
<div id="flash_notice_admin" class="alert alert-danger text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
	<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_error') }}</p></div>
@endif
<div class="container">

	<form class="form-signin" role="form" method="post">
		<h2 class="form-signin-heading">Please sign in</h2>
		<input type="text" class="form-control" placeholder="Employee Number" name="employeeNumber" required autofocus>
		<input type="password" class="form-control" placeholder="Password"name="password" required>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
