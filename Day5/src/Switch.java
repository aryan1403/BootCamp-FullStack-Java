
import java.util.Scanner;
public class Switch {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter current day");
		String day = sc.nextLine().toLowerCase();
		sc.close();
		
		switch(day)
		{
			case "sunday":
				System.out.println("Its a weekend");
				break;
			case "monday":
				System.out.println("Its a weekday");
				break;
			case "tuesday":
				System.out.println("Its a weekday");
				break;
			case "wednesday":
				System.out.println("Its a weekday");
				break;
			case "thursday":
				System.out.println("Its a weekday");
				break;
			case "friday":
				System.out.println("Its a weekday");
				break;
			case "saturday":
				System.out.println("Its a weekend");
				break;
			default:
				System.out.println("Not a valid day");		
			
		}
		
		}
	}


