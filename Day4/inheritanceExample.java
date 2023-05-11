
    class inheritanceExample {
        public void test() {
            System.out.println("Hey");
        }
    }


    class Child extends inheritanceExample {
        
        public static void main(String[] args) {
            new Child().test();
        }
    }

