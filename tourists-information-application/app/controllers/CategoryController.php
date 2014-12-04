<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/17/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */

class CategoryController extends BaseController
{
	public function getCategories()
	{
		$topAttractions = Review::getTopAttractionsByRatings();
		$categories = Category::getAllCategories();
		return  View::make("categories.categories",array('topAttractions'=>$topAttractions,'categories'=>$categories));
	}
	public function getCategoryDetails()
	{
		$topAttractions = Review::getTopAttractionsByRatings();
		$categoryId = Input::get('categoryId');
		$attractions = AttractionsCategory::getAttractionNamesByCategoryId($categoryId);
		$category = Category::getCategoryById($categoryId);
		return  View::make("categories.details",array('topAttractions'=>$topAttractions,'attractions'=>$attractions,'category'=>$category));
	}


}