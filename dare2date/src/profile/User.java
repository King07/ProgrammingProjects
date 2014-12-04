package profile;

import java.util.ArrayList;
import java.sql.Date;


public abstract class  User 
{
	//basic details
	public String firstName, lastName;
	public String password;
	public String email;
	public Status profileStatus;
	public Membership membership;
	public boolean isSignin;
	public boolean paid=false;
	public ActivityStatus status;
	
	
	public ActivityStatus getStatus() {
		return status;
	}
	public void setStatus(ActivityStatus status) {
		this.status = status;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	//other details
	public String DOB;
	public Gender gender;
	
	//card info
	public int cardNumber;
	public String cardExpDate;
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpDate() {
		return cardExpDate;
	}
	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}
	public String city;
	public String country;
	public String phoneNumber;
	public ArrayList<String> preferences = new ArrayList<>();
	public ArrayList<String> hobbies = new ArrayList<>();
	public String partnerExpectations;	
	//Picture (?) :(
	
	public void Singout(){
		this.isSignin =  false;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSignin() {
		return isSignin;
	}
	public void setSignin(boolean isSignin) {
		this.isSignin = isSignin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getProfileStatus() {
		return profileStatus;
	}
	public void setProfileStatus(Status profileStatus) {
		this.profileStatus = profileStatus;
	}
	public Membership getMembership() {
		return membership;
	}
	public void setMembership(Membership membership) {
		this.membership = membership;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender male) {
		this.gender = male;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<String> getPreferences() {
		return preferences;
	}
	public void setPreferences(ArrayList<String> preferences) {
		this.preferences = preferences;
	}
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public String getPartnerExpectations() {
		return partnerExpectations;
	}
	public void setPartnerExpectations(String partnerExpectations) {
		this.partnerExpectations = partnerExpectations;
	}
	
}


enum Status {ACTIVE, INACTIVE}
enum Membership {NONMEMBER, MEMBER, VIP}
enum ActivityStatus {ONLINE, OFFLINE}

