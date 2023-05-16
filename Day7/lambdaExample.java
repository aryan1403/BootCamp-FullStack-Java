@FunctionalInterface
interface in {
    void work(String s);
}

class inex implements in {
    @Override
    public void work(String s) {
        System.out.println(s);
    }
}
public class lambdaExample {
    public static void main(String[] args) {
        in obj = new inex();
        obj.work("it is working");

        in obj2 = (s) -> System.out.println(s);
        obj2.work("hey");       
    }
}
