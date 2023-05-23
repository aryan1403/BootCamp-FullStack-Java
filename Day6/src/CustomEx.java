import java.util.Scanner;

class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

public class CustomEx {
    public static void main(String[] args) throws MyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("This program finds square of even numbers");
        System.out.println("Please enter a even number. ");
        int num1 = sc.nextInt();

        sc.close();
        
        if (num1 % 2 != 0) {
            throw new MyException("You entered an odd number");
        }else {
        	System.out.println("The square of given number is :"+num1*num1);
        }
    }
}
