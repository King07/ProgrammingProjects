@extends('layout.layout')

@section('content')
<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<p class="pull-right visible-xs">
			<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
		</p>
		<div class="">
			<h2>Lists of categories</h2>

		</div>
		<div class="row">
			@foreach($categories as $category)
				<div class="col-6 col-sm-6 col-lg-4">
					<img class="img-circle" src="/tourists-information-application/app/images/{{$category->categoryName}}.jpg" style="max-height: 200px;max-width: 200px" alt="Generic placeholder image">
					<h4 style="margin-left: 70px;">{{$category->categoryName}}</h4>
					<p><a style="margin-left: 50px;" class="btn btn-default" href="categories-details?categoryId={{$category->categoryId}}" role="button">See more &raquo;</a></p>
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