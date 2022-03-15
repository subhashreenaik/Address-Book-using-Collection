/**
 * 
 */
package com.test.example;

/**
 * @author subhashree
 *
 */
public class PersonInfo {
	
	//Declaring instance variable
		private String firstName;
		

		private String lastName;
		private String address;
		private String city;
		private String state;
		private String zip;
		private String phoneNo;
		private String email;
		
		/*
		 * Declaring parameterised constructor of class
		 */
		PersonInfo(String firstName, String lastName,String address,String city,String state,String zip,String phoneNo,String email){
			this.lastName = lastName;
			this.address = address;
			this.firstName = firstName;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.phoneNo=phoneNo;
			this.email = email;
			
		}
		/*
		 * these are the getter and setter method to access the private variable
		 */
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public String getAddress() {
			return address;
		}
		
		public String getCity() {
			return city;
		}
		
		public String getState() {
			return state;
		}
		
		public String getZip() {
			return zip;
		}
		
		public String getPhoneNo() {
			return phoneNo;
		}
		
		public String getEmail() {
			return email;
		}
		
		@Override
		public String toString() {
			return "PersonInfo [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
					+ city + ", state=" + state + ", zip=" + zip + ", phoneNo=" + phoneNo + ", email=" + email + "]";
		}
		
		
		

}
