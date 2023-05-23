import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
    public String toString() {
        return 
                "Id=" + id  +
                ", Name= " + name  +
                ", Price= " + price +
                ", Quantity= " + quantity
                ;
    }
}

public class ManageInventory {
    private List<Product> inventory = new ArrayList<>();
    

    public ManageInventory() {
        addProduct(new Product("10003", "Iphone 14", 899.00, 30));
        addProduct(new Product("10001", "Iphone 12", 699.99, 15));
        addProduct(new Product("10002", "Iphone 13", 799.00, 20));
        addProduct(new Product("10005", "Iphone 14 pro max", 1099.00, 200));
        addProduct(new Product("10004", "Iphone 14 pro", 999.00, 80));
        
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }
    
    public void displayMenu() {
        System.out.println("--- Store Inventory Management ---");
        System.out.println("1. Add a product");
        System.out.println("2. Remove a product");
        System.out.println("3. Update product quantity");
        System.out.println("4. Filter products by price range");
        System.out.println("5. Sort products by price");
        System.out.println("6. Print inventory");
        System.out.println("0. Exit");
        System.out.println("----------------------------------------");
    }
    Scanner sc = new Scanner(System.in);
    public void manage() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
            
                case 1:
                	 System.out.print("Enter the product ID: ");
                     String id = sc.nextLine();

                     System.out.print("Enter the product name: ");
                     String name = sc.nextLine();

                     System.out.print("Enter the product price: ");
                     double price = sc.nextDouble();

                     System.out.print("Enter the product quantity: ");
                     int quantity = sc.nextInt();
                     sc.nextLine(); 

                     Product product = new Product(id, name, price, quantity);
                     addProduct(product);
                     System.out.println("Product added successfully.");
                    break;
                    
                case 2:
                    System.out.print("Enter the product ID to remove: ");
                    String productId = sc.nextLine();

                    boolean productRemoved = false;
                    for (Product p : inventory) {
                        if (p.getId().equals(productId)) {
                            inventory.remove(p);
                            productRemoved = true;
                            break;
                        }
                    }

                    if (productRemoved) {
                        System.out.println("Product removed successfully.");
                    } else {
                        System.out.println("Product not found in the inventory.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter the product ID to update quantity: ");
                    String pd1 = sc.nextLine();

                    System.out.print("Enter the new quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine(); 

                    for (Product p : inventory) {
                        if (p.getId().equals(pd1)) {
                            p.setQuantity(newQuantity);
                            break;
                        }
                    }
                    System.out.println("Product quantity updated successfully.");
                    break;

                
                case 4:
                    System.out.print("Enter the minimum price: ");
                    double minPrice = sc.nextDouble();
                    sc.nextLine(); 

                    System.out.print("Enter the maximum price: ");
                    double maxPrice = sc.nextDouble();
                    sc.nextLine(); 

                    List<Product> filteredProducts = new ArrayList<>();
                    for (Product product2 : inventory) {
                        if (product2.getPrice() >= minPrice && product2.getPrice() <= maxPrice) {
                            filteredProducts.add(product2);
                        }
                    }

                    if (filteredProducts.isEmpty()) {
                        System.out.println("No products found within the specified price range.");
                    } else {
                        System.out.println("Products within the specified price range:");
                        for (Product product2 : filteredProducts) {
                            System.out.println(product2);
                        }
                    }
                    break;

                case 5:
                	Collections.sort(inventory, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
                	inventory.forEach(System.out::println);
                    break;
                case 6:
                	inventory.forEach(System.out::println);
                    break;
                case 0:
                   return;
                   
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        ManageInventory mi = new ManageInventory();   
        mi.manage();
    }
}