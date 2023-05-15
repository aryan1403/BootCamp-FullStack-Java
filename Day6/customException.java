import java.util.Scanner;

class MyException extends Exception {
    public MyException(String msg) {
        // call the parent class constructor
        super(msg);
    }
}

public class customException {
    public static void main(String[] args) throws MyException {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        sc.close();
        // username letters > 5
        if(username.length() < 5) {
            throw new MyException("Username should be atleast 5 characters");
        } else {
            System.out.println(username);
        }

    }
}