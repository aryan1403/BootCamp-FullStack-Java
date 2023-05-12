import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        Float a = sc.nextFloat();
        System.out.print("Enter another number : ");
        Float b = sc.nextFloat();

        // Exception Handling
        try {
            System.out.println("a / b : " + (a / b));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}