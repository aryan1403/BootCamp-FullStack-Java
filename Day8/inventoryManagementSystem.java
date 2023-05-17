import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class inventoryManagementSystem {
    static class Item {
        String name;
        int quantity;
        double price;

        public Item(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }

    List<Item> inventory;
    Scanner scanner;

    public inventoryManagementSystem() {
        inventory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add item");
            System.out.println("2. Update item");
            System.out.println("3. Remove item");
            System.out.println("4. Filter items");
            System.out.println("5. Sort items");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    filterItems();
                    break;
                case 5:
                    sortItems();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        System.out.println("Exiting... Goodbye!");
        scanner.close();
    }

    void addItem() {
        System.out.print("Enter the item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the item quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter the item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        inventory.add(new Item(name, quantity, price));
        System.out.println("Item has been added successfully.");
    }

    void updateItem() {
        System.out.print("Enter the item name you want to update: ");
        String name = scanner.nextLine();

        inventory.stream()
                .filter(item -> item.name.equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(item -> {
                    System.out.print("Enter the new quantity: ");
                    int quantity = scanner.nextInt();
                    item.quantity = quantity;
                    System.out.print("Enter the new price: ");
                    double price = scanner.nextDouble();
                    item.price = price;
                    scanner.nextLine();
                    System.out.println("Item has been updated successfully.");
                });

        System.out.println("Item not found.");
    }

    void removeItem() {
        System.out.print("Enter the item name to remove: ");
        String name = scanner.nextLine();

        inventory.removeIf(item -> item.name.equalsIgnoreCase(name));

        System.out.println("Item has been removed.");
    }

    void filterItems() {
        System.out.print("Enter the minimum quantity: ");
        int minQuantity = scanner.nextInt();
        System.out.print("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();

        List<Item> filteredItems = inventory.stream()
                .filter(item -> item.quantity >= minQuantity && item.price >= minPrice)
                .collect(Collectors.toList());

        System.out.println("Filtered Items:");
        filteredItems.forEach(item -> System.out.println("Name: " + item.name + ", Quantity: " + item.quantity + ", Price: " + item.price));
    }

    void sortItems() {
        System.out.println("Sort items by:");
        System.out.println("1. Name");
        System.out.println("2. Quantity");
        System.out.println("3. Price");
        System.out.print("Please enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                inventory = inventory.stream()
                        .sorted((item1, item2) -> item1.name.compareToIgnoreCase(item2.name))
                        .collect(Collectors.toList());
                break;
            case 2:
                inventory = inventory.stream()
                        .sorted((item1, item2) -> Integer.compare(item1.quantity, item2.quantity))
                        .collect(Collectors.toList());
                break;
            case 3:
                inventory = inventory.stream()
                        .sorted((item1, item2) -> Double.compare(item1.price, item2.price))
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Invalid choice. Items will not be sorted.");
                return;
        }

        System.out.println("Sorted Items:");
        inventory.forEach(item -> System.out.println("Name: " + item.name + ", Quantity: " + item.quantity + ", Price: " + item.price));
    }

    public static void main(String[] args) {
        inventoryManagementSystem inventoryManagementSystem = new inventoryManagementSystem();
        inventoryManagementSystem.run();
    }
}
