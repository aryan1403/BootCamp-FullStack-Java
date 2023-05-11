package First;

import first.Car;

public class Car {
	
	void name (String carname) {
		System.out.println("Car Name :" +carname);
	}

	public static void main(String[] args) {
		Car toyota = new Car();
		toyota.name("TOYOTA");

	}

}
