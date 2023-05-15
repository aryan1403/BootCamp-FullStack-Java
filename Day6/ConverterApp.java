class CustomException extends Exception {
    public CustomException(String msg) {
       super(msg); 
    }
}

class MileToKmConverter {
    public double convert(double miles) throws CustomException {
        if (miles < 0) {
            throw new CustomException("Invalid input: Miles cannot be negative.");
        }

        return miles * 1.6;
    }
}

public class ConverterApp {
    public static void main(String[] args) {
        MileToKmConverter converter = new MileToKmConverter();

        try {
            double miles = 7;
            double kilometers = converter.convert(miles);
            System.out.println(miles + " miles = " + kilometers + " kilometers");
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
