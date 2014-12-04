package com.example.political;

import java.io.Serializable;

public class PoliticalParty implements Serializable, Comparable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int id;
	private String name;
	private String decription;
	private int plus = 0;
	private int minus = 0;
	private int equal = 0;
	private String statistic = "0 = 0 - 0";
	private int image;
	
	
	 

	public PoliticalParty() {
		
	}
		public PoliticalParty(String name, String decription) {
			
			this.name = name;
			this.decription = decription;
		}

	public PoliticalParty(int id,String name, String decription, String statistic) {
	
		this.name = name;
		this.decription = decription;
		this.statistic = statistic;
		this.id = id;
	}

	public PoliticalParty(String name, String decription, String statistic) {
		
		this.name = name;
		this.decription = decription;
		this.statistic = statistic;
	}
	
	public PoliticalParty(String name, String decription, int image) {
		
		this.name = name;
		this.decription = decription;
		this.image = image;
	}
	
	
	public PoliticalParty(int id, String name, String decription, int plus,
			int minus, int equal) {
		
		this.id = id;
		this.name = name;
		this.decription = decription;
		this.plus = plus;
		this.minus = minus;
		this.equal = equal;
	}
	   public PoliticalParty(int id, String name, String decription, int plus,
			int minus, int equal, int image) {
		this.id = id;
		this.name = name;
		this.decription = decription;
		this.plus = plus;
		this.minus = minus;
		this.equal = equal;
		this.image = image;
	}
	public int getId() {
	       return id;
	   }
	 
	   public void setId(int id) {
	       this.id = id;
	   }
	 
	   public String getNamet() {
	       return name;
	   }
	 
	   public void setName(String text) {
	       this.name = text;
	   }

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getStatistic() {
		return "+" +getPlus()+ " = "+ getEqual()+ " - "+getMinus();
	}
	
	public int getReliableIndex(){
		int div = getEqual()/10;
		int RI = getPlus() - div - getMinus();
		return RI;
	}

	public void setStatistic(String statistic) {
		this.statistic = statistic;
	}

	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

	public int getMinus() {
		return minus;
	}

	public void setMinus(int minus) {
		this.minus = minus;
	}

	public int getEqual() {
		return equal;
	}

	public void setEqual(int equal) {
		this.equal = equal;
	}

	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "PoliticalParty [id=" + id + ", name=" + name + ", decription="
				+ decription + ", plus=" + plus + ", minus=" + minus
				+ ", equal=" + equal + ", statistic=" + statistic + "]";
	}
	@Override
	public int compareTo(Object object) {
		// TODO Auto-generated method stub
		final int BEFORE = -1;
	    final int AFTER = 1;
	    int result = 0;
		PoliticalParty politicalParty = (PoliticalParty) object;
		if(this.getReliableIndex() > politicalParty.getReliableIndex())
		{
			result =  BEFORE;
		}
		if(this.getReliableIndex() < politicalParty.getReliableIndex())
		{
			result = AFTER;
		}
		
		return result;
	}


	   
	  

 
}