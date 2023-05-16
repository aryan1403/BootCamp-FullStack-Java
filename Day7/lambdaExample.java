@FunctionalInterface
interface in {
    void work();
}

class inex implements in {
    @Override
    public void work() {
        System.out.println("Working");
    }
}
public class lambdaExample {
    public static void main(String[] args) {
        in obj = new inex();
        obj.work();

        in obj2 = () -> System.out.println("it is working");
        obj2.work();       
    }
}
