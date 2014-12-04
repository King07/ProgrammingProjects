@extends('layout.layout')


@section('content')
@if(Session::has('flash_notice'))
<div id="flash_notice" class="alert alert-success"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
	<p>{{ Session::get('flash_notice') }}</p></div>
@endif

	<form class="form-signin" role="form" method="post" autocomplete="off">
		<h2 class="form-signin-heading">Please sign in</h2>
		<input type="text" class="form-control" name="email" placeholder="Email address" required autofocus>
		<input type="password" class="form-control"  name="password"  placeholder="Password" required>
		<span><a href="password/remind"> Forgot your password</a></span><br><br>
		<button class="btn btn-lg btn-primary btn-block"  name="signin"  type="submit">Sign in</button>
	</form>



@stop