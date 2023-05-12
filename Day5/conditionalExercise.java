import java.util.Scanner;

public class conditionalExercise {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        System.out.print("Enter your Age: ");
        final int age = s1.nextInt();

        if (age >= 18) {
            System.out.println("Great! you are eligible to vote since you are 18 or older");
        } else {
            System.out.println("Sorry! you are not old enough, you must be at least 18");
        }
        
        s1.close();
    }
}
