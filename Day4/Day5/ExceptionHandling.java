package Day5;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        
    
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the first number");
    int a=sc.nextInt();
    System.out.println("enter the second number");
    int b=sc.nextInt();
    try{
        System.out.println(+(a/b));
    } catch(Exception e){
        System.out.println(e.getMessage());

    }
    sc.close();
    

    
}



}
