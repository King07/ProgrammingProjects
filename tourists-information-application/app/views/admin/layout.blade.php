<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>Admin Panel</title>

	<link rel="stylesheet" href="/../tourists-information-application/bootstrap/css/layout.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="/../tourists-information-application/bootstrap/css/bootstrap.min.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="/../tourists-information-application/bootstrap/css/main.css" type="text/css" media="screen" />
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
</head>


<body style="background-color: #edeef2">

<header id="header">
	<hgroup>
		<h1 class="site_title"><a href="dashboard">Tourist Information Admin</a></h1>
		<h2 class="section_title">Dashboard</h2><div class="btn_view_site"><a href="home" target="_blank">View Site</a></div>
	</hgroup>

</header> <!-- end of header bar -->

<section id="secondary_bar">
	<div class="user">
		<p><?php if(isset($employee))echo $employee->employeeFirstName.' '.$employee->employeeLastName?></p>
		<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
	</div>
	@yield('value')
</section><!-- end of secondary bar -->

<aside id="sidebar" class="column">

	<h3>Content</h3>
	<ul class="toggle">
		<li class="icn_new_article"><a href="add-attraction">New Attraction</a></li>
		<li class="icn_edit_article"><a href="modify-attraction">Edit Attraction</a></li>
		<li class="icn_categories"><a href="modify-categories">Categories</a></li>
		<li class="icn_categories"><a href="modify-reviews">Reviews</a></li>
	</ul>
	<h3>Users</h3>
	<ul class="toggle">
		<li class="icn_view_users"><a href="view-users">View Users</a></li>
	</ul>

	<h3>Admin</h3>
	<ul class="toggle">
		<li class="icn_add_user"><a href="add-employee">Add New Employees</a></li>
		<li class="icn_profile"><a href="user-profile">Your Profile</a></li><br>
		<li>
			<form role="form" method="post">

				<button type="submit" name="signout" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-off"></span> Sign out
				</button>
			</form>

		</li>

	</ul>

	<footer>
		<hr />
		<p><strong>Copyright &copy; 2014 Tourist App Admin</strong></p>
		<p>Theme by <span style="color: #1f1f1f">King World</span></p>
	</footer>
</aside><!-- end of sidebar -->

<section id="main" class="column">
	@yield('content')


	<div class="spacer">

	</div>
</section>
<!--<script src="/../tourists-information-application/bootstrap/js/jquery.min.js" type="text/javascript"></script>-->


<script src="/../tourists-information-application/bootstrap/js/bootstrap.js" type="text/javascript"></script>

@yield('js')
</body>

</html>