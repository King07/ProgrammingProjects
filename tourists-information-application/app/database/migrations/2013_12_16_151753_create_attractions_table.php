<?php

use Illuminate\Database\Migrations\Migration;

class CreateAttractionsTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('attractions', function($table)
			{
				$table->string('attractionName',25);
				$table->text('description');
				$table->primary('attractionName');
				$table->timestamps();

				$table->index('attractionName');

			});
	}

	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('attractions');
	}

}