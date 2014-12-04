@extends('admin.layout')

@section('content')
<article class="module width_full">
	<header><h3>Create a New Attraction</h3></header>
	@if(Session::has('flash_notice_success'))
	<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_success') }}</p></div>
	@endif

	@if(Session::has('flash_notice_error'))
	<div id="flash_notice_admin" class="alert alert-danger text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_error') }}</p></div>
	@endif
	<form id="addAttraction" role="form" method="post" enctype="multipart/form-data" >
		<div class="module_content">
			<fieldset>
				<label>Attraction Name</label>
				<input type="text" name="attraction_name" >
			</fieldset>
			<fieldset>
				<label>Content</label>
				<textarea rows="12" name="attraction_content" ></textarea>
			</fieldset>
			<fieldset style="width:100%; "> <!-- to make two field float next to one another, adjust values accordingly -->
			<table class="table">
					<th><label>Categories</label></th>
					<tr><td>
							@foreach($categories as $category)
							<div class="checkbox" style="float: left">
								<label>
									<input type="checkbox"  value="{{$category->categoryName}}" name="category[]">
									{{$category->categoryName}}
							</div>
							@endforeach
					</td></tr><tr><td>
						<img id="image" class="img-thumbnail" src="#" alt="your image" /></td>
					<td>
						<span class="btn btn-primary btn-file glyphicon glyphicon-plus">
   						 	Photo <input type="file" name="file"  onchange="readURL(this);">
						</span>
					</td>


					</td></tr>
				</table>

			</fieldset>
			<div class="clear"></div>
		</div>
		<footer>
			<div class="submit_link">

				<button type="submit" class="btn btn-success btn-xs" id="submitAttraction" name="add_attraction">Add</button>
				<button type="button" onclick="clearInput()" class="btn btn-default btn-xs">Reset</button>

			</div>
		</footer>
	</form>
</article><!-- end of post new article -->
<script>
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function (e) {
				$('#image')
					.attr('src', e.target.result)
					.width(150)
					.height(200);
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
