<?php

use Illuminate\Auth\UserInterface;
use Illuminate\Auth\Reminders\RemindableInterface;

class User extends Eloquent implements UserInterface, RemindableInterface {

	/**
	 * The database table used by the model.
	 *
	 * @var string
	 */
	protected $table = 'users';

	/**
	 * The primary used by the model.
	 *
	 * @int auto increment
	 */
	protected $primaryKey = 'usersId';

	/**
	 * The attributes excluded from the model's JSON form.
	 *
	 * @var array
	 */
	protected $hidden = array('password');

	/**
	 * Get the unique identifier for the user.
	 *
	 * @return mixed
	 */
	public function getAuthIdentifier()
	{
		return $this->getKey();
	}

	/**
	 * Get the password for the user.
	 *
	 * @return string
	 */
	public function getAuthPassword()
	{
		return $this->password;
	}

	/**
	 * Get the e-mail address where password reminders are sent.
	 *
	 * @return string
	 */
	public function getReminderEmail()
	{
		return $this->username;
	}

	/**
	 * Register a new user to the app.
	 *@param username
	 * @param password
	 * @return void
	 */
	public static function createUser($username,$password)
	{
		$user = new User;
		$user->username = $username;
		$user->password =  Hash::make($password);
		$user->save();

	}
	/**
	 * update a user to the app.
	 */
	public static function updateUser($id,$status)
	{
		$user =  User::find($id);
		$user->block = $status;
		$user->save();

	}

	/**
	 * Get all users.
	 * @return array
	 */
	public static function getAllUsers()
	{
		$user =  User::all();
		return $user;

	}

}