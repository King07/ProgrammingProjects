<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/18/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */

class Category extends Eloquent
{
	/**
	 * The database table used by the model.
	 *
	 * @var string
	 */
	protected $table = 'categories';

	/**
	 * The primary used by the model.
	 *
	 * @var  string
	 */
	protected $primaryKey = 'categoryId';


	/**
	 * The function return all categories.
	 * @return array
	 */
	public static function getAllCategories()
	{
		$categories= Category::all();
		return $categories;
	}
	/**
	 * The function return a category.
	 * @param id
	 * @return category
	 */
	public static function getCategoryById($id)
	{
		$category = Category::find($id);
		return $category;
	}

	/**
	 * The function return a category.
	 * @param categoryName
	 * @return category
	 */
	public static function getCategoryByName($categoryName)
	{
		$category = DB::table('categories')->where('categoryName', $categoryName)->first();
		return $category;
	}

	/**
	 * The function add a category.
	 * @param categoryName
	 * @return void
	 */
	public static function addNewCategory($categoryName)
	{
			$category = new Category;
			$category->categoryName = $categoryName;
			$category->save();
	}

	/**
	 * The function delete a category.
	 * @param categoryName
	 * @return void
	 */
	public static function deleteCategory($categoryId)
	{
			$category = Category::find($categoryId);
			$category->delete();
	}
	/**
	 * The function modify a category.
	 * @param categoryName
	 * @param categoryId
	 * @return void
	 */
	public static function modifyCategory($categoryId,$categoryName)
	{
			$category = Category::find($categoryId);
			$category->categoryName = $categoryName;
			$category->save();
	}
	/**
	 * The function modify a category.
	 * @param categoryName
	 * @return array
	 */
	public static function findCategoryId($categoryName)
	{
		$category =  DB::table('categories')->where('categoryName', $categoryName)->first();
		return $category->categoryId;
	}

}