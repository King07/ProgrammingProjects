<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/17/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */

class ReviewController extends BaseController
{
	public function getReviews()
	{
		$topAttractions = Review::getTopAttractionsByRatings();
		$reviews = Review::getAllReviews();
		return  View::make("reviews.reviews",array('topAttractions'=>$topAttractions,'reviews'=>$reviews));
	}




}