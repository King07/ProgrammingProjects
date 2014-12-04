package profile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;


public class Member extends User{
	//public String email;
	//public String password;
	//public String firstName,lastName;
	Scanner in;

	public Member() 
	{
		super();
	}



	public Member(String email,String password)
	{
		this.email = email;
		this.password = password;
	}


	public boolean logIn()
	{
		System.out.println("Member is loggin in: login()");
		String newEmail = null;
		String newPassword = null;
		boolean islogin = false;
		
		if(!(this.email.isEmpty() && this.password.isEmpty()))
		{
			
			try {
				Scanner scanner;
				scanner = new Scanner(new FileReader(email + ".txt"));
				newEmail = scanner.nextLine();
				newPassword = scanner.nextLine();
				System.out.println("From file Email:" + newEmail + " " + newPassword);
				
				
				if(this.email.equals(newEmail) && this.password.equals(newPassword))
				{
					islogin = true;

				}
				scanner.close();
				//scanner.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			
			
		}

		return islogin;
	}
	public void fillAdvanceUserDataP(Member member){
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter(member.email +".txt", false));

			outFile.write( member.getEmail()  + "\n"
						+ member.getPassword() + "\n"
						+ member.getFirstName() + "\n" 
						+ member.getLastName() + "\n" 
						+ member.getCardNumber() + "\n" 
						+ member.getCardExpDate() + "\n" 
						+ member.getDOB() + "\n" 
						+ member.getGender() + "\n" 
						+ member.getCity() + "\n" 
						+ member.getCountry() + "\n"
						+ member.getPhoneNumber() + "\n" 
						+ member.getPreferences() + "\n" 
						+ member.getHobbies() + "\n" 
						+ member.getPartnerExpectations());
			
			outFile.close();
		}

		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void retriveData() throws IOException{
		//this method stores the information to the object from the file
		// in other words gives it the attributes
		BufferedReader br = new BufferedReader(new FileReader(this.email +".txt"));
		String line = new String();
		int counter = 0;
		//ArrayList<String> data = new ArrayList<String>();

		while (br.ready()) 
		{
			line = br.readLine();
			System.out.println("retriveData(): " + counter + ": " + line);
			if (counter == 2){
				this.setFirstName(line);
			}
			if (counter == 3){
				this.setLastName(line);
			}
			if (counter == 4){
				this.setCardNumber(Integer.parseInt(line));
			}else if (counter == 5){
				this.setCardExpDate(line);
			}else if (counter == 6){
				
				this.setDOB(line);
			}else if (counter == 7){
				this.setGender(Gender.valueOf(line.toUpperCase()));
			}else if (counter == 8){
				this.setCity(line);
			}else if (counter == 9){
				this.setCountry(line);
			}else if (counter == 10){
				this.setPhoneNumber(line);
			}else if (counter == 11){
				String[] preferences = line.split(" ");
				ArrayList<String> preferencec_list = new ArrayList<String>();
				for(int i=0;i<preferences.length;i++){
					preferencec_list.add(preferences[i]);
				}
				this.setPreferences(preferencec_list);
			}else if (counter == 12){
				String[] hobbies = line.split(" ");
				ArrayList<String> hobbies_list = new ArrayList<String>();
				for(int i=0;i<hobbies.length;i++){
					hobbies_list.add(hobbies[i]);
				}
				this.setHobbies(hobbies_list);
			}else if (counter == 13){
				this.setPartnerExpectations(line);
			}else if (counter == 14){
				if(line.contains("true")){
					this.setPaid(true);
				}else if (line.contains("false")){
					this.setPaid(false);
				}

			}
			counter++;
		}
		br.close();
		counter=0;
		



	}

