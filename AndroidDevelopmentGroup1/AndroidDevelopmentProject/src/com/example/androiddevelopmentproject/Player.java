package com.example.androiddevelopmentproject;

import java.io.Serializable;
import java.util.Comparator;

public class Player implements Serializable,Comparable<Player>,Comparator<Player>{
	String firstName = "firstName";
	String lastName = "lastName";
	int rating;
	String nextPairing;
	int points;
	int currentRating;
	int currentValue;
	int status; 
	int isAdmin = 0;
	int active = 0;
	int  matchWhitePlayed;
	int  matchWhitePlayedWin;
	int  matchWhitePlayedDraw;
	int  matchWhitePlayedLost;
	int  matchBlackPlayed;
	int  matchBlackPlayedWin;
	int  matchBlackPlayedDraw;
	int  matchBlackPlayedLost;
	int Winchance;


	int odd;
	String id;
	String playerSecret;
	String playerSecretHash;
	
	public Player() {
		
	}

	public Player(String id, String playerSecret,String hash) {
		
		this.id = id;
		this.playerSecret = playerSecret;
		this.playerSecretHash = hash;
	}



	public Player(String id, String firstName, String lastName,
			String nextPairing, int points, int currentRating, 
			int currentValue) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nextPairing = nextPairing;
		this.points = points;
		this.currentRating = currentRating;
		this.currentValue = currentValue;
	}

	public Player(String firstName, String lastName, 	int rating,int odd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
		this.odd = odd;
	}
	

	public Player( String id,String firstName, String lastName, int rating,
			String nextPairing, int points, int crruntRating) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
		this.nextPairing = nextPairing;
		this.points = points;
		this.currentRating = crruntRating;
		this.id = id;
	}

	public Player(String id, String firstName, String lastName,
			String nextPairing, int points, int currentRating,
			int currentValue, int matchWhitePlayed, int matchWhitePlayedWin,
			int matchWhitePlayedDraw, int matchBlackPlayed,
			int matchBlackPlayedWin, int matchBlackPlayedDraw) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nextPairing = nextPairing;
		this.points = points;
		this.currentRating = currentRating;
		this.currentValue = currentValue;
		this.matchWhitePlayed = matchWhitePlayed;
		this.matchWhitePlayedWin = matchWhitePlayedWin;
		this.matchWhitePlayedDraw = matchWhitePlayedDraw;
		this.matchBlackPlayed = matchBlackPlayed;
		this.matchBlackPlayedWin = matchBlackPlayedWin;
		this.matchBlackPlayedDraw = matchBlackPlayedDraw;
	}

	public Player(String firstName, String lastName, int rating) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public 	int getRating() {
		return rating;
	}

	public void setRating(	int rating) {
		this.rating = rating;
	}

	public String getNextPairing() {
		return nextPairing;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void setNextPairing(String nextPairing) {
		this.nextPairing = nextPairing;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getCurrentRating() {
		return currentRating;
	}

	public void setCurrentRating(int currentRating) {
		this.currentRating = currentRating;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOdd() {
		return odd;
	}

	public void setOdd(int odd) {
		this.odd = odd;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlayerSecret() {
		return playerSecret;
	}

	public String getPlayerSecretHash() {
		return playerSecretHash;
	}

	public void setPlayerSecretHash(String playerSecretHash) {
		this.playerSecretHash = playerSecretHash;
	}

	public void setPlayerSecret(String playerSecret) {
		this.playerSecret = playerSecret;
	}

	public int getMatchWhitePlayed() {
		return matchWhitePlayed;
	}

	public void setMatchWhitePlayed(int matchWhitePlayed) {
		this.matchWhitePlayed = matchWhitePlayed;
	}

	public int getMatchWhitePlayedWin() {
		return matchWhitePlayedWin;
	}

	public void setMatchWhitePlayedWin(int matchWhitePlayedWin) {
		this.matchWhitePlayedWin = matchWhitePlayedWin;
	}

	public int getMatchWhitePlayedDraw() {
		return matchWhitePlayedDraw;
	}

	public void setMatchWhitePlayedDraw(int matchWhitePlayedDraw) {
		this.matchWhitePlayedDraw = matchWhitePlayedDraw;
	}

	public int getMatchWhitePlayedLost() {
		return matchWhitePlayedLost;
	}

	public void setMatchWhitePlayedLost(int matchWhitePlayedLost) {
		this.matchWhitePlayedLost = matchWhitePlayedLost;
	}

	public int getMatchBlackPlayed() {
		return matchBlackPlayed;
	}

	public int getWinchance() {
		return Winchance;
	}

	public void setWinchance(int winchance) {
		Winchance = winchance;
	}

	public void setMatchBlackPlayed(int matchBlackPlayed) {
		this.matchBlackPlayed = matchBlackPlayed;
	}

	public int getMatchBlackPlayedWin() {
		return matchBlackPlayedWin;
	}

	public void setMatchBlackPlayedWin(int matchBlackPlayedWin) {
		this.matchBlackPlayedWin = matchBlackPlayedWin;
	}

	public int getMatchBlackPlayedDraw() {
		return matchBlackPlayedDraw;
	}

	public void setMatchBlackPlayedDraw(int matchBlackPlayedDraw) {
		this.matchBlackPlayedDraw = matchBlackPlayedDraw;
	}

	public int getMatchBlackPlayedLost() {
		return matchBlackPlayedLost;
	}

	public void setMatchBlackPlayedLost(int matchBlackPlayedLost) {
		this.matchBlackPlayedLost = matchBlackPlayedLost;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
	//compare players by ratings

	@Override
	public int compareTo(Player player) {
		// TODO Auto-generated method stub
		
		if (this.currentRating < player.currentRating) {
			return 1;
		}
		return -1;
	}

	@Override
	public int compare(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return player2.points - player1.points;
	}
	
	
	
	
	
	
	
	

}
