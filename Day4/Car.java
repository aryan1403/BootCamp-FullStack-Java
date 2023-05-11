
public class Car {
    // public - anywhere, everywhere
    // private - within the class
    // protected - package/folder

    void name(String cname) {
        System.out.println("Car Name : " + cname);
    } 

    public static void main(String[] args) {
        Car bmw = new Car();
        bmw.name("BMW");
    }
    
}