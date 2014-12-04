@extends('admin.layout')

@section('content')
<article class="module width_3_quarter">
	@if(Session::has('flash_notice_success'))
	<div id="flash_notice_admin" class="alert alert-success text-center"><button type="button" onclick="(this).parent().remove();" class="close" data-dismiss="alert">&times;</button>
		<p style="margin-right: auto;margin-left: auto">{{ Session::get('flash_notice_success') }}</p></div>
	@endif
	<header><h3 class="tabs_involved">Users list</h3></header>

	<div class="tab_container">
		<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0">
				<thead>
				<tr>
					<th>Username</th>
					<th>Status</th>
					<th>Created On</th>
					<th>Action</th>
				</tr>
				</thead>
				<tbody>
				@foreach($users as $user)
				<tr>
					<td>{{$user->username}}</td>
					<td>@if($user->block == 0)
						<span  style="color: greenyellow" class="glyphicon glyphicon-ok-sign"></span>
						@else
						<span style="color: red"class="glyphicon glyphicon-ban-circle"></span>
						@endif
					</td>
					<td>{{$user->created_at}}</td>
					<td><button type="button" class="btn btn-info btn-xs " data-toggle="modal" data-target="#{{$user->usersId}}">
							<span class="glyphicon glyphicon-edit"></span>
						</button></td>
					<!-- Modal -->
					<div class="modal fade" id="{{$user->usersId}}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">{{$user->username}}</h4>
								</div>
								<div class="modal-body">
									<form class="form-horizontal" role="form" method="post">
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">UserName</label>
											<div class="col-sm-10">
												<input type="email" class="form-control" id="inputEmail3" placeholder="Email" value="{{$user->username}}">
												<input type="hidden" class="form-control" id="inputEmail3" placeholder="Email" value="{{$user->usersId}}" name="hidden">
											</div>
										</div>
										<br>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<div class="checkbox">
													<label>
														<input type="checkbox" name="block" <?php if($user->username == 1)  echo 'checked'?>>Block
													</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit" class="btn btn-default">Save</button>
											</div>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal-dialog -->
					</div><!-- /.modal -->
				</tr>
				@endforeach
				</tbody>
			</table>
		</div><!-- end of #tab1 -->


	</div><!-- end of .tab_container -->

</article><!-- end of content manager article -->

@stop