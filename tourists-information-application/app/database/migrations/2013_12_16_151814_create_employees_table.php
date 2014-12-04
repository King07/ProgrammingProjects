<?php

use Illuminate\Database\Migrations\Migration;

class CreateEmployeesTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('employees', function($table)
			{
				$table->string('employeeNumber',10);
				$table->string('employeeFirstName',25);
				$table->string('employeeLastName',25);
				$table->string('function',50);
				$table->string('password');
				$table->date('startDate')->nullable();
				$table->integer('salary')->nullable();
				$table->timestamps();
				$table->primary('employeeNumber');

				$table->index('employeeNumber');
				$table->index('password');

			});
	}

	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('employees');
	}

}