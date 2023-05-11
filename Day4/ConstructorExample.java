public class ConstructorExample {
    private String name;
    private int year;
    
    public ConstructorExample() {
        name = "Dodge Challenger Widebody Hellcat";
        year = 2023;
    }

    public static void main(String[] args) {
        ConstructorExample car = new ConstructorExample();

        System.out.println("Name: " + car.name);
        System.out.println("Year: " + car.year);
    }
}