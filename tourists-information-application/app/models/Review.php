<?php
/**
 * Created by JetBrains PhpStorm.
 * User: Kinson
 * Date: 12/18/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */

class Review extends Eloquent
{
	/**
	 * The database table used by the model.
	 *
	 * @var string
	 */
	protected $table = 'reviews';

	/**
	 * The primary used by the model.
	 *
	 * @var  string
	 */
	protected $primaryKey = 'reviewsId';
	/**
	 * Function that returns all attraction name that has a rating better than 2
	 */
	public static function getTopAttractionsByRatings()
	{
		$topAttractions= DB::table('Reviews')->select(DB::raw("avg(ratings) as AttractionAvg, AttractionName"))->orderBy('AttractionAvg', 'desc')->groupBy('AttractionName')->take(10)->get();
		return $topAttractions;
	}
	/**
	 * The function get an attractionName and return the average rating.
	 * @param attractionName
	 * @return array avgRating
	 */
	public static function AvgRatingsPerAttraction($attractionName)
	{
		$avgRating= DB::table('Reviews')->select(DB::raw("avg(ratings) as AttractionAvg"))->where('AttractionName','=',$attractionName)->get();
		return $avgRating;
	}

	/**
	 * Function that returns all reviews
	 */
	public static function getAllReviews()
	{
		$reviews = Review::all();
		return $reviews;
	}

	/**
	 * Function that returns all reviews for a particular attraction
	 * @param attractionName
	 * @return array reviews
	 */
	public static function getReviewsByAttractionName($attractionName)
	{
		$reviews = Review::where('AttractionName','=',$attractionName)->get();
		return $reviews;
	}
	/**
	 * Function that delete all reviews for a particular attraction
	 * @param attractionName
	 * @return void
	 */
	public static function deleteReviewsByAttractionName($attractionName)
	{
		Review::where('AttractionName','=',$attractionName)->delete();
	}
	/**
	 * Function that edit attraction name in the reviews table
	 * @param attractionName
	 * @param attractionName
	 * @return void
	 */
	public static function editReviewsAttractionByAttractionName($pveAttractionName,$attractionName)
	{
		Review::where('AttractionName', '=', $pveAttractionName)->update(array('AttractionName' => $attractionName));
	}
	/**
	 * Function that delete all reviews for a particular attraction
	 * @param attractionName
	 * @return void
	 */
	public static function deleteReviewsById($id)
	{
		$review = Review::find($id);
		$review->delete();
	}
	/**
	 * Function that create a new review
	 * @param attractionName
	 * @param email
	 * @param review
	 * @param rating
	 * @param userId
	 * @return void
	 */
	public static function createReview($attractionName,$email,$reviews,$ratings,$userId)
	{
		$review = new Review;
		$review->AttractionName = $attractionName;
		$review->email =  $email;
		$review->reviews =  $reviews;
		$review->ratings =  $ratings;
		$review->usersId =  $userId;
		$review->save();
	}
	/**
	 * Function that create a new review
	 * @param attractionName
	 * @param email
	 * @return integer
	 */
	public static function checkIfUserPost($attractionName,$email=null)
	{
		$countReviews = Review::where('AttractionName','=',$attractionName)->where('email','=',$email)->count();

		return $countReviews;
	}
}