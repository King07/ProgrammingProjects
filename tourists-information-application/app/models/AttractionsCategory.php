<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/18/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */

class AttractionsCategory extends Eloquent
{
	/**
	 * The database table used by the model.
	 *
	 * @var string
	 */
	protected $table = 'attraction_category';

	/**
	 * The function return a list of all attractions names with that id.
	 *
	 * @var  string
	 */
	public static function getAttractionNamesByCategoryId($categoryId)
	{
		$attractionNames= AttractionsCategory::where('categoryId', '=', $categoryId)->get();
		return $attractionNames;
	}

	/**
	 * The function return a list of all category ids.
	 *@param attractionName
	 * @return array
	 */

	public static function getCategoryIdByAttractionNames($attractionName)
	{
		$categoryIds= AttractionsCategory::where('attractionName', '=', $attractionName)->get();
		return json_decode($categoryIds,true);
	}
	/**
	 * The function return a list of all attractions categories.
	 *@param attractionName
	 * @return array
	 */
	public static function getCategoryAttractionByName($attractionName)
	{
		$attractionCategory = AttractionsCategory::where('attractionName', '=', $attractionName)->get();
		return $attractionCategory;
	}


	/**
	 * The function delete all attractions with that attraction name.
	 *@param attractionName
	 * @return void
	 */
	public static function deleteCategoryAttractionByName($attractionName)
	{
		if(self::getCategoryAttractionByName($attractionName))
		{
			DB::table('attraction_category')->where('attractionName', '=', $attractionName)->delete();
		}

	}
	/**
	 * The function add new attractions categories.
	 *@param attractionName
	 *@param categoryId
	 * @return void
	 */
	public static function addNewAttractionCategory($categoryId,$attractionName)
	{
		$category = new AttractionsCategory;
		$category->categoryId = $categoryId;
		$category->attractionName = $attractionName;
		$category->save();


	}
	/**
	 * The function add new attractions categories.
	 *@param attractionName
	 *@param categoryId
	 * @return boolean
	 */
	public static function existAttractionCategory($categoryId,$attractionName)
	{
		$attractionCategory =DB::table('attraction_category')->where('categoryId', $categoryId)->where('attractionName', $attractionName)->first();
		$result = false;
		if($attractionCategory)
		{
			$result = true;
		}
		return $result;
	}
}