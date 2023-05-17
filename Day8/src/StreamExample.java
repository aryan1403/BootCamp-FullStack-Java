import java.util.ArrayList;
import java.util.List;

public class StreamExample {

    class Emp {
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

        @Override
        public String toString() {
            return
                    "Name= " + name  +
                    ", Salary= " + salary +
                    ", Exp= " + exp +
                    ", Role= " + role;
        }
    }

    public static void main(String[] args) {
        StreamExample example = new StreamExample();
        example.populateEmpList();
    }

    public void populateEmpList() {
        List<Integer> list = new ArrayList<>();

        list.add(20);
        list.add(23);
        list.add(45);
        list.add(1);
        list.add(99);
        list.add(88);
        list.add(7);
        list.add(13);

        int[] arr = {67, 89, -8, 0, 8, 99};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // list.stream().filter(e -> (e % 2 != 0)).sorted().toArray();
        list.stream().filter(e -> (e % 2 != 0)).sorted().limit(3).forEach(System.out::println);

        List<Emp> l = new ArrayList<>();
        l.add(new Emp("Aaryan", 500000.0, 12.5, "Instructor"));
        l.add(new Emp("Sushil", 70000.0, 4.0, "Class Lead"));
        l.add(new Emp("Jaya", 60000.0, 1.0, "Junior Dev"));
        l.add(new Emp("Bhabesh", 80000.0, 2.0, "Junior Dev"));
        l.add(new Emp("Sanjay", 1000.0, 0.0, "Junior Dev"));


        System.out.println("\nDisplaying employees with salary more than 10000");
        l.stream().filter(e -> (e.salary > 10000)).forEach(System.out::println);


        System.out.println("\nSorting based on salary in descending order");

        l.stream().sorted((a, b) -> {
            if (a.salary > b.salary) {
                return -1;
            } else {
                return 0;
            }
        }).forEach(System.out::println);

        System.out.println("\nSorting based on Experience in ascending order");
        l.stream().sorted((a, b) -> {
            if (a.exp < b.exp) {
                return -1;
            } else {
                return 0;
            }
        }).forEach(System.out::println);

    }
}
