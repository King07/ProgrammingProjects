@extends('admin.layout')

@section('content')
<article class="module width_full">
	@if(Session::has('flash_notice_success'))
	<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_success') }}</p></div>
	@endif
	<header><h3 class="tabs_involved">Review list</h3>

		<div class="submit_link">
			<form class="form-horizontal" id="searchName" role="form" method="post">
			<select name="attractionName">
				<option></option>
				@foreach($attractions as $attraction)
					<option>{{$attraction->attractionName}}</option>
				@endforeach
				</form>
			</select>

		</div>
	</header>

	<div class="tab_container">
		<div id="tab1" class="tab_content">

			<table class="tablesorter" cellspacing="0">
				<thead>
				<tr>
					<th>Username</th>
					<th>Reviews</th>
					<th>Updated On</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody>
				@foreach($reviews as $review)
					<tr>
						<td>{{$review->email}}</td>
						<td><article class=" width_quarter">

								<div class="message_list">
									<div class="module_content">
										<div class="message"><p>{{$review->reviews}}</p>

									</div>
								</div>

							</article><!-- end of messages article -->
						</td>
						<td>{{$review->updated_at}}</td>
						<td>
							<a href="view-users">
								<button type="button" class="btn btn-info btn-xs">
									<span class="glyphicon glyphicon-user"></span>
								</button>
							</a>


						</td>
						<td>
							<form class="form-horizontal" id="deleteAttraction" role="form" method="post">
								<input type="hidden" class="form-control" id="inputEmail3" placeholder="Email" name='reviewId' value="{{$review->reviewsId}}">
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

</article><!-- end of post new article -->
<script>

	$( "select" ).change(function() {
		$( ".tablesorter" ).hide();
		$.post( $("#searchName").attr("action"),
			$("#searchName :input").serializeArray(),
			function(info){

				$("#tab1").html(info);
	});
});
		$("#searchName").submit( function() {
			event.preventDefault();
		});

</script>

@stop