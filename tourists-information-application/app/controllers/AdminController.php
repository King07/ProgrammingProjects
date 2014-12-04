<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/17/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */

class AdminController extends BaseController
{
	/** Show the admin page*/
	public function getAdmin()
	{
		return  View::make("admin.login",array());
	}
	/** check if employee has admin right then Show the dashboard page with employee info*/
	public function getDashboard()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			return  View::make("admin.dashboard",array('employee' => $employee));
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the add_attraction page with employee  and categories info*/
	public function getAddAttraction()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			$categories = Category::getAllCategories();
			return  View::make("admin.add_attraction",array('employee' => $employee,'categories'=>$categories));
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the add_attraction page with employee  and categories info*/
	public function getModifyAttraction()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			$attractions = Attraction::getAllAttractions();
			return  View::make("admin.modify_attraction",array('employee' => $employee,'attractions'=>$attractions));
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the modify_categories page with employee  and categories info*/
	public function getModifyCategories()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			$categories = Category::getAllCategories();
			return  View::make("admin.modify_categories",array('employee' => $employee,'categories'=>$categories));
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the modify_reviews page with employee, reviews  and attractions info*/
	public function getModifyReviews()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			$reviews = Review::getAllReviews();
			$attractions = Attraction::getAllAttractions();
			return  View::make("admin.modify_reviews",array('employee' => $employee,'reviews' => $reviews,'attractions'=>$attractions));
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the view_users page with employee  and users info*/
	public function getUsers()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			$users = User::getAllUsers();
			return  View::make("admin.view_users",array('employee' => $employee,'users' => $users));
		}
		return Redirect::route('admin')->with('flash_notice_error', ' <strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the add_employee page with employee  info*/
	public function AddEmployee()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			return  View::make("admin.add_employee",array('employee' => $employee));
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the add_employee page with employee, attractions and categories  info*/
	public function EditAttraction()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			$attractionName = Input::get('attractionName');
			$attraction = Attraction::getAttractionByAttractionName($attractionName);
			$categories = Category::getAllCategories();
			$attractionCategoryIds = AttractionsCategory::getCategoryIdByAttractionNames($attractionName);
			return  View::make("admin.modify-attraction-edit",array('employee' => $employee,'attraction' => $attraction,'categories' => $categories,'attractionCategoryIds' => $attractionCategoryIds));
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the add_employee page with employee, attractions and categories  info*/
	public function ViewUser()
	{
		if (Session::has('number'))
		{
			$employeeNumber = Session::get('number');
			$employee = Employee::getEmployee($employeeNumber);
			return  View::make("admin.user_profile",array('employee' => $employee));
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> You need to login first');
	}

	/** check if employee has admin right then Show the dashboard page with employee  and users info*/
	public function postAdminLogin()
	{
		if(Input::has('employeeNumber') && Input::has('password'))
		{
			$employee = array(
				'employeeNumber' => Input::get('employeeNumber'),
				'password' => Input::get('password')
			);

			if (Employee::attempt($employee)) {
				Session::put('number',$employee['employeeNumber']);
				return Redirect::route('dashboard')
					->with('flash_notice_success', '<strong>Well done! </strong> You are successfully logged in.');
			}else{
				return Redirect::route('admin')->with('flash_notice_error', ' <strong>Warming! </strong> Password or email is wrong');
			}
		}
		return Redirect::route('admin')->with('flash_notice_error', '<strong>Warming! </strong> Password or email is wrong');
	}

	/** sign out of the admin*/
	public function postLogout()
	{
		if(isset($_POST['signout']))
		{
			Session::flush();

			return Redirect::route('admin')->with('flash_notice_success', '<strong>Well done! </strong> You have signed out of the admin');
		}
	}
	/** adding new attraction*/
	public function postAddAttraction()
	{

			$attractionName = Input::get('attraction_name');
			$attractionContent = Input::get('attraction_content');
			$category = null;



		$newAttraction = Attraction::addNewAttraction($attractionName,$attractionContent);
		if($newAttraction)
		{
			if(isset($_POST['category']))
			{
				$category = $_POST['category'];
				foreach($category as $categoryName)
				{
					$categoryId = Category::findCategoryId($categoryName);
					AttractionsCategory::addNewAttractionCategory($categoryId,$attractionName);
				}
			}
			$temp = explode(".", $_FILES["file"]["name"]);
			$extension = end($temp);
			$fileName = $attractionName.'.'.$extension;
			move_uploaded_file($_FILES["file"]["tmp_name"],SITE_ROOT."/images/".$fileName);

			return Redirect::route('add-attraction')->with('flash_notice_success', '<strong>Well done! </strong> You successfully added a new attraction.');
		}

		return Redirect::route('add-attraction')->with('flash_notice_error', '<strong>Error! </strong> That attraction name already exit.');

	}

	/** modify an existing attraction*/
	public function postEditAttraction()
	{

			$attractionName = Input::get('attraction_name');
			$previousAttractionName = Input::get('hidden');
			$attractionContent = Input::get('attraction_content');
			$category = null;


		AttractionsCategory::deleteCategoryAttractionByName($previousAttractionName);
		$editAttraction = Attraction::EditAttraction($previousAttractionName,$attractionName,$attractionContent);
		Review::editReviewsAttractionByAttractionName($previousAttractionName,$attractionName);
		if($editAttraction)
		{
			if($_FILES["file"])
			{

				$temp = explode(".", $_FILES["file"]["name"]);
				$extension = end($temp);
				$fileName = $attractionName.'.'.$extension;
				unlink(SITE_ROOT."/images/".$fileName);
				move_uploaded_file($_FILES["file"]["tmp_name"],SITE_ROOT."/images/".$fileName);
			}
			if(isset($_POST['category']))
			{
				$category = $_POST['category'];
				foreach($category as $categoryName)
				{
					$categoryId = Category::findCategoryId($categoryName);
					AttractionsCategory::addNewAttractionCategory($categoryId,$attractionName);
				}
			}
			return Redirect::route('modify-attraction')->with('flash_notice_success', 'You successfully edit the attraction <strong> '.$previousAttractionName.' </strong> to <strong> '.$attractionName.' </strong>');
		}
		return Redirect::route('modify-attraction')->with('flash_notice_error', '<strong>Error! </strong> That attraction name already exit.');

	}

	/** block or unblock a user*/
	public function postBlockUser()
	{
		$userId = Input::get('hidden');
		if(Input::get('block') == 'on')
		{
			$status = 1;
			User::updateUser($userId,$status);
			return Redirect::route('view-users')->with('flash_notice_success', '<strong>Well done! </strong> You successfully block this user');
		}
		else{
			$status = 0;
			User::updateUser($userId,$status);
			return Redirect::route('view-users')->with('flash_notice_success', '<strong>Well done! </strong> You successfully unblock this user');
		}

	}
	/** add new employee*/
	public function postAddEmployee()
	{
		$employeeNumber = Input::get('number');
		if(Employee::checkEmployee($employeeNumber))
		{
			return Redirect::route('add-employee')->with('flash_notice_error', '<strong>Error! </strong> Employee number '.$employeeNumber.'  already exit.');
		}
		$firstName = Input::get('f_name');
		$lastName = Input::get('l_name');
		$function = Input::get('function');
		$password = Hash::make(Input::get('password'));
		$date = Input::get('date');
		$salary = Input::get('salary');
		$employeeInfo = array(
			'employeeNumber'=>$employeeNumber,
			'firstName'=>$firstName,
			'lastName'=>$lastName,
			'function'=>$function,
			'password'=>$password,
			'startDate'=>$date,
			'salary'=>$salary,
		);

		Employee::createEmployee($employeeInfo);
		return Redirect::route('add-employee')->with('flash_notice_success', '<strong>Well done! </strong> You successfully added a new employee');

	}
	/** adding new category*/
	public function postAddCategory()
	{
		$categoryName = $_POST['category_name'];
		if(Category::getCategoryByName($categoryName) == false)
		{
			Category::addNewCategory($categoryName);
			return Redirect::route('modify-categories')->with('flash_notice_success', '<strong>Well done! </strong> You successfully added category.<strong> '.$categoryName.' </strong>');
		}
		else
		{
			return Redirect::route('modify-categories')->with('flash_notice_error', '<strong>Error! </strong> <strong> '.$categoryName.' </strong> already exit.');
		}
	}
	/** delete an existing category*/
	public function postDeleteCategory()
	{
		$categoryId = $_POST['category_id'];
		$category = Category::getCategoryById($categoryId);
		$categoryName = $category->categoryName;
		Category::deleteCategory($categoryId);


			return Redirect::route('modify-categories')->with('flash_notice_success', '<strong>Well done! </strong> You successfully deleted category with id : .<strong> '.$categoryName.' </strong>');

	}

	public function postDeleteAttraction()
	{
		$attractionName = Input::get('attractionName');
		Attraction::deleteAttractionByAttractionName($attractionName);


			return Redirect::route('modify-attraction')->with('flash_notice_success', '<strong>Well done! </strong> You successfully deleted attraction  .<strong> '.$attractionName.' </strong>');

	}
	/** delete an existing reviews*/
	public function postDeleteReviews()
	{
		$reviewIdId = $_POST['reviewId'];
		Review::deleteReviewsById($reviewIdId);
			return Redirect::route('modify-reviews')->with('flash_notice_success', '<strong>Well done! </strong> You successfully deleted the review');
	}
	/** modify an existing category*/
	public function postModifyCategory()
	{
		$categoryId = $_POST['edit_category_id'];
		$categoryName = $_POST['edit_category_name'];

		Category::modifyCategory($categoryId,$categoryName);
		return Redirect::route('modify-categories')->with('flash_notice_success', '<strong>Well done! </strong> You successfully deleted category with id : .<strong> '.$categoryId.' </strong>');
	}
	/** search reviews per attraction*/
	public function postSearchReviews()
	{
		$attractionName = $_POST['attractionName'];
		$attractionReviews = Review::getReviewsByAttractionName($attractionName);
		$reviewsAttractionformat = '<table class="tablesorter" cellspacing="0">
									<thead>
									<tr>
									<th>Username</th>
									<th>Reviews</th>
									<th>Updated On</th>
									<th>Actions</th>
									</tr>
									</thead>
									<tbody>';
		foreach($attractionReviews as $attractionReview)
		{
			$reviewsAttractionformat .='<tr>
										<td>'.$attractionReview->email.'</td>
																<td><article class=" width_quarter">

																		<div class="message_list">
																			<div class="module_content">
																				<div class="message"><p>'.$attractionReview->reviews.'</p>

																			</div>
																		</div>

																	</article><!-- end of messages article -->
																</td>
																<td>'.$attractionReview->updated_at.'</td>
																<td>

																		<button type="button" class="btn btn-info btn-xs">
																			<span class="glyphicon glyphicon-edit"></span>
																		</button>


																</td>
																<td>
																	<form class="form-horizontal" id="deleteAttraction" role="form" method="post">
																		<input type="hidden" class="form-control" id="inputEmail3" placeholder="Email" name="attractionName" value="'.$attractionReview->reviewsId.'">
																		<button type="submit" onclick="" id="subDeleteAttraction" class="btn btn-warning btn-xs">
																			<span class="glyphicon glyphicon-trash"></span>
																		</button>

																	</form>

																</td>
															</tr>';
		}

		$reviewsAttractionformat .='</tbody>
									</table>';
		return $reviewsAttractionformat;

	}


}
