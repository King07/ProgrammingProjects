<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/17/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */

class AttractionController extends BaseController
{
	public function getAttractions()
	{
		$topAttractions = Review::getTopAttractionsByRatings();
		$attractions = Attraction::getAllAttractions();
		return  View::make("attractions.attractions",array('attractions'=>$attractions,'topAttractions'=>$topAttractions));
	}

	public function getAttractionDetails()
	{
		$attractionName = Input::get('AttractionName');
		$attraction = Attraction::getAttractionByAttractionName($attractionName);
		$reviews = Review::getReviewsByAttractionName($attractionName);
		$topAttractions = Review::getTopAttractionsByRatings();

		$email =(Auth::check()) ? Auth::user()->username : null;
		$amountReview = Review::checkIfUserPost($attractionName,$email);

		$attractionRatings = Review::AvgRatingsPerAttraction($attractionName);
		return  View::make("attractions.details",array('attraction'=>$attraction,'topAttractions'=>$topAttractions,'reviews'=>$reviews,'amountReview'=>$amountReview,'attractionRatings'=>$attractionRatings));
	}

	public function postCommentsRatings()
	{
		if(Input::has('comments') || Input::has('Rating'))
		{
			$userId = Auth::user()->usersId;
			$email = Auth::user()->username;
			$review = Input::get('comments');
			$rating = Input::get('Rating');
			$attractionName = Input::get('AttractionName');

			Review::createReview($attractionName,$email,$review,$rating,$userId);


		}
	}


}