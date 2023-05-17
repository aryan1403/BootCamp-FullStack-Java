public class Addition {
    // constructor
    public Addition() {
        System.out.println("Adding nothing here");
    }
    public Addition(int a, int b) {
        System.out.println("Sum is: " + (a+b));
    }
    public Addition(int a, int b, int c) {
        System.out.println("Sum is: " + (a+b+c));
    }

    public static void main(String[] args) {
    new Addition();
    new Addition(1,2);
    new Addition(1,2,3);
    }
}