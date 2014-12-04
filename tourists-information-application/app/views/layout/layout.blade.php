
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
   <!-- <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">-->

    <title>Tourist Information</title>

    <!-- Bootstrap core CSS -->
    <link href="/../tourists-information-application/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
	  <link href="/../tourists-information-application/bootstrap/css/main.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home">Tourist Information</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class=""><a href="home">Home</a></li>
            <li><a href="attractions">Things to do</a></li>
            <li><a href="categories">Categories</a></li>
            <li><a href="reviews">Reviews</a></li>

          </ul>
			@if(Auth::check())
			<div class="navbar-collapse navbar-right navbar-btn collapse">

				<button type="button" class="btn btn-default ">
					<span class="glyphicon glyphicon-user"></span> {{Auth::user()->username}}
				</button>

				<button type="button" class="btn btn-default ">
					<a  href="logout"><i class="glyphicon glyphicon-off"></i></a>
				</button>

			</div><!--/.form -->

			@else
			<div class="navbar-collapse navbar-btn navbar-right collapse">

				<a  href="login" class="btn btn-success" role="button">Sign in</a>
				<a href="register" class="btn btn-success " role="button">Register</a>


			</div><!--/.form -->
			@endif
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->

    <div class="container">
		@yield('content')


      <footer>
        <p>&copy; Tourist Information 2013</p>
      </footer>

    </div><!--/.container-->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="/../tourists-information-application/bootstrap/js/bootstrap.min.js"></script>

	@yield('js')
   <!-- <script src="offcanvas.js"></script>-->
  </body>
</html>
