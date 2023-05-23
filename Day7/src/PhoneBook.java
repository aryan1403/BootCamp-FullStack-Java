import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Integer> phoneBook = new HashMap<>();
        phoneBook.put("Aaryan", 123456789);
        phoneBook.put("Sushil", 123456789);
        phoneBook.put("Jaya", 123456789);

        Scanner sc = new Scanner(System.in);
        String choice;

        while (true) {
        	 System.out.print(
        		        "\nPhone Book Menu:\n" +
        		        "\n1. Add Contact  " +
        		        "\n2. Update Contact  " +
        		        "\n3. Delete Contact  " +
        		        "\n4. List All Contacts  " +
        		        "\n5. Exit\n" +
        		        "\nEnter your choice (1-5): "
        		    );
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    int number = sc.nextInt();
                    sc.nextLine(); 
                    phoneBook.put(name, number);
                    System.out.println("Contact added successfully.");
                    break;

                case "2":
                    System.out.print("Enter name to update: ");
                    String updateName = sc.nextLine();
                    Integer phoneNumber = phoneBook.get(updateName);
                    if (phoneNumber != null) {
                        System.out.print("Enter new phone number: ");
                        int updatedNumber = sc.nextInt();
                        sc.nextLine();
                        phoneBook.put(updateName, updatedNumber);
                        System.out.println("Contact updated successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;


                case "3":
                    System.out.print("Enter the name to delete: ");
                    String delName = sc.nextLine();
                    Integer deletedNumber = phoneBook.remove(delName);
                    if (deletedNumber != null) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;


                case "4":
                    System.out.println("\nPhone Book Contacts:");
                    phoneBook.entrySet().forEach(contact -> {
                        String contactName = contact.getKey();
                        int contactNumber = contact.getValue();
                        System.out.println(contactName + ": " + contactNumber);
                    });
                    break;


                case "5":
                    System.out.println("Exiting Phone Book.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Choose 1 to 5 only!!!");
                    break;
            }
        }
    }
}
