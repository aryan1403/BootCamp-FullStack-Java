@FunctionalInterface
interface in {
    void work();
}

interface io{
    void run();
}

interface ij{
    void hello();
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

        in obj5 = () -> System.out.println("dfdsfdsfdsfdsf");
        obj5.work();  
        
        io obj3 = () -> System.out.println("it is running");
        obj3.run();  

        ij obj4 = () -> System.out.println("Hello world!!!");
        obj4.hello(); 
    }
}