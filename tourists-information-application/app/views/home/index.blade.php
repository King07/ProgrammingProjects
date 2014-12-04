@extends('layout.layout')

@section('content')
<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<p class="pull-right visible-xs">
			<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
		</p>
		<!-- check for flash notification message -->
		@if(Session::has('flash_notice'))
		<div id="flash_notice" class="alert alert-success"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
			<p>{{ Session::get('flash_notice') }}</p></div>
		@endif
		<div class="jumbotron home-pic">

		</div>

		<div class="row">
			<div class="col-md-12">
				<h2>Welcome to Amsterdam</h2>
				<p>From its earliest days, Amsterdam has been a bustling hub of commerce that welcomed other cultures with open arms.
					Learn more about this lovely canal-side city, including the rich history and development of its tolerant society.
					Or jump straight to the modern day and find out about the city’s architecture and its colourful neighbourhoods.
					If you’re feeling ambitious, you might even pick up a few words of Dutch! </p>

			</div><!--/span-->

	</div><!--/span-->




</div><!--/row-->

	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
		<div class="list-group">
			<a href="#" class="list-group-item active disabled">Top Attractions</a>
			@foreach($topAttractions as $topAttraction)
				<a href="attractions-details?AttractionName={{$topAttraction->AttractionName}}" class="list-group-item">{{$topAttraction->AttractionName}}</a>
			@endforeach

		</div>
	</div><!--/span-->
</div><!--/row-->

<hr>

@stop