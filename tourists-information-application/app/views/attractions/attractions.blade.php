@extends('layout.layout')

@section('content')
<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<p class="pull-right visible-xs">
			<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
		</p>
		<div class="">
			<h2>Lists of attarctions</h2>
			<p>What should you see when you visit Amsterdam? The city has attractions to entertain visitors of all ages and the Tourist Information APP
				will help you enjoy amsterdam and all its beauties. Have a look at the list below and get inspired for your next trip.</p>

		</div>
		<div class="row">
			@foreach($attractions as $attraction)
				<div class="col-6 col-sm-6 col-lg-4" style="height: 400px;margin-top: 20px">

					<img  class="img-thumbnail image-size img-responsive" src="/tourists-information-application/app/images/{{$attraction->attractionName}}.jpg" style="max-height: 200px;min-width: 250px"  alt="Generic placeholder image"><!--holder.js/140x140-->
					<h4>{{$attraction->attractionName}}</h4>
					<p>{{substr($attraction->description,0,100)}}</p>
					<p><a class="btn btn-default" href="attractions-details?AttractionName={{$attraction->attractionName}}" role="button">View details &raquo;</a></p>
				</div><!--/span-->
			@endforeach
		</div><!--/row-->
	</div><!--/span-->

	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
		<div class="list-group">
			<a  class="list-group-item active disabled">Top Attractions</a>
			@foreach($topAttractions as $topAttraction)
			<a href="attractions-details?AttractionName={{$topAttraction->AttractionName}}" class="list-group-item">{{$topAttraction->AttractionName}}</a>
			@endforeach
		</div>
	</div><!--/span-->
</div><!--/row-->

<hr>


@stop