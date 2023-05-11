
    interface Overload {
        void name();
        void name(String x);
        void name(String x, String y);
    }

    public class PolymorphismExample implements Overload {

        @Override
        public void name() {
            System.out.println("Welcome to my program");
        }

        @Override
        public void name(String y) {
            System.out.println(y);
        }

        @Override
        public void name(String x, String y) {
            System.out.println(x + ", " + y);
        }
        public static void main(String[] args) {
            new PolymorphismExample().name();
        }
    }
