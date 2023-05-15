import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Emp {
    String name;
    int salary;
    int exp;

    Emp(String name, int salary, int exp) {
        this.name = name;
        this.salary = salary;
        this.exp = exp;
    }
}

public class InteractiveListProgram {
    public static void main(String[] args) {
        List<Emp> empList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add to list");
            System.out.println("2. Remove from list");
            System.out.println("3. Update the list");
            System.out.println("4. Display the whole list");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addToList(empList, scanner);
                    break;
                case 2:
                    removeFromList(empList, scanner);
                    break;
                case 3:
                    updateList(empList, scanner);
                    break;
                case 4:
                    displayList(empList);
                    break;
                case 0:
                    System.out.println("Exiting the program.See ya!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 0);
    }

    private static void addToList(List<Emp> empList, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter salary (in round figure): ");
        int salary = scanner.nextInt();
        System.out.print("Enter experience (in months): ");
        int exp = scanner.nextInt();
        empList.add(new Emp(name, salary, exp));
        System.out.println("Employee has been added to the list.");
    }

    private static void removeFromList(List<Emp> empList, Scanner scanner) {
        System.out.print("Enter the index of the employee to remove: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < empList.size()) {
            Emp removedEmp = empList.remove(index);
            System.out.println("Employee has been removed from the list: " + removedEmp.name);
        } else {
            System.out.println("Invalid index. No changes have been made.");
        }
    }

    private static void updateList(List<Emp> empList, Scanner scanner) {
        System.out.print("Enter the index number of the employee you want to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (index >= 0 && index < empList.size()) {
            Emp emp = empList.get(index);
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new salary: ");
            int salary = scanner.nextInt();
            System.out.print("Enter new experience: ");
            int exp = scanner.nextInt();
            emp.name = name;
            emp.salary = salary;
            emp.exp = exp;
            System.out.println("Employee updated.");
        } else {
            System.out.println("Invalid index. No changes have been made.");
        }
    }

    private static void displayList(List<Emp> empList) {
        if (empList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Employee list:");
            for (int i = 0; i < empList.size(); i++) {
                Emp emp = empList.get(i);
                System.out.println("Index: " + i + ", Name: " + emp.name + ", Salary: " + emp.salary + ", Exp: " + emp.exp);
            }
        }
    }
}
