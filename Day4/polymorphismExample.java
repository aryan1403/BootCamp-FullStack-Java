public class polymorphismExample {
    // Method Overloading
    interface Overload {
        void name();
        void name(String a);
        void name(String a, String b);
    }

    // Method Overriding
    class overriden implements Overload {

        @Override
        public void name() {
            System.out.println("Aaryan");
        }

        @Override
        public void name(String a) {
            System.out.println(a);
        }

        @Override
        public void name(String a, String b) {
            System.out.println(a + ", " + b);
        }

    }
}
