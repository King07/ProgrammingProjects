@extends('layout.layout')


@section('content')


	<form class="form-signin" role="form" method="post" autocomplete="off">
		<h2 class="form-signin-heading">Please register</h2>
		<input type="text" class="form-control" name="email" placeholder="Email address" required autofocus>
		<input type="password" class="form-control"  name="password"  placeholder="Password" required>
		<button class="btn btn-lg btn-primary btn-block"  name="register"  type="submit">Register</button>
	</form>



@stop