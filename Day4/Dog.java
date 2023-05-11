

public class Dog{
    // public - anywhere, everywhere
    // private - within the class
    // protected - package/folder

    void name(String dname) {
        System.out.println("Dog Name : " + dname);
    } 
    void price(int dprice) {
        System.out.println("Dog Name : " + dprice);
    } 
    public static void main(String[] args) {
        Dog puppy = new Dog();
        puppy.name("German shepard");
        puppy.price(100);
    }
    
}