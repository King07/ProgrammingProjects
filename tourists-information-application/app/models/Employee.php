<?php

use Illuminate\Auth\UserInterface;
use Illuminate\Auth\Reminders\RemindableInterface;

class Employee extends Eloquent {

	/**
	 * The database table used by the model.
	 *
	 * @var string
	 */
	protected $table = 'employees';
	protected $primaryKey = 'employeeNumber';

	/**
	 * The function attempt to login an employee.
	 * @param array
	 * @return boolean
	 */
	public static function attempt(array $credentials)
	{
		$employee = self::getEmployee($credentials['employeeNumber']);
		$result = false;
		if($employee == true && Hash::check($credentials['password'], $employee->password))
		{

			$result = true;
		}
		return $result;
	}

	/**
	 * The function get an employee records.
	 * @param employeeNumber
	 * @return employee
	 */
	public static function getEmployee($employeeNumber)
	{
		$employee = Employee::find($employeeNumber);

		if($employee)
		{
			return $employee;
		}
	}
	/**
 * The function creates an employee.
 * @param array
 * @return employee
 */
	public static function createEmployee(array $employeeInfo)
	{
		$employee = new Employee;
		$employee->employeeNumber = $employeeInfo['employeeNumber'];
		$employee->employeeFirstName = $employeeInfo['firstName'];
		$employee->employeeLastName = $employeeInfo['lastName'];
		$employee->function = $employeeInfo['function'];
		$employee->password = $employeeInfo['password'];
		$employee->startDate = $employeeInfo['startDate'];
		$employee->salary = $employeeInfo['salary'];
		$employee->save();

	}

	/**
	 * The function checks if an employee exist.
	 * @param id
	 * @return employee
	 */
	public static function checkEmployee( $employeeId)
	{
		$employee = Employee::find($employeeId);
		$hasEmployee = false;
		if($employee)
		{
			$hasEmployee = true;
		}
		return $hasEmployee;
	}
}