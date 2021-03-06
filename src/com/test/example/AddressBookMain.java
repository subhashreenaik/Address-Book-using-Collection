package com.test.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class AddressBookMain {
	
    //Declaring variable
	static String fname, lname, add, city, state, zip, phoneno, emailid;
	private static String addressId;
	List<PersonInfo> infos;
	static List<PersonInfo> contact;
	static Map<String, List<PersonInfo>> addressBook;
	
	/*
     * This is the default constructor of main class where we creating 
     * arrayList and HashMap
     */
	public AddressBookMain() {
		contact = new ArrayList<PersonInfo>();
		addressBook = new HashMap<String, List<PersonInfo>>();
	}
	
	/*
	 * Here we are defining all getter and setter method of
	 * addressBook,addressId 
	 */

	public Map<String, List<PersonInfo>> getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(Map<String, List<PersonInfo>> addressBook) {
		this.addressBook = addressBook;
	}
    	
	public String getaddressId() {
		return addressId;
	}

	public List<PersonInfo> getPersonInfo() {
		return infos;
	}

	public void setPersonInfo(List<PersonInfo> infos) {
		this.infos = infos;
	}
	
/*
 * This method is used to enter the information of a person
 * like first name,last name,address,city,zip,state,mobile no,and email id
 */
	public static  void enterInform() {
	     Scanner sc = new Scanner(System.in);
		System.out.println("Enter your First name :");
		fname = sc.nextLine();
		System.out.println("Enter your Last name : ");
		lname = sc.nextLine();
		System.out.println("Enter your address :");
		add = sc.nextLine();
		System.out.println("Enter your city :");
		city = sc.nextLine();
		System.out.println("Enter your state :");
		state = sc.nextLine();
		System.out.println("Enter your zip :");
		zip = sc.nextLine();
		System.out.println("Enter your phoneno :");
		phoneno = sc.nextLine();
		System.out.println("Enter your email id :");
		emailid = sc.nextLine();
		
	}
   
	/*
	  * This method is used to delete the all information of a person of addressbook
	  *  by name and update the address book
	  */
	 public void deletePerson() {
		 System.out.println("Enter the name of the person you want to delete");
			Scanner s = new Scanner(System.in);
			String name = s.nextLine();

			for (int j = 0; j < addressBook.size(); j++) {
				for (Map.Entry<String, List<PersonInfo>> e : addressBook.entrySet())
				{
					for (int i = 0; i < contact.size(); i++) {
						if(e.getValue().get(i).getFirstName().equals(name)) {
							e.getValue().remove(i);
					    System.out.println("Information is deleted");
					    System.out.println(addressBook);
					    return;
				}
				}
			   }
			}
			System.out.println("The name is different");
	 }
	 /*
	  * This method is used to edit the all information of a person of addressbook
	  *  by name and update the address book
	  */
	 
	 public  void editPerson() {
		
		 System.out.println("Enter the name of the person you want to edit");
			Scanner s = new Scanner(System.in);
			String name = s.nextLine();
			for (int j = 0; j < addressBook.size(); j++) {
				for (Map.Entry<String, List<PersonInfo>> e : addressBook.entrySet())
				{
					for (int i = 0; i < contact.size(); i++) {
						if(e.getValue().get(i).getFirstName().equals(name)) {
							System.out.println("Enter the information you want to update");
							enterInform();
							PersonInfo person3 = new PersonInfo(fname, lname, add, city, state, zip, phoneno, emailid);
							e.getValue().set(i, person3);
							System.out.println("Information is updated");
							System.out.println(addressBook);
							return;
						}		
					}
				}		
				}
					System.out.println("The name is different");
	}
			
	/*
	 * This method first check the person's information is present or not,
	 * if not then add the person's information to the addressBook. 
	 */
	 public void checkDupicateAndAdd() {
		 AddressBookMain address = new AddressBookMain();
		 Scanner s = new Scanner(System.in);
			System.out.println("How many person's information You want to add in one address book");	
			int n=s.nextInt();
			int flag=0;
			String[] addressId= {"AddressBookOne","AddressBookTwo","AddressBookThree"};
			
			for(int j =0;j<addressId.length;j++) {
				System.out.println("Enter information for "+addressId[j]);
				contact=new ArrayList<PersonInfo>();
			for(int i=0;i<n;i++) {
				flag=0;
				enterInform();
				PersonInfo person = new PersonInfo(fname, lname, add, city, state, zip, phoneno, emailid);
				 if(contact.size()==0) {
				 contact.add(person);
				 
				address.setPersonInfo(contact);
				address.setAddressBook(addressBook);
				}
				 else
				 {
					 for(int k=0; k<contact.size();k++) {
						 if(contact.get(k).getFirstName().equals(person.getFirstName())) {
							 System.out.println("The name is already exist");
							 enterInform();
							 PersonInfo person1 = new PersonInfo(fname, lname, add, city, state, zip, phoneno, emailid);
							 contact.add(person1);
							 address.setPersonInfo(contact);
							 address.setAddressBook(addressBook);
							 flag=1;
							 break;
						 }
						 
					 }
					 if(flag == 0) {
					 contact.add(person);
					 address.setPersonInfo(contact);
					 address.setAddressBook(addressBook);
					 }	 
				 } 
			}
			    addressBook.put(addressId[j],contact);
			}
			System.out.println(addressBook);
	 }
	 /*
		 * This method searching all first name from contact 
		 * where their state name is same
		 *  
		 */  
	 public void search() {
		  Scanner scan=new Scanner(System.in);
		  System.out.println("Enter the state name  :");
		  String state=scan.nextLine();
		 
				for (Map.Entry<String, List<PersonInfo>> e : addressBook.entrySet())
				{
					for (int i = 0; i < contact.size(); i++) {
						if(e.getValue().get(i).getState().equals(state) ) {
							System.out.println(e.getValue().get(i).getFirstName());
						}
					}
				}
		  }  
	 /*
		 * This method searching all phone number from multiple address book
		 * where their state name is same
		 *  
		 */
	 public void getPersonMobileNumber() {
		  Scanner scan=new Scanner(System.in);
		  System.out.println("Enter the state name  :");
		  String state=scan.nextLine();
		 
				for (Map.Entry<String, List<PersonInfo>> e : addressBook.entrySet())
				{
					for (int i = 0; i < contact.size(); i++) {
						if(e.getValue().get(i).getState().equals(state) ) {
							System.out.println("Name of the person : "+e.getValue().get(i).getFirstName()+"   "+"Phone number  "+e.getValue().get(i).getPhoneNo());
						}
					}
				}
		  }  
	 /*
		 * This method searching all name from multiple address book
		 * where their state name is same and put all value in a Dictionary
		 *  with key and value pair
		 *  
		 */
	 
	 public void viewPersonByState() {
		  
		 Map<String, ArrayList<String>> dicState = new HashMap<String,ArrayList<String>>();
		 
			
				for (Map.Entry<String, List<PersonInfo>> e : addressBook.entrySet())
				{
					ArrayList<String> persons = new ArrayList<String>();
					for (int i = 0; i < contact.size(); i++) {
						
						persons.add(e.getValue().get(i).getFirstName());
						dicState.put(e.getValue().get(i).getState(),persons);
						
						
					}
				}
				System.out.println(dicState);
				}
					
	
	  
	
	/*
     * This is the main method to manipulate all the methods
	 */
	public static void main(String[] args) {
		
		AddressBookMain address1 = new AddressBookMain();
		
		/*
		 * Calling this method to check duplicate and adding to the address book
		 */
		address1.checkDupicateAndAdd();
		
		/*
		 * Calling this method to edit theperson's information
		 *  to the address book
		 */
		address1.editPerson();
		/*
		 * Calling this method to search the person's name
		 * where state name is same
		 */
		address1.search();
		
		/*
		 * Calling this method to get the person's phone number
		 * where state name is same
		 */
		address1.getPersonMobileNumber();
		/*
		 *This method searching all name from multiple address book
		 * where their state name is same and put all value in a Dictionary
		 *  with key and value pair
		 */
		address1.viewPersonByState();
		
	}

}