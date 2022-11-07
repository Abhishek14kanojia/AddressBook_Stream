package io.javabrain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressbook {

	Map<String, AddressbookService> addressmap = new HashMap<>();
	
	void addAddressbook() {
		System.out.println("Enter Name of Addressbook :");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		if(addressmap.containsKey(bookName)) {
			System.out.println("Enter the name : ");
		}else {
			AddressbookService addressbook = new AddressbookService();
			addressmap.put(bookName, addressbook);
		}
	}
	 public void addContact() {
	        System.out.println("Enter the name of Address book to add the contact.");
	        Scanner scanner = new Scanner(System.in);
	        String newContact = scanner.nextLine();
	        AddressbookService addressBook = addressmap.get(newContact);
	        if (addressBook == null) {
	            System.out.println("No book found");

	        } else {
	            addressmap.get(newContact).addcontact();
	        }
	    }
	 public void editContactInBook() {
	        System.out.println("Enter Name of Address Book you want to edit: ");
	        Scanner scanner = new Scanner(System.in);
	        String editBookName = scanner.next();
	        if (addressmap.containsKey(editBookName)) {
	            addressmap.get(editBookName).editContact();                              
	        } else {
	            System.out.println("AddressBook doesn't exist, Please enter correct name.");
	            editContactInBook();
	        }
	    }
	 public void deleteAddressBook() {
	        System.out.println("Enter Name of Address Book you want to delete: ");
	        Scanner sc = new Scanner(System.in);
	        String bookName = sc.next();
	        if (addressmap.containsKey(bookName)) {                                      
	            addressmap.remove(bookName);                                             
	        } else {
	            System.out.println("AddressBook doesn't exist,enter correct name.");
	            deleteAddressBook();
	        }
	    }
	 public void deleteContactInBook() {
	        System.out.println(" Name Address Book delete the contacts in it: ");
	        Scanner scanner = new Scanner(System.in);
	        String bookName = scanner.next();
	        if (addressmap.containsKey(bookName)) {
	            addressmap.get(bookName).deleteContact();
	        } else {
	            System.out.println("AddressBook doesn't exist, enter correct name.");
	            deleteContactInBook();
	        }
	    }
	 public void printBook() {
	        System.out.println("AddressBooks in program.");
	        for (String i : addressmap.keySet()) {
	            System.out.println(i);
	        }
	 }
	 public void printContactsInBook() {
	        for (String i : addressmap.keySet()) {
	            System.out.println(i);
	            System.out.println(addressmap.get(i).contacts);
	        }
	        System.out.println(" ");
	    }
	 public void searchByCity() {
		 Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the name of the City to get the persons : ");
	        String cityName = sc.next();
	        for (String i : addressmap.keySet()) {
	            List<PersonContact> arr = addressmap.get(i).contacts;
	            arr.stream().filter(person -> person.getCity().equals(cityName)).forEach(person -> System.out.println(person.getFirstName()));
	        }
	    }
	 public void searchByState() {
		 	Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the name of the State to the get persons : ");
	        String stateName = sc.next();
	        for (String i : addressmap.keySet()) {
	            List<PersonContact> arr = addressmap.get(i).contacts;
	            arr.stream().filter(person -> person.getState().equals(stateName)).forEach(person -> System.out.println(person.getFirstName()));
	        }
	 }
}
