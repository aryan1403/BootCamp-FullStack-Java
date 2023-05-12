
public class ExceptionHandling {
    public static void main(String[] args) {
    	
        
        int num2 = 0; 
        int num3 = 100;

        try 
        {
            int randomFormula = num3 / num2;
            System.out.println(randomFormula);   
        } 
        catch (ArithmeticException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
