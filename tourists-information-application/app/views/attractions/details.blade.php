@extends('layout.layout')

@section('content')
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-12 col-sm-9">
		<p class="pull-right visible-xs">
			<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
		</p>
		<div class="">
			<h2>
				{{$attraction->attractionName}}

				@foreach ($attractionRatings as $attractionRating)
					@for($i = 0; $i < $attractionRating->AttractionAvg; $i++)
						<img style="max-width: 40px;max-height: 40px" class="img-thumbnail " src="/tourists-information-application/app/images/star.png" alt="Generic placeholder image">
					@endfor
				@endforeach

			</h2>

		</div>
		<div class="row">
			<div class="col-md-12">
				<img  class="img-thumbnail image-size img-responsive" src="/tourists-information-application/app/images/{{$attraction->attractionName}}.jpg" style="max-height: 500px;min-width: 800px"  alt="Generic placeholder image">
				<br><br><p>{{$attraction->description}}</p>

				<br><br><h4>Leave reply and reviews</h4>
				@if($amountReview > 0)
				<span style="color: red">You can not post twice on the same attraction</span>
				@elseif(Auth::check())

				<form id="myForm" role="form" method="post">
					<textarea class="form-control" name ="comments" id ="comments" rows="3"></textarea>
					<button type="submit" id="sub" class="btn btn-primary button">Post</button>
						 <span class="rating" >
							<input type="radio" class="rating-input"
								   id="rating-input-1-5" name="Rating" value="5">
							<label for="rating-input-1-5" class="rating-star"></label>
							<input type="radio" class="rating-input"
								   id="rating-input-1-4" name="Rating" value="4">
							<label for="rating-input-1-4" class="rating-star"></label>
							<input type="radio" class="rating-input"
								   id="rating-input-1-3" name="Rating" value="3">
							<label for="rating-input-1-3" class="rating-star"></label>
							<input type="radio" class="rating-input"
								   id="rating-input-1-2" name="Rating" value="2">
							<label for="rating-input-1-2" class="rating-star"></label>
							<input type="radio" class="rating-input"
								   id="rating-input-1-1" name="Rating" value="1">
							<label for="rating-input-1-1" class="rating-star"></label>
						</span>

				</form>
				@else
					You need to <a href="login" class="">log in</a> in order to post comments and reviews
				@endif
			</div>
			<div class="row" id="post">
				@foreach($reviews as $review)
					<div class="col-6 col-sm-6 col-lg-10"  style="border-bottom: 2px solid #ededed;margin-top: 20px;">


						<div class="col-6 col-sm-6 col-lg-9 link" >
							<h4 style="margin-top: -5px">{{$review->email}}</h4>
							<h4 style="margin-top: -5px"><small>{{$review->created_at}}</small></h4>
							{{$review->reviews}}<br>

								@for($i = 0; $i < $review->ratings; $i++)
									<img style="max-width: 20px;max-height: 20px" class="img-thumbnail " src="/tourists-information-application/app/images/star.png" alt="Generic placeholder image">
								@endfor

						</div>
					</div><!--/span-->
				@endforeach


			</div><!--/row-->

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

@section('js')
<script>
var myFormInput = $("#myForm :input");
var myForm =  $("#myForm");
var myFormCheckBox =  $('.rating input[type="radio"]');
	$("#sub").click( function() {
		$.post( myForm.attr("action"),
			myFormInput.serializeArray());
		var comments = $( "#comments" ).val();
		rating = $('input[name=Rating]:checked', '#myForm').val();



		var currentdate = new Date();
		var datetime =currentdate.getDate() + "-"
			+ (currentdate.getMonth()+1)  + "-"
			+ currentdate.getFullYear() + " "
			+ currentdate.getHours() + ":"
			+ currentdate.getMinutes() + ":"
			+ currentdate.getSeconds();

		$('<div class="col-6 col-sm-6 col-lg-10"  style="border-bottom: 2px solid #ededed;margin-top: 20px;">\
			<div class="col-6 col-sm-6 col-lg-9 link" >\
						<h4 style="margin-top: -5px">{{(Auth::check()) ? Auth::user()->username : null}}</h4>\
					<h4 style="margin-top: -5px"><small>'+datetime+'</small></h4>\
			'+ comments +' <br>\
				'+starRating(rating)+'</div></div>\
				').appendTo("#post");
		clearInput();
	});

myForm.submit( function() {
		return false;
	});
	function clearInput() {
		myFormInput.each( function() {
			$(this).val('');
			myFormCheckBox.prop('checked',false);
		});

		$("#myForm").hide();
	}


function starRating(number)
{
	var rating= '';

	for (var i=0;i<number;i++)
	{
		rating+='<img style="max-width: 20px;max-height: 20px" class="img-thumbnail " src="/tourists-information-application/app/images/star.png" alt="Generic placeholder image">';
	}
	return rating;
}


</script>

@stop