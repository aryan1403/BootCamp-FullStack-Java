interface Customer1 {
	void play();
	void sing();
	void walk();
	
 }
	interface Customer2{
		void read();
		void watch();
		void eat();
	}
	


public class TestCustomer implements Customer1,Customer2{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("football");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("pop");
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("jumping");
		
	}
	

	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println("story");
	}

	@Override
	public void watch() {
		// TODO Auto-generated method stub
		System.out.println("movie");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("pizza");
	}
		
		
	public static void main(String[] args) {
		new TestCustomer().play();
		new TestCustomer().walk();
		new TestCustomer().sing();
		new TestCustomer().read();
		new TestCustomer().eat();
		new TestCustomer().watch();
		
	}
		
		
	}