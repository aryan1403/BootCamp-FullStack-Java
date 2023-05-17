import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class streamExample {

    class Emp {
        String name;
        double salary;
        double exp;
        String role;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(20);
        list.add(23);
        list.add(45);
        list.add(1);
        list.add(99);
        list.add(88);
        list.add(7);
        list.add(13);

        // 5 4 0 -1 67
        // ASC : -1 0 4 5 67

        int[] arr = {67, 89, -8, 0, 8, 99};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // list.stream().filter(e -> (e % 2 != 0)).sorted().toArray();
        list.stream().filter(e -> (e % 2 != 0)).sorted((a, b) -> {
            if(a < b) {
                return -1;
            }
            return 0;
        }).limit(3).forEach(System.out::println);

        List<Emp> l = new ArrayList<>();

        l.stream().filter(e -> (e.salary > 10000)).forEach(System.out::println);
        l.stream().sorted((a, b) -> {
            if(a.salary < b.salary) {
                return -1;
            }
            return 0;
        });

    }
}