<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/17/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */

class UserController extends BaseController
{
	public function loginAction()
	{
		return  View::make("user.login");
	}

	public function registerAction()
	{
		return  View::make("user.register");
	}

	public function remindAction()
	{
		return  View::make("password.remind");
	}

	public function getHome()
	{
		$topAttractions = Review::getTopAttractionsByRatings();
		return  View::make("home.index",array('topAttractions'=>$topAttractions));
	}
	public function getReset($token)
	{
		return View::make('password.reset')->with('token', $token);
	}

	public function postReminder()
	{
		$credentials = array('username' => Input::get('email'));

		switch ($response = Password::remind($credentials))
		{
			case Password::INVALID_USER:
				return Redirect::back()->with('error', Lang::get($response));

			case Password::REMINDER_SENT:
				return Redirect::back()->with('success', Lang::get($response).' to <strong>'.$credentials['username'].'</strong>');
		}
	}
	public function logoutAction()
	{
		Auth::logout();
		return  Redirect::route("home")->with('flash_notice', 'You are successfully logged out.');
	}

	public function postLoginAction()
	{
		if(Input::has('email') && Input::has('password'))
		{
			$user = array(
				'username' => Input::get('email'),
				'password' => Input::get('password')
			);

			if (Auth::attempt($user)) {
				return Redirect::route('home')
					->with('flash_notice', 'You are successfully logged in.');
			}else{
				return Redirect::route('login')->with('flash_notice', 'Password or email is wrong');
			}
		}
		return Redirect::route('login')->with('flash_notice', 'Password or email is wrong');
	}

	public function postRegisterAction()
	{
		if(Input::has('email') && Input::has('password'))
		{
			$username = Input::get('email');
			$password = Input::get('password');
			User::createUser($username,$password);

			return Redirect::route('login')->with('flash_notice', 'Please login here');
		}
		return Redirect::route('login')->with('flash_notice', 'Password or email is wrong');
	}

	public function postReset()
	{
		$credentials = array(
			'username' => Input::get('email'),
			'token' => Input::get('token'),
			'password' => Input::get('password'),
			'password_confirmation' => Input::get('password_confirmation')
		);

		$response = Password::reset($credentials, function($user, $password)
			{
				$user->password = Hash::make($password);

				$user->save();


			});

		switch ($response)
		{
			case Password::INVALID_PASSWORD:
			case Password::INVALID_TOKEN:
			case Password::INVALID_USER:
				return Redirect::back()->with('error', Lang::get($response));

			case Password::PASSWORD_RESET:
				return Redirect::route('login')->with('flash_notice', 'The password reset was successful');
		}
	}




}