<?php

use Illuminate\Database\Migrations\Migration;

class CreateReviewsTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('reviews', function($table)
			{
				$table->increments('reviewsId');
				$table->string('AttractionName',25);
				$table->string('email',25);
				$table->string('reviews',100)->nullable();
				$table->integer('ratings')->nullable();
				$table->integer('usersId')->unsigned();
				$table->timestamps();
				$table->foreign('usersId')->references('usersId')->on('users')->onDelete('CASCADE')->onUpdate('CASCADE');

				$table->index('reviewsId');
				$table->index('email');
				$table->index('ratings');

			});
	}

	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('reviews');
	}

}