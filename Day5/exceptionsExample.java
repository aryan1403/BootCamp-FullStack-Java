import java.util.Scanner;

public class exceptionsExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int a = sc.nextInt();
        System.out.print("Enter another number : ");
        int b = sc.nextInt();

        // Exception Handling
        try {
            System.out.println("a / b : " + (a / b));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
