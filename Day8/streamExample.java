import java.util.ArrayList;
import java.util.List;

public class streamExample {

    static class Emp {
        String name;
        double salary;
        double exp;
        String role;

        public Emp(String name, double salary, double exp, String role) {
            this.name = name;
            this.salary = salary;
            this.exp = exp;
            this.role = role;
        }
    }

    public static void main(String[] args) {
        List<Emp> l = new ArrayList<>();

        Emp emp1 = new Emp("Johnny", 150000, 5, "Developer");
        l.add(emp1);

        Emp emp2 = new Emp("Amit", 120000, 3, "Cloud Developer");
        l.add(emp2);

        Emp emp3 = new Emp("Bobby", 80000, 2, "Lawyer");
        l.add(emp3);

        Emp emp4 = new Emp("Timmy", 200000, 8, "CEO");
        l.add(emp4);

        l.stream()
                .filter(e -> e.salary > 10000)
                .forEach(emp -> System.out.println("Name: " + emp.name + ", Salary: " + emp.salary + ", Experience: " + emp.exp + ", Role: " + emp.role));
        System.out.println("------------------------------------------------------------------------------------");
        l.stream()
                .sorted((a, b) -> Double.compare(a.salary, b.salary))
                .forEach(emp -> System.out.println("Name: " + emp.name + ", Salary: " + emp.salary + ", Experience: " + emp.exp + ", Role: " + emp.role));
    }
}
