@extends('layout.layout')

@section('content')
<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<p class="pull-right visible-xs">
			<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
		</p>
		<div class="">
			<h2>Lists of categories</h2>
			<p>Amsterdam is simply the best city when it comes to history, freedom and culture.
				But don’t take our word for it - check out the tourist buzz and attractions reviews.</p>

		</div>
		<div class="row">
			@foreach($reviews as $review)
				<div class="col-6 col-sm-6 col-lg-10"  style="border-bottom: 2px solid #ededed;margin-top: 20px;">
					<div class="col-6 col-sm-6 col-lg-3" >
						<img class="img-thumbnail" src="/tourists-information-application/app/images/{{$review->AttractionName}}.jpg" alt="Generic placeholder image">
					</div>

					<div class="col-6 col-sm-6 col-lg-9 link" >
						<h4 style="margin-top: -5px"><a href="attractions-details?AttractionName={{$review->AttractionName}}">{{$review->AttractionName}}</a></h4>
						<h4 style="margin-top: -5px"><small>{{$review->created_at}}</small></h4>

						<p><strong>{{$review->email}}</strong><br>
							{{$review->reviews}}<br>
							@for($i = 0; $i < $review->ratings; $i++)
								<img style="max-width: 20px;max-height: 20px" class="img-thumbnail " src="/tourists-information-application/app/images/star.png" alt="Generic placeholder image">
							@endfor
						</p>
					</div>
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