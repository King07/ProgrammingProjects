package profile;

import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import profile.Member;

public class Matching 
{
	BufferedReader br = null;

	public Matching(){
		
	}
	public ArrayList<String> basicMatch(String entry)
	{
		//WEIRD WORKING WAY TO CHECK IF IT CONTAINS A NUMBER... which works
		ArrayList<String> results = new ArrayList<String>();
		if(entry.matches(".*\\d.*"))
		{
			//age
			//matchPerson.getDOB();

			/*String age = "1988-05-02";
			Date date = java.sql.Date.valueOf(age);

			Date currentDate = new Date();	
			String txtDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);

			Calendar dob = Calendar.getInstance();  
			dob.setTime(date);
			Calendar today = Calendar.getInstance();
			int age2 = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
			if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))  
				age2--;  
			 */

			//age
			ArrayList<String> searchedPeople = new ArrayList<String>();
			
			searchedPeople = getListOfEmails();

			for(int i=0; i<searchedPeople.size(); i++)
			{
				int y = 0;
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader(searchedPeople.get(i)));
					String line = null;
					while (((line = br.readLine()) != null)) 
					{
						//check line 6 for age
						if(y==6)
						{
							String DOB = line;
							System.out.println("Age: " + line);
							Date date = java.sql.Date.valueOf(DOB.trim());						

							Date currentDate = new Date();	
							String txtDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);

							Calendar dob = Calendar.getInstance();  
							dob.setTime(date);
							Calendar today = Calendar.getInstance();
							int age2 = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
							if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))  
								age2--;  

							if(Integer.valueOf(entry)==age2)
							{
								results.add(searchedPeople.get(i));
								System.out.println(searchedPeople.get(i));
							}
						}
						y++;
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(y>=15)
				{
					y=0;
				}
			}


		}
		else
		{
			//location
			ArrayList<String> searchedPeople = new ArrayList<String>();
			searchedPeople = getListOfEmails();
			
			
			for(int i=0; i<searchedPeople.size(); i++)
			{
				int y = 0;
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader(searchedPeople.get(i)));
					String line = null;
					while (br.ready()) 
					{
						//check line 9 for city
						line = br.readLine();
						
						if((y==8)){
							
							if(((line.contains(entry))||(line.toLowerCase().contains(entry)))){
								System.out.println("[" + line  + "]");
								results.add(searchedPeople.get(i));
								System.out.println(searchedPeople.get(i));
							}
							
						}
						
						y++;
					}
					
					br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			

		}
		return results;
	}
	

	public ArrayList<String> AdvMatching35(String age, String gender, String city, ArrayList<String>pref, ArrayList<String>hobbies){
		String previous = null;
		int points = 0;
		boolean check = false;
		ArrayList<String> result = new ArrayList<String>();
		/*

		 * DateOfBirth
		 * Gender
		 * City
		 * Preferences
		 * Hobbies

		 */
		ArrayList<String> searchedPeople = new ArrayList<String>();
		searchedPeople = getListOfEmails();

		for(int i=0; i<searchedPeople.size(); i++)
		{
			int y = 0;
			try {
				br = new BufferedReader(new FileReader(searchedPeople.get(i)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String line = null;
			try {
				while (((line = br.readLine()) != null)) 
				{
					//check age
					if(y==8)
					{
						String DOB = line;
						Date date = java.sql.Date.valueOf(DOB);						

						Date currentDate = new Date();	
						String txtDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);

						Calendar dob = Calendar.getInstance();  
						dob.setTime(date);
						Calendar today = Calendar.getInstance();
						int age2 = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
						if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))  
							age2--;  

						if(Integer.valueOf(age)==age2)
						{
							points++;
						}
						
					}
					//check gender
					if((y==9)&&((line.contains(gender))||(line.toUpperCase().contains(gender))))
					{
						points++;
					}
					//check city
					if((y==10)&&((line.contains(city))||(line.toLowerCase().contains(city))))
					{
						points++;
					}
					//check preferences
					if(y==13)
					{
						for(int z = 0; z<pref.size(); z++)
						{
							if(line.contains(pref.get(z)))
							{
								check=true;
							}
						}
						if(check==true)
						{
							points++;
						}
					}
					
					//check hobbies
					if(y==14)
					{
						for(int z = 0; z<hobbies.size(); z++)
						{
							if(line.contains(hobbies.get(z)))
							{
								check=true;
							}
						}
						if(check==true)
						{
							points++;
						}
					}
					
					if((points>=3)&&(searchedPeople.get(i)!=previous))
					{
						result.add(searchedPeople.get(i));
						previous = searchedPeople.get(i);
						
					}
					
					y++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(y==16)
			{
				y=0;
			}
		}
		return result;

	}

	
	//==============edit=================
	public static ArrayList<String> AdvanceMatchingFull(String fName, String lName, String age, String gender, String city, String country, String phoneNumber, ArrayList<String> pref, ArrayList<String> hobbies)
	{
		ArrayList<String> result = new ArrayList<String>();
		String previous = null;
		int points = 0;
		boolean check = false;
		/*

		 * First Name
		 * Last Name
		 * DateOfBirth
		 * Gender
		 * City
		 * Country
		 * PhoneNumber
		 * Preferences
		 * Hobbies

		 */
		ArrayList<String> searchedPeople = new ArrayList<String>();
		searchedPeople = getListOfEmails();

		for(int i=0; i<searchedPeople.size(); i++)
		{
			int y = 0;
			BufferedReader br;
			String line = null;
			try {
				br = new BufferedReader(new FileReader(searchedPeople.get(i)));
				while (((line = br.readLine()) != null)) 
				{
					//check firstName
					if((y==4)&&(line.contains(fName))&&(line.toLowerCase().contains(fName)))
					{
						points++;
					}
					//check lastName
					if((y==5)&&(line.contains(lName))&&(line.toLowerCase().contains(lName)))
					{
						points++;
					}
					
					//check age
					if(y==8)
					{
						String DOB = line;
						Date date = java.sql.Date.valueOf(DOB);						

						Date currentDate = new Date();	
						String txtDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);

						Calendar dob = Calendar.getInstance();  
						dob.setTime(date);
						Calendar today = Calendar.getInstance();
						int age2 = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
						if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))  
							age2--;  

						if(Integer.valueOf(age)==age2)
						{
							points++;
						}
						
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				//check gender
				if((y==9)&&((line.contains(gender))||(line.toUpperCase().contains(gender))))
				{
					points++;
				}
				//check city
				if((y==10)&&((line.contains(city))||(line.toLowerCase().contains(city))))
				{
					points++;
				}
				
				//check country
				if((y==11)&&((line.contains(country))||(line.toLowerCase().contains(country))))
				{
					points++;
				}
				
				//check phoneNumber
				if((y==12)&&((line.contains(phoneNumber))))
				{
					points++;
				}
				//check preferences
				if(y==13)
				{
					for(int z = 0; z<pref.size(); z++)
					{
						if(line.contains(pref.get(z)))
						{
							check=true;
						}
					}
					if(check==true)
					{
						points++;
					}
				}

				//check hobbies
				if(y==14)
				{
					for(int z = 0; z<hobbies.size(); z++)
					{
						if(line.contains(hobbies.get(z)))
						{
							check=true;
						}
					}
					if(check==true)
					{
						points++;
					}
				}

				if((points>=9)&&(searchedPeople.get(i)!=previous))
				{
					result.add(searchedPeople.get(i));
					previous = searchedPeople.get(i);

				}

				y++;
		}

		
		return result;
	}
	
	
	//==============edit=================
	
	
	
	public static ArrayList<String> getListOfEmails(){
		//CHECKING FROM WHERE THE METHOD IS CALLED - boolean printing
		//SEARCHING
		
		//GET CURRENT DIRECTORY
		String myCurrentDir = System.getProperty("user.dir");
		ArrayList<String> results = new ArrayList<String>();
		File[] files = new File(myCurrentDir).listFiles();

		//ADDING FILE NAMES(USERS) TO AN ARRAY
		for (File file : files) {
			if (file.isFile() && !( file.getName().endsWith(("_received_messages.txt")) ) &&(file.getName().contains(".txt")) ) {
				results.add(file.getName());
			}
		}
			
			return results;
		}

}
