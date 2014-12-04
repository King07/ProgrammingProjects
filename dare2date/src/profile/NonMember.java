package profile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class NonMember extends User {
	

	public NonMember(String email,String password){

		this.email = email;
		this.password = password;
	}
	
	public NonMember(String firstName, String lastName, String email, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public boolean signUp() throws IOException {
		System.out.println("Signed up");
		System.out.println(this.toString());
		
		if (this.firstName == null) this.firstName = "";
		if (this.lastName == null) this.lastName = "";
		
		if(!(this.email.isEmpty() && this.password.isEmpty()))
		{
			PrintWriter outFile;
			try {
				outFile = new PrintWriter(new FileWriter(this.email +".txt", true));
				outFile.print(this.email + "\n" + this.password + "\n" );
				
				if(  !( this.firstName.isEmpty() )  ){
					outFile.print(firstName + "\n" + lastName + "\n");
				}
				else {
					
				}
				
				
				
				outFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "NonMember [firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", email=" + email + "]";
	}

	public String getEmail() {

		return this.email;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}