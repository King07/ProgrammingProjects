package com.example.androiddevelopmentproject;

import java.io.Serializable;
import java.sql.Date;

public class MatchBeker  implements Serializable
{

	String playerIdWhite;
	String playerIdBlack;
	String winnerId;
	int id;
	int round;
	Date updatedAt;
	
	public MatchBeker() 
	{
		
	}
	
	public MatchBeker(String playerIdWhite, String playerIdBlack,
			String winnerId, int round) {
		this.playerIdWhite = playerIdWhite;
		this.playerIdBlack = playerIdBlack;
		this.winnerId = winnerId;
		this.round = round;
	}
	
	public String getPlayerIdWhite() {
		return playerIdWhite;
	}
	
	public void setPlayerIdWhite(String playerIdWhite) {
		this.playerIdWhite = playerIdWhite;
	}
	
	public String getPlayerIdBlack() {
		return playerIdBlack;
	}
	
	public void setPlayerIdBlack(String playerIdBlack) {
		this.playerIdBlack = playerIdBlack;
	}
	
	public String getWinnerId() {
		return winnerId;
	}
	
	public void setWinnerId(String winnerId) {
		this.winnerId = winnerId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRound() {
		return round;
	}
	
	public void setRound(int round) {
		this.round = round;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "MatchBeker [playerIdWhite=" + playerIdWhite
				+ ", playerIdBlack=" + playerIdBlack + ", winnerId=" + winnerId
				+ ", id=" + id + ", round=" + round + "]";
	}
	
	
	 
	
}
