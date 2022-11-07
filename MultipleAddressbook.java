package io.javabrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	 public void displayPeopleByRegion(HashMap<String, ArrayList<PersonContact>> addressBookMap) {
	        List<PersonContact> contacts;
	        for (String name : addressBookMap.keySet()) {
	            System.out.println("People residing in: " + name);
	            contacts = addressBookMap.get(name);
	            for (PersonContact contact : contacts) {
	                System.out.println(contact);  
	            }
	        }
	 }
	public void countPeopleByRegion(HashMap<String, ArrayList<PersonContact>> personbycity) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the region :");
	        String regionName = sc.next();
	        long countPeople = listToDisplay.values().stream()
	                .map(region -> region.stream().filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
	                .count();

	        System.out.println("Number of People residing in " + regionName + " are: " + countPeople + "\n");
		}
	
	 public void sortAddressBook() {
	        for (String i : addressmap.keySet()) {
	            Map<String, PersonContact> con = (Map<String, PersonContact>) addressmap.get(i).contacts;

	            List<PersonContact> sorted = con.values().stream().sorted((firstperson, secondperson) ->
	                    firstperson.getFirstName().compareTo(secondperson.getFirstName())).collect(Collectors.toList());

	            System.out.println("------ Sorted Address Book ------");
	            Iterator iterator = (Iterator) sorted.iterator();
	            while (((java.util.Iterator<String>) iterator).hasNext()) {
	                System.out.println(iterator.next());
	                System.out.println();
	            }
	        }
	 }
}



