<?php

use Illuminate\Database\Migrations\Migration;

class CreateUsersTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('users', function($table)
			{
				$table->increments('usersId');
				$table->string('username',100);
				$table->string('password');
				$table->boolean('block')->default(0);
				$table->timestamps();

				$table->index('username');
				$table->index('password');
				$table->index('usersId');
				$table->index('block');
			});
	}

	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('users');
	}

}