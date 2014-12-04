<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

define ('SITE_ROOT', realpath(dirname(__FILE__)));


Route::get("/", array("as"=>"home","uses" => "UserController@getHome"));
Route::get("home", array("as"=>"home","uses" => "UserController@getHome"));
Route::get("login", array("as"=>"login","uses" => "UserController@loginAction"));
Route::get("register", array("as"=>"register","uses" => "UserController@registerAction"));
Route::get("logout", array("as"=>"logout","uses" => "UserController@logoutAction"));
Route::get("password/remind", array("as"=>"remind","uses" => "UserController@remindAction"));
Route::get("attractions", array("as"=>"attractions","uses" => "AttractionController@getAttractions"));
Route::get("attractions-details", array("as"=>"attraction-details","uses" => "AttractionController@getAttractionDetails"));
Route::get("categories", array("as"=>"categories","uses" => "CategoryController@getCategories"));
Route::get("categories-details", array("as"=>"category-details","uses" => "CategoryController@getCategoryDetails"));
Route::get("reviews", array("as"=>"reviews","uses" => "ReviewController@getReviews"));
Route::get("admin", array("as"=>"admin","uses" => "AdminController@getAdmin"));
Route::get("dashboard", array("as"=>"dashboard","uses" => "AdminController@getDashboard"));
Route::get("add-attraction", array("as"=>"add-attraction","uses" => "AdminController@getAddAttraction"));
Route::get("modify-attraction", array("as"=>"modify-attraction","uses" => "AdminController@getModifyAttraction"));
Route::get("modify-categories", array("as"=>"modify-categories","uses" => "AdminController@getModifyCategories"));
Route::get("modify-reviews", array("as"=>"modify-reviews","uses" => "AdminController@getModifyReviews"));
Route::get("view-users", array("as"=>"view-users","uses" => "AdminController@getUsers"));
Route::get("add-employee", array("as"=>"add-employee","uses" => "AdminController@AddEmployee"));
Route::get("user-profile", array("as"=>"user-profile","uses" => "AdminController@ViewUser"));
Route::get("modify-attraction-edit", array("as"=>"modify-attraction-edit","uses" => "AdminController@EditAttraction"));


Route::post("modify-attraction-edit", array("uses" => "AdminController@postEditAttraction"));
Route::post('admin', array("uses" => "AdminController@postAdminLogin"));
Route::post('login', array("uses" => "UserController@postLoginAction"));
Route::post('register', array("uses" => "UserController@postRegisterAction"));
Route::post('attractions-details', array("uses" => "AttractionController@postCommentsRatings"));
Route::post('user-profile', array("uses" => "AdminController@postLogout"));
Route::post('dashboard', array("uses" => "AdminController@postLogout"));
Route::post('add-attraction', array("uses" => "AdminController@postLogout"));
Route::post('add-attraction', array("uses" => "AdminController@postAddAttraction"));
Route::post('modify-attraction', array("uses" => "AdminController@postLogout"));
Route::post('modify-attraction', array("uses" => "AdminController@postDeleteAttraction"));
Route::post('modify-categories', array("uses" => "AdminController@postLogout"));
Route::post('modify-categories', array("uses" => "AdminController@postAddCategory"));
Route::post('modify-categories', array("uses" => "AdminController@postDeleteCategory"));
Route::post('modify-categories', array("uses" => "AdminController@postModifyCategory"));
Route::post('modify-reviews', array("uses" => "AdminController@postLogout"));
Route::post('modify-reviews', array("uses" => "AdminController@postSearchReviews"));
Route::post('modify-reviews', array("uses" => "AdminController@postDeleteReviews"));
Route::post('view-users', array("uses" => "AdminController@postLogout"));
Route::post('view-users', array("uses" => "AdminController@postBlockUser"));
Route::post('add-employee', array("uses" => "AdminController@postLogout"));
Route::post('add-employee', array("uses" => "AdminController@postAddEmployee"));
Route::post('password/remind', array('uses'=>'UserController@postReminder'));

Route::get('password/reset/{token}', array('uses'=>'UserController@getReset'));

Route::post('password/reset/{token}',array('uses'=> 'UserController@postReset') );