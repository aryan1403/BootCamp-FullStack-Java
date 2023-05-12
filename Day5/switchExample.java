import java.util.Scanner;

public class switchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char key = scanner.next().charAt(0);

        switch (key) {
            case 'W':
                System.out.println("Move Forward");
                break;
            case 'A':
                System.out.println("Move Left");
                break;
            case 'S':
                System.out.println("Move Backward");
                break;
            case 'D':
                System.out.println("Move Right");
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }
        scanner.close();
    }
}