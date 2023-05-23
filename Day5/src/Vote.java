
import java.util.Scanner;
public class Vote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your age");
        int age = sc.nextInt();

        if (age>=18){
            System.out.println("You are eligible to vote");
        }
        else{
            System.out.println("Come back when you are 18");
        }
    }
}
