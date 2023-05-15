import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListExample {
    public static void main(String[] args) {

        List<Float> li = new ArrayList<>();
        li.add(10.0f); 
        li.add(3.14f); 
        li.add(56.01f); 
        li.add(26.01f); 
        li.add(10.01f); 

        for (int i = 0; i < li.size(); i++) {
            System.out.print(li.get(i) + " ");
        }

        System.out.println();
        li.remove(0);

        // 2. while loop
        int index = 0;
        while (index < li.size()) {
            System.out.print(li.get(index) + " ");
            index++;
        }

        System.out.println();
        li.add(2.0f);
        // 3. for each loop
        for (float i : li) {
            System.out.print(i + " ");
        }

        System.out.println();
        li.remove(li.indexOf(2.0f));
        // 4. Iterator
        Iterator<Float> it = li.iterator(); 
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
        li.add(0, 10.0f);
        // 5. foreach method
        li.forEach(a -> System.out.print(a + " "));

        System.out.println();

        // 6. advance print line (shortest)
        li.forEach(System.out::println);
    }
}