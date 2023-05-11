public class inheritanceExample {
    class Parent {
        public static void test() {
            System.out.println("Hey");
        }
    }

    class Parent2 {
        void test() {
            System.out.println("test2");
        }
    }

    class Child extends Parent {
        public static void main(String[] args) {
            test();
        }
    }
}
