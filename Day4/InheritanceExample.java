package First;

    public class InheritanceExample {
        public void hello() {
            System.out.println("Hello World!");
        }
    

	class Child extends InheritanceExample {
	    
	}
	public static void main(String[] args) {
	    new InheritanceExample().hello();
	}
   }
