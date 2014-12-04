<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/18/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */

class Attraction extends Eloquent
{
	/**
	 * The database table used by the model.
	 *
	 * @var string
	 */
	protected $table = 'attractions';

	/**
	 * The primary used by the model.
	 *
	 * @var  string
	 */
	protected $primaryKey = 'attractionName';
	/**
	 * The function return a list of all attractions.
	 *
	 * @var  string
	 */
	public static function getAllAttractions()
	{
		$attractions= Attraction::all();
		return $attractions;
	}

	/**
	 * The function takes one parameter and return all info on that param.
	 *@param attractionName
	 * @return array
	 */

	public static function getAttractionByAttractionName($attractionName)
	{
		$attractions = Attraction::find($attractionName);
		return $attractions;
	}

	/**
	 * The function save a new attraction.
	 *@param attractionName
	 *@param attractionContent
	 * @return boolean
	 */
	public static function addNewAttraction($attractionName,$attractionContent)
	{
		$result =  false;
		if(!Attraction::find($attractionName))
		{
			$attraction = new Attraction;
			$attraction->attractionName = $attractionName;
			$attraction->description = $attractionContent;
			$attraction->save();

			$result =  true;
		}
		return $result;

	}
	/**
	 * The function modify an existing attraction.
	 *@param previousAttractionName
	 *@param attractionName
	 *@param attractionContent
	 * @return boolean
	 */
	public static function EditAttraction($previousAttractionName,$attractionName,$attractionContent)
	{
		$result =  false;
		if(Attraction::find($previousAttractionName))
		{
			$attraction = Attraction::find($previousAttractionName);
			$attraction->attractionName = $attractionName;
			$attraction->description = $attractionContent;
			$attraction->save();
			$result =  true;
		}
		return $result;
	}
	/**
	 * The function delete an existing attraction.
	 *@param attractionName
	 * @return boolean
	 */
	public static function deleteAttractionByAttractionName($attractionName)
	{
		$result =  false;
		if(Attraction::find($attractionName))
		{
			$attraction = Attraction::find($attractionName);
			$attraction->delete();
			$result =  true;
		}
		return $result;
	}



}