	public void payment(boolean paid) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(this.email +".txt"));
		String line = null;
		while ((line = br.readLine()) != null) 
		{
			if (line.contains("#%has_payed%#=true"))
			{
				paid=true;
				this.setPaid(true);
			}
		}
		
		if(paid==false)
		{		
			in = new Scanner(System.in);
			System.out.print("\nEnter card holder name: ");
			String cardHolder = in.nextLine();
			System.out.print("\nEnter account number: ");
			int accountNumber = in.nextInt();
			System.out.print("\nEnter expiry date: ");
			String expiryDate = in.nextLine();
			
			System.out.print("Do you want to become a MEMBER or a VIP?: ");
			String answer = in.nextLine();
			
			if((answer.contains("MEMBER"))||(answer.toUpperCase().contains("MEMBER")))
			{
				System.out.println("THANK YOU! You have just paid 19,99 euro!");
				this.membership = Membership.MEMBER;
				System.out.println("You are a " + this.membership + "!");
			}
			
			else if((answer.contains("VIP"))||(answer.toUpperCase().contains("VIP")))
			{
				System.out.println("THANK YOU! You have just paid 39,99 euro!");
				this.membership = Membership.VIP;
				System.out.println("You are a " + this.membership + "!");
			}
			PrintWriter outFile = new PrintWriter(new FileWriter(this.email +".txt", true));
			
			outFile.write("#%has_payed%#=true");
			outFile.close();
		}	
		
	}
	
	public boolean sendMessage(String receiver, String subject, String message){
		boolean succeeded = false;

		PrintWriter outFile;
		try {
			outFile = new PrintWriter(new FileWriter(receiver + "_received_messages" + ".txt", true));
			outFile.write(	  "From: " + this.email + "\n"
							+ "Subject: " + subject + "\n" 
							+ "Message: " + message + "\n" 
							+  "\n" + "\n" );
			outFile.close();
			succeeded =  true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return succeeded;
		
	}
public ArrayList<String> searchUsers(String searchedName){
	//SEARCHING

			//SEPERATE WORDS BY SPACE (" ")
			String[] searchedNamesS = searchedName.split(" ");
			ArrayList<String> searchedNames = new ArrayList<String>();
			ArrayList<String> results = new ArrayList<String>();
			for(int i=0;i<searchedNamesS.length;i++)
			{
				searchedNames.add(searchedNamesS[i]);
			}

			//GET CURRENT DIRECTORY
			String myCurrentDir = System.getProperty("user.dir");

			ArrayList<String> listOfEmails = new ArrayList<String>();
			File[] files = new File(myCurrentDir).listFiles();

			//ADDING FILE NAMES(USERS) TO AN ARRAY
			for (File file : files) {
				if (file.isFile()&&file.getName().contains(".txt")) {
					listOfEmails.add(file.getName());
				}
			}

			//SEARCHING THROUGH THE USERS IF THEY CONTAIN SEARCHED KEY WORDS....
			int count = 0;
			for(int i=0; i<listOfEmails.size(); i++)
			{
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader(listOfEmails.get(i)));
					String line = null;
					String check = null;

					
					while (br.ready() && count < 2 ) 
					{
						line = br.readLine();
						for(int z = 0; z<searchedNames.size();z++)
						{
							//INCLUDED CASE OF ENTRY IN LOWER OR UPPER CASE TOO...
							if(((line.contains(searchedNames.get(z))||(line.contains(searchedNames.get(z).toLowerCase()))||(line.contains(searchedNames.get(z).toUpperCase())))&&(listOfEmails.get(i)!=check)))
							{
								//PRINTING USER NAMES
								if( ! (line.endsWith("_received_messages") ) ){
									System.out.println("Line: " + line);
									results.add(line);
									System.out.println("Search Results: " + results);
									check = listOfEmails.get(i);
								}
							}
						}
						count++;
					}
					br.close();
				}	
				
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				count=0;
			}
			return results;
}

	public String getMessages(){
		
		BufferedReader br;
		StringBuilder messageB = new StringBuilder();
		String messageR = "You have no messages";
		try {
			System.out.println(this.email + "_received_messages" +".txt");
			br = new BufferedReader(new FileReader(this.email + "_received_messages" +".txt"));
			
			while (br.ready()) 
			{
				messageB.append(br.readLine() + "\n");
			}
			br.close();
			messageR = messageB.toString();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			messageR = "You have no messages...";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			messageR = "Can not read messages";
		}
		
	return messageR;

	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}



	public String getProfileInfo() {
		String profileInfo 	= "Gender: " + this.gender + "\n"
							+ "Date of Birth:" + this.DOB + "\n"
							+ "City: " + this.city + "\n"
							+ "Country: " + this.country + "\n"
							+ "Phone Number: " + this.phoneNumber + "\n"
							+ "Preferences: " + this.preferences + "\n"
							+ "Hobbies: " + this.hobbies + "\n"
							+ "Partner Expectations: " + this.partnerExpectations
							;
		return profileInfo;
	}
	
}
