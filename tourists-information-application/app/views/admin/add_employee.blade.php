@extends('admin.layout')

@section('content')
<article class="module width_3_quarter">
	@if(Session::has('flash_notice_success'))
	<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_success') }}</p></div>
	@endif

	@if(Session::has('flash_notice_error'))
	<div id="flash_notice_admin" class="alert alert-danger text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_error') }}</p></div>
	@endif
	<header><h3 class="tabs_involved">Add Employee</h3></header>
	<h2 style="margin-left: 15px">Add a new employee below :</h2><br>
	<form class="form-horizontal" role="form" method="post">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Number</label>
			<div class="col-xs-4">
				<input type="text" name="number" class="form-control" id="inputEmail3" placeholder="Number">
			</div>
		</div><div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">First Name</label>
			<div class="col-xs-4">
				<input type="text" name="f_name" class="form-control" id="inputEmail3" placeholder="First Name">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Last Name</label>
			<div class="col-xs-4">
				<input type="text" name="l_name" class="form-control" id="inputPassword3" placeholder="Last Name">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Function</label>
			<div class="col-xs-4">
				<input type="text" name="function" class="form-control" id="inputPassword3" placeholder="Function">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			<div class="col-xs-4">
				<input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Start Date</label>
			<div class="col-xs-4">
				<input type="date" name="date" class="form-control" id="inputPassword3" placeholder="Start Date">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Salary</label>
			<div class="col-xs-4">
				<input type="text" name="salary" class="form-control" id="inputPassword3" placeholder="Salary">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-xs-4">
				<button type="submit" class="btn btn-default">Add Employee</button>
			</div>
		</div>
	</form>
</article><!-- end of content manager article -->

@stop