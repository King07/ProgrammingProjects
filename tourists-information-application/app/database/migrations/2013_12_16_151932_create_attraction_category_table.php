<?php

use Illuminate\Database\Migrations\Migration;

class CreateAttractionCategoryTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('attraction_category', function($table)
			{
				$table->integer('categoryId')->unsigned();
				$table->string('attractionName',25);
				$table->primary(array('categoryId', 'attractionName'));
				$table->timestamps();
				$table->foreign('categoryId')->references('categoryId')->on('categories')->onDelete('CASCADE')->onUpdate('CASCADE');
				$table->foreign('attractionName')->references('attractionName')->on('attractions')->onDelete('CASCADE')->onUpdate('CASCADE');

				$table->index('categoryId');
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
		Schema::drop('attraction_category');
	}

}