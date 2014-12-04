@extends('admin.layout')

@section('content')
<article class="module width_full">
	@if(Session::has('flash_notice_success'))
	<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_success') }}</p></div>
	@endif

	@if(Session::has('flash_notice_error'))
	<div id="flash_notice_admin" class="alert alert-danger text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_error') }}</p></div>
	@endif
	<header><h3>Create a New Attraction</h3></header>

	<form id="addAttraction" role="form" method="post" enctype="multipart/form-data" >
		<div class="module_content">
			<fieldset>
				<label>Attraction Name</label>
				<input type="text" name="attraction_name" value="{{$attraction->attractionName}}" >
				<input type="hidden" name="hidden" value="{{$attraction->attractionName}}" >
			</fieldset>
			<fieldset>
				<label>Content</label>
				<textarea rows="12" name="attraction_content"  >{{$attraction->description}}</textarea>
			</fieldset>
			<fieldset style="width:100%; "> <!-- to make two field float next to one another, adjust values accordingly -->
			<table class="table">
					<th><label>Categories</label></th>
					<tr><td>
							@foreach($categories as $category)
							<div class="checkbox" style="float: left">
								<label>
									<input type="checkbox"  value="{{$category->categoryName}}" name="category[] " <?php if(BaseController::in_array_r($category->categoryId,$attractionCategoryIds)) echo 'checked'; ?>>
									{{$category->categoryName}}
							</div>
							@endforeach
					</td></tr><tr><td>
					<img  id="previousImg"class="img-thumbnail image-size img-responsive" src="/tourists-information-application/app/images/{{$attraction->attractionName}}.jpg "  alt="NO IMAGE" style="max-height: 200px;min-width: 250px"  alt="Generic placeholder image">
						<img id="image" class="img-thumbnail" src="#"  alt="your image" />
					</td>
					<td>
						<span class="btn btn-primary btn-file glyphicon glyphicon-plus">
   						 	Photo <input type="file" name="file" onchange="readURL(this);">
						</span>
					</td></tr>
				</table>

			</fieldset>
			<div class="clear"></div>
		</div>
		<footer>
			<div class="submit_link">

				<button type="submit" class="btn btn-success btn-xs" id="submitAttraction" name="add_attraction">Edit</button>
				<button type="button" onclick="clearInput()" class="btn btn-default btn-xs">Reset</button>

			</div>
		</footer>
	</form>
</article><!-- end of post new article -->
<script>
	function readURL(input) {
		if (input.files && input.files[0]) {
			$("#previousImg").hide();
			var reader = new FileReader();

			reader.onload = function (e) {
				$('#image')
					.attr('src', e.target.result)
					.height(200)
					.width(250);
			};

			reader.readAsDataURL(input.files[0]);
		}
	}
	function clearInput() {
		$("#addAttraction :input").each( function() {
			$(this).val('');
			$('input:checkbox').removeAttr('checked');
		});
	}
</script>

@stop
