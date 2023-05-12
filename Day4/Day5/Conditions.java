package Day5;

import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
 System.out.println("enter your age");
 int age=sc.nextInt();
 if(age>18){
    System.out.println("you can are not eliagible for vote");
 }
 else if (age ==18){
    System.out.println("you are just eliagible for vote");
 }
 else {
    System.out.println("you are perfectly eliagible for vote");
 }
 sc.close();
    }
    
}
