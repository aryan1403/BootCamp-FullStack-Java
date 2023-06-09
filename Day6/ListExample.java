import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



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
public class ListExample {
    public static void main(String[] args) {
        // no size

        List<Integer> list = new ArrayList<>();
        list.add(10); // 0
        list.add(34); // 1
        list.add(56); // 2

        // list.remove(list.indexOf(56));

        // System.out.println(list);
        // iterate over the list

        // 1. for loop
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();

        // 2. while loop
        int index = 0;
        while (index < list.size()) {
            System.out.print(list.get(index) + " ");
            index++;
        }

        System.out.println();

        // 3. for each loop
        for (int i : list) {
            System.out.print(i + " ");
        }

        System.out.println();

        // 4. Iterator
        Iterator<Integer> it = list.iterator(); 
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();

        // 5. foreach method
        list.forEach(a -> System.out.print(a + " "));

        System.out.println();

        // 6. advance print line (shortest)
        list.forEach(System.out::println);

        List<Emp> l = new ArrayList<>();

        l.add(new Emp("Aaryan", 100000, 12.5));
        l.add(new Emp("Sushil", 500000, 17.5));
        l.add(new Emp("Jaya", 800000, 18));

        l.forEach(emp -> System.out.println("Name : " + emp.name + ", Salary : " + emp.salary + ", Exp : " + emp.exp));

    }
}
