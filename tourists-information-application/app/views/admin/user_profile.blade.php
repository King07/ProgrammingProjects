@extends('admin.layout')

@section('content')
<article class="module width_3_quarter">
	<header><h3 class="tabs_involved">User Profile</h3></header>
	<h2 style="margin-left: 15px">View your Profile below :</h2><br>
	<div><button style="height: 100px;width: 100px;margin-left: 15px;background-color: #1d1d1d" type="button" class="btn btn-default btn-lg" disabled="disabled">
			<span style="color: #fff;" class="glyphicon glyphicon-user"></span>
		</button>
	<h3 style="margin-left: 15px"><strong>Name: </strong> <i>{{$employee->employeeFirstName}} {{$employee->employeeLastName}}</i></h3>
		<h3 style="margin-left: 15px"><small>Position: <i>{{$employee->function}}</i></small></h3>
		<table style="width: 300px" class="table table-hover">
			<tr>
				<td><strong>First Name :</strong></td><td><small>{{$employee->employeeFirstName}}</small></td>
			</tr><tr>
				<td><strong>Last Name :</strong></td><td><small>{{$employee->employeeLastName}}</small></td>
			</tr><tr>
				<td><strong>Function :</strong></td><td><small>{{$employee->function}}</small></td>
			</tr><tr>
				<td><strong>Start Date :</strong></td><td><small>{{$employee->startDate}}</small></td>
			</tr><tr>
				<td><strong>Salary :</strong></td><td><small>{{$employee->salary}}</small></td>
			</tr>
		</table>
	</div>
</article><!-- end of content manager article -->

@stop