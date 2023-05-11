package PolymorphismExample;

public class PolyExample {

    interface Overload {
        void sum(int a, int b);
        void product (int a, int b);

    }

     class Test implements Overload {


        @Override
        public void sum(int a, int b) {
            System.out.println("The sum of given numbers is :"+(a+b));
        }

        @Override
        public void product(int a, int b) {
            System.out.println("The product of given numbers is :"+(a*b));

        }
    }

    public static void main(String[] args) {
        PolyExample p1 = new PolyExample();
        Test t1 = p1.new Test();
        t1.sum(5,10);
        t1.product(5,6);


    }
}
