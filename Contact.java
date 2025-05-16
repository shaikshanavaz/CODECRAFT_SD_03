package project;
	import java.util.ArrayList;
	import java.util.Scanner;

	class Contact {
	    String name;
	    String phoneNumber;
	    String emailAddress;

	    public Contact(String name, String phoneNumber, String emailAddress) {
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.emailAddress = emailAddress;
	    }

	    @Override
	    public String toString() {
	        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
	    }
	}

	 class ContactManager {
	    static ArrayList<Contact> contacts = new ArrayList<>();
	    static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int choice;
	        do {
	            System.out.println("\nContact Manager Menu:");
	            System.out.println("1. Add New Contact");
	            System.out.println("2. View Contact List");
	            System.out.println("3. Edit Existing Contact");
	            System.out.println("4. Delete Contact");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    addContact();
	                    break;
	                case 2:
	                    viewContacts();
	                    break;
	                case 3:
	                    editContact();
	                    break;
	                case 4:
	                    deleteContact();
	                    break;
	                case 0:
	                    System.out.println("Exiting Contact Manager. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 0);

	        scanner.close();
	    }

	    static void addContact() {
	        System.out.println("\nAdding New Contact:");
	        System.out.print("Enter Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter Phone Number: ");
	        String phoneNumber = scanner.nextLine();
	        System.out.print("Enter Email Address: ");
	        String emailAddress = scanner.nextLine();

	        Contact newContact = new Contact(name, phoneNumber, emailAddress);
	        contacts.add(newContact);
	        System.out.println("Contact added successfully!");
	    }

	    static void viewContacts() {
	        System.out.println("\nContact List:");
	        if (contacts.isEmpty()) {
	            System.out.println("No contacts available.");
	            return;
	        }
	        for (int i = 0; i < contacts.size(); i++) {
	            System.out.println((i + 1) + ". " + contacts.get(i));
	        }
	    }

	    static void editContact() {
	        System.out.println("\nEditing Existing Contact:");
	        if (contacts.isEmpty()) {
	            System.out.println("No contacts available to edit.");
	            return;
	        }
	        viewContacts();
	        System.out.print("Enter the number of the contact to edit: ");
	        int index = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        if (index > 0 && index <= contacts.size()) {
	            Contact contactToEdit = contacts.get(index - 1);
	            System.out.println("Current Contact Details: " + contactToEdit);

	            System.out.print("Enter new Name (leave blank to keep current): ");
	            String newName = scanner.nextLine();
	            if (!newName.isEmpty()) {
	                contactToEdit.name = newName;
	            }

	            System.out.print("Enter new Phone Number (leave blank to keep current): ");
	            String newPhoneNumber = scanner.nextLine();
	            if (!newPhoneNumber.isEmpty()) {
	                contactToEdit.phoneNumber = newPhoneNumber;
	            }

	            System.out.print("Enter new Email Address (leave blank to keep current): ");
	            String newEmailAddress = scanner.nextLine();
	            if (!newEmailAddress.isEmpty()) {
	                contactToEdit.emailAddress = newEmailAddress;
	            }

	            System.out.println("Contact updated successfully!");
	        } else {
	            System.out.println("Invalid contact number.");
	        }
	    }

	    static void deleteContact() {
	        System.out.println("\nDeleting Contact:");
	        if (contacts.isEmpty()) {
	            System.out.println("No contacts available to delete.");
	            return;
	        }
	        viewContacts();
	        System.out.print("Enter the number of the contact to delete: ");
	        int index = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        if (index > 0 && index <= contacts.size()) {
	            Contact deletedContact = contacts.remove(index - 1);
	            System.out.println("Contact '" + deletedContact.name + "' deleted successfully!");
	        } else {
	            System.out.println("Invalid contact number.");
	        }
	    }
	} 



