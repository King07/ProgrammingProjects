@extends('admin.layout')

@section('content')
<article class="module width_3_quarter">
	<header><h3 class="tabs_involved">Attraction list</h3></header>
	@if(Session::has('flash_notice_success'))
	<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_success') }}</p></div>
	@endif

	@if(Session::has('flash_notice_error'))
	<div id="flash_notice_admin" class="alert alert-danger text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_error') }}</p></div>
	@endif
	<div id="result"></div>
	<div class="tab_container">
		<div id="tab1" class="tab_content">
			<table id="myTable" class="tablesorter" cellspacing="0">
				<thead>
				<tr>
					<th>Attraction Name</th>

					<th>Updated On</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody>
				@foreach($attractions as $attraction)
				<tr>
					<td>{{$attraction->attractionName}}</td>

					<td>{{$attraction->updated_at}}</td>
					<td>
						<a href="modify-attraction-edit?attractionName={{$attraction->attractionName}}">
							<button type="button" class="btn btn-info btn-xs">
								<span class="glyphicon glyphicon-edit"></span>
							</button>

						</a>
					</td>
					<td>
						<form class="form-horizontal" id="deleteAttraction" role="form" method="post">
							<input type="hidden" class="form-control" id="inputEmail3" placeholder="Email" name='attractionName' value="{{$attraction->attractionName}}">
							<button type="submit" onclick="" id="subDeleteAttraction" class="btn btn-warning btn-xs">
								<span class="glyphicon glyphicon-trash"></span>
							</button>

						</form>

					</td>
				</tr>
				@endforeach
				</tbody>
			</table>
		</div><!-- end of #tab1 -->


	</div><!-- end of .tab_container -->

</article><!-- end of content manager article -->

@stop