import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Emp {
    String name;
    double salary;
    double exp;

    public Emp(String name, double salary, double exp) {
        this.name = name;
        this.salary = salary;
        this.exp = exp;
    }
}

public class ListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Emp> l = new ArrayList<>();
        l.add(new Emp("Aaryan", 100000, 12.5));
        l.add(new Emp("Sushil", 500000, 17.5));
        l.add(new Emp("Jaya", 800000, 18));

        while (true) {
            System.out.println("Enter your choice:\n1. Add Employee\n2. Display Employees\n3. Update Employee\n4. Delete Employee\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter employee name: ");
                    String name = sc.next();

                    System.out.println("Enter employee salary: ");
                    double salary = sc.nextDouble();

                    System.out.println("Enter employee experience: ");
                    double exp = sc.nextDouble();

                    l.add(new Emp(name, salary, exp));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                        System.out.println("Employee List:");
                        for (Emp emp : l) {
                            System.out.println("Name : " + emp.name + ", Salary : " + emp.salary + ", Exp : " + emp.exp);
                        }
                    
                    break;

                case 3:
                    
                        System.out.println("Enter the index of the employee you want to update:");
                        int index = sc.nextInt();

                        if (index >= l.size()) {
                            System.out.println("Invalid index!");
                        } else {
                            System.out.println("Enter new employee name: ");
                            l.get(index).name = sc.next();

                            System.out.println("Enter new employee salary: ");
                            l.get(index).salary = sc.nextDouble();

                            System.out.println("Enter new employee experience: ");
                            l.get(index).exp = sc.nextDouble();

                            System.out.println("Employee updated successfully!");
                        }
                    
                    break;

                case 4:
                        System.out.println("Enter the index of the employee you want to delete:");
                        int index1 = sc.nextInt();

                        if (index1>= l.size()) {
                            System.out.println("Invalid index!");
                        } else {
                            l.remove(index1);
                            System.out.println("Employee deleted successfully!");
                        }
                    
                    break;

                case 5:
                    System.out.println("Exiting the program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
