package com.example.political;

import java.io.Serializable;

public class PoliticalPartyPromise implements Serializable{

	 /**
	 * _id     - key
    *         promise    - text
    *         description   - text
    *         plus - text
    *         minus - text
    *         equal - text
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String promise;
	private String decription;

	private String plus;
	private String minus;
	private String equal;
	
	public PoliticalPartyPromise() {
		
	}
	
	public PoliticalPartyPromise(String promise, String decription) {
		
		this.promise = promise;
		this.decription = decription;
	}
	public PoliticalPartyPromise(int id, String promise, String decription) {
		
		this.id = id;
		this.promise = promise;
		this.decription = decription;
	}
	public PoliticalPartyPromise(int id, String promise, String decription,
			String plus, String minus, String equal) {
		super();
		this.id = id;
		this.promise = promise;
		this.decription = decription;
		this.plus = plus;
		this.minus = minus;
		this.equal = equal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPromise() {
		return promise;
	}
	public void setPromise(String promise) {
		this.promise = promise;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getPlus() {
		return plus;
	}
	public void setPlus(String plus) {
		this.plus = plus;
	}
	public String getMinus() {
		return minus;
	}
	public void setMinus(String minus) {
		this.minus = minus;
	}
	public String getEqual() {
		return equal;
	}
	public void setEqual(String equal) {
		this.equal = equal;
	}

	@Override
	public String toString() {
		return "PoliticalPartyPromise [id=" + id + ", promise=" + promise
				+ ", decription=" + decription + "]";
	}
	
	
	
	
	
	 
	   
	   
	  

 
}