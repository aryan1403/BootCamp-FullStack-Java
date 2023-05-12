import java.util.Scanner;

public class conditionalExample {
    public static void main(String[] args) {
        // conditional
        // if - condition
        // else - none matches

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int a = sc.nextInt();
        System.out.print("Enter another number : ");
        int b = sc.nextInt();

        if(a > b) {
            // block 1
            System.out.println("yes greater than " + b);
        } else if(a < b) {
            // block 2
            System.out.println("not greater than " + b);
        } else {
            // block 3
            System.out.println("Both are Equal");
        }

        sc.close(); // best practice
    }
}