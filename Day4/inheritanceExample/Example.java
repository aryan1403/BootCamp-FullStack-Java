package inheritanceExample;



public class Example {
	class Pets {
	public static void haslegs() {
		System.out.println("Most pets have 4 legs");
	}
 
}
class Fish extends Pets{
	public static void haslegs() {
		System.out.println("Fish has no legs");
	}
	
}
class child extends Pets {
	public static void main(String[] args) {
		haslegs();
		
	}
}
}