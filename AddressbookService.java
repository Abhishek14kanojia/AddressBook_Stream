package io.javabrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner; 

public class AddressbookService {

	public static final HashMap<String, ArrayList<PersonContact>> personByCity = null;
	public static HashMap<String, ArrayList<PersonContact>> personByState;
	Scanner sc = new Scanner(System.in);
	String name;
	
	List<PersonContact> contacts = new ArrayList<>();
	Map<String, AddressbookService> addressbookmap = new HashMap<>();
	PersonContact person = new PersonContact();
	
	
	void checkduplicate() {
		System.out.println("Enter first Name :");
		name = sc.next();
		for(PersonContact i : contacts) {
			if(i.getFirstName().equals(name)) {
			System.out.println("Exists");	
			}return;
		}addPerson();
	}
	void addcontact() {
		System.out.println("Enter the Name : ");
		int number = sc.nextInt();
		for(int i = 0; i < number; i++) {
			System.out.println("Enter Details: ");
			checkduplicate();
		}
	}


	private void addPerson() {
		PersonContact person = new PersonContact();
		Scanner scan = new Scanner(System.in);
        String firstName = name;

        System.out.print("enter last name: ");
        String lastName = scan.next();

        System.out.print("enter address: ");
        String address = scan.next();

        System.out.print("enter city: ");
        String city = scan.next();

        System.out.print("enter state: ");
        String state = scan.next();

        System.out.print(" Please enter the zip: ");
        int zip = scan.nextInt();

        System.out.print("enter phone number: ");
        Long phoneNumber = scan.nextLong();

        System.out.print(" enter email: ");
        String email = scan.next();

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(phoneNumber);
        person.setEmail(email);
        person.setCity(city);
        person.setState(state);
        person.setZip(zip);
        contacts.add(person);
		
	}
	
	 public PersonContact findContact() {
	        System.out.println("\n Enter the first name of the contact to edit: ");
	        String name = sc.next();
	        int duplicate = 0;
	        PersonContact temp = null;
	        for (PersonContact contact : contacts) {
	            if (contact.getFirstName().equals(name)) {
	                duplicate++;
	                temp = contact;
	            }
	        }
	        if (duplicate == 1) {
	            return temp;

	        } else if (duplicate > 1) {
	            System.out.print(" There are multiple contacts with given name.\n Please enter their email id: ");
	            String email = sc.next();
	            for (PersonContact contact : contacts) {
	                if (contact.getFirstName().equals(name) && contact.getEmail().equals(email)) {
	                    return contact;
	                }
	            }
	        } else {
	            System.out.println("No contact with the given first name. Please enter the correct first name");
	            findContact();
	        }
	        return temp;
	    }
	
	 public void editContact() {

	        PersonContact contact = findContact();

	        System.out.println("Enter your choice to edit: " + "\n 1.Edit first name" + "\n 2.Edit last name"
	                + "\n 3.Edit address" + "\n 4.Edit city" + "\n 5.Edit state" + "\n 6.Edit zipcode"
	                + "\n 7.Edit phone number" + "\n 8.Edit email");
	 
	        int choice = sc.nextInt(); 
	        switch (choice) {
            case 1:
                System.out.println("Enter new first name");
                String newFirstName = sc.next();
                contact.setFirstName(newFirstName);
                System.out.println("new first name updated");

                break;
            case 2:
                System.out.println("Enter new last name");
                String newLastName = sc.next();
                contact.setLastName(newLastName);
                System.out.println("new last name updated");

                break;
            case 3:
                System.out.println("Enter new address");
                String newAddress = sc.next();
                contact.setAddress(newAddress);
                System.out.println("new new address updated");

                break;
            case 4:
                System.out.println("Enter new city");
                String newCity = sc.next();
                contact.setCity(newCity);
                System.out.println("new city updated");

                break;
            case 5:
                System.out.println("Enter new state");
                String newState = sc.next();
                contact.setState(newState);
                System.out.println("new state updated");

                break;
            case 6:
                System.out.println("Enter new zip code");
                int newZipCode = sc.nextInt();
                contact.setZip(newZipCode);
                System.out.println("new zip code updated");
                break;

            case 7:
                System.out.println("Enter new phone number");
                long newPhoneNumber = sc.nextLong();
                contact.setPhoneNumber(newPhoneNumber);
                System.out.println("new phone number updated");

                break;

            case 8:
                System.out.println("Enter new email");
                String newEmail = sc.next();
                contact.setEmail(newEmail);
                System.out.println("new email updated");

                break;

            default:
                System.out.println("Please enter a number between 1 to 8 only...");
                break;
        }
        System.out.println("The contact after editing is : " + contact);
  
	 }
	 public void displayContact() {
	        System.out.println(contacts);
	        
	    }public void deleteContact() {
	       PersonContact contact = findContact();
	        if (contact == null) {
	            System.out.println("No contact found with the given name");
	            return;
	        }
	        contacts.remove(contact);
	        System.out.println("The contact has been deleted from the Address Book");
	    }
	    public void addPersonToCity(PersonContact contact) {
	        Map<String, AddressbookService> personByCity;
			if (personByCity.containsKey(contact.getCity())) {
	            personByCity.get(contact.getCity()).add(contact);
	        } else {
	            ArrayList<PersonContact> cityList = new ArrayList<>();
	            cityList.add(contact);
	            personByCity.put(contact.getCity(), cityList);
	        }
	    }
	    public void addPersonToState(PersonContact contact) {
	        List<PersonContact> personByState;
			if (personByState.containsKey(contact.getState())) {
	            personByState.get(contact.getState()).add(contact);
	        } else {
	            ArrayList<PersonContact> stateList = new ArrayList<ContactPerson>();
	            stateList.add(contact);
	            personByState.put(contact.getState(), stateList);
	        }   
	    } 
}
