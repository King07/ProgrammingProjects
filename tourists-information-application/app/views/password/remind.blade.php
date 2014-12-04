@extends('layout.layout')


@section('content')


@if(Session::has('success'))
<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
	<p style="margin-right: auto;margin-left: auto">{{ Session::get('success') }}</p></div>
@elseif (Session::has('error'))
<div id="flash_notice_admin" class="alert alert-danger text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
	<p style="margin-right: auto;margin-left: auto">{{ Session::get('error') }}</p></div>
@endif

	<form class="form-signin" role="form" method="post" autocomplete="off">
		<h2 class="form-signin-heading">Please Enter your email</h2>
		<input type="text" class="form-control" name="email" placeholder="Email address" required autofocus>
		<button class="btn btn-lg btn-primary btn-block"  name="signin"  type="submit">Submit</button>
	</form>



@stop