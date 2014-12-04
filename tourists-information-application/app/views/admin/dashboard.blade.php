@extends('admin.layout')

@section('content')
@if(Session::has('flash_notice_success'))
<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
	<p>{{ Session::get('flash_notice_success') }}</p></div>
@endif
<article class="module width_full">
	<header><h3>Dashboard</h3></header>
	<div class="module_content">

		<h3>Admin Panel</h3>
		<p> Welcome to the administration panel for the Tourist Information Application.
			Here is the content management system for the application, where you as the administrator can do the following: </p>

		<ul>
			<li>Add, remove and edit attractions. </li>
			<li>Add, remove and edit categories.</li>
			<li>Remove inappropriate reviews . </li>
			<li>Block users for misconduct.</li>
		</ul>
	</div>
</article>

@stop