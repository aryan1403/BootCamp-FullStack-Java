import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhonebookPrototype {
        Map<String, Integer> phonebook;
        Scanner scanner;
    
        public PhonebookPrototype() {
            phonebook = new HashMap<>();
            scanner = new Scanner(System.in);
        }
    public void run(){
        boolean running = true;

        while(running){
            System.out.println("PhoneBook Prototype");
            System.out.println("1. Add contact");
            System.out.println("2. Update contact");
            System.out.println("3. Delete contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    displayAllContacts();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Your choice is invalid please try again: ");
            }
                System.out.println();
        }
            System.out.println("Exiting... See ya!!!");
            scanner.close();
        }
        void addContact(){
            System.out.print("Enter the contact name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the contact number: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            phonebook.put(name, number);
            System.out.println("Contact has been added successfully.");
        }

        void updateContact(){
            System.out.print("Enter the contact name you want to update: ");
            String name = scanner.nextLine();

            if(phonebook.containsKey(name)){
                System.out.print("Enter the new contact number: ");
                int number = scanner.nextInt();
                scanner.nextLine();
                phonebook.put(name, number);
                System.out.println("Contact has been updated successfully");
            } else {
                System.out.println("Contact doesn't exist");
            }
            }
        void deleteContact(){
            System.out.print("Enter the contact  name to delete: ");
            String name = scanner.nextLine();

            if(phonebook.containsKey(name)){
                phonebook.remove(name);
                System.out.println("Contact has been deleted");
            }else{
                System.out.println("Contact doesn't exist");
            }
        }
        void displayAllContacts(){
            if (phonebook.isEmpty()){
                    System.out.println("Phonebook is empty.");
            }else{
                System.out.println("All Contacts: ");
                for (Map.Entry<String, Integer> entry : phonebook.entrySet()) {
                    System.out.println("Name: " + entry.getKey() + ", Number: " + entry.getValue());
                }
            }
        }
        public static void main(String[] args) {
            PhonebookPrototype phonebookPrototype = new PhonebookPrototype();
            phonebookPrototype.run();
        }
    }
