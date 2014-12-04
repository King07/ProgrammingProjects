@extends('admin.layout')

@section('content')


<div id ="cat_add" >
	<!-- Button trigger modal -->
	<button  type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">
		<span  class="glyphicon glyphicon-plus-sign"></span> Add
	</button>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Add Category</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" method="post">
					<div class="form-group">
						<label for="inputEmail3" class="col-xs-4 control-label">Category Name</label>
						<div class="col-xs-4">
							<input type="text" class="form-control" id="inputEmail3" placeholder="Category Name" name="category_name">
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Confirm</button>
					</div>
				</form>
			</div>

		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<article class="module width_3_quarter">
	<header><h3 class="tabs_involved">Categories list</h3></header>
	@if(Session::has('flash_notice_success'))
	<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_success') }}</p></div>
	@endif

	@if(Session::has('flash_notice_error'))
	<div id="flash_notice_admin" class="alert alert-danger text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_error') }}</p></div>
	@endif
	<div class="tab_container">
		<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0">
				<thead>
				<tr>
					<th>Category Name</th>
					<th>Updated On</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody>
				@foreach($categories as $category)
					<tr>
						<td>{{$category->categoryName}}</td>
						<td>{{$category->updated_at}}</td>
						<td>

								<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#{{$category->categoryName}}">
									<span class="glyphicon glyphicon-edit"></span>
								</button>



							<!-- Modal -->
							<div class="modal fade" id="{{$category->categoryName}}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">Edit Category</h4>
										</div>
										<div class="modal-body">
											<form class="form-horizontal" role="form" method="post">
												<div class="form-group">
													<label for="inputEmail3" class="col-xs-4 control-label">Category Name</label>
													<div class="col-xs-4">
														<input type="text" class="form-control" id="inputEmail3" placeholder="Category Name" value="{{$category->categoryName}}" name="edit_category_name">
														<input type="hidden" class="form-control" id="inputEmail3" placeholder="Category Name" value="{{$category->categoryId}}" name="edit_category_id">
													</div>

												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
													<button type="submit" class="btn btn-primary">Confirm</button>
												</div>
											</form>
										</div>

									</div><!-- /.modal-content -->
								</div><!-- /.modal-dialog -->
							</div><!-- /.modal -->
						</td>
						<td>
							<form class="form-horizontal" id="deleteAttraction" role="form" method="post">
								<input type="hidden" class="form-control" id="inputEmail3" placeholder="category_id" name='category_id' value="{{$category->categoryId}}">
								<button type="submit" onclick="" id="subDeleteAttraction" class="btn btn-warning btn-xs">
									<span class="glyphicon glyphicon-trash"></span>
								</button>

							</form>

						</td>					</tr>
				@endforeach

				</tbody>
			</table>
		</div><!-- end of #tab1 -->


	</div><!-- end of .tab_container -->

</article><!-- end of content manager article -->

@stop