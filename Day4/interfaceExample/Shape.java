package Day4.interfaceExample;

interface Area {
	    double circleArea();
	    double squareArea();
	    double reactangleArea();
	}
interface Volume {
	double circleVolume();
	double rectangleVolume();
	double squareVolume();
	
}
	public class Shape implements Area, Volume {
		int rad = 5;
		int len = 10;
		int height = 2;
		int width = 20;
		double pi = 3.14;
		double area;
		double volume;
		
		@Override
		public double circleArea() {
			// TODO Auto-generated method stub
			area = pi*rad*rad;
			return area;
		}

		@Override
		public double squareArea() {
			// TODO Auto-generated method stub
			area = len*len;
			return area;
			
		}

		@Override
		public double reactangleArea() {
			// TODO Auto-generated method stub
			area = len * width;
			return area;
		}
		@Override
		public double circleVolume() {
			// TODO Auto-generated method stub
			volume = 4/3 * pi * rad * rad;
			System.out.println("The volume of circle is: ");
			return volume;
			
			
		}

		@Override
		public double rectangleVolume() {
			// TODO Auto-generated method stub
			volume = len*width*height;
			System.out.println("The volume of rectangle is: ");
			return volume;
			
		}

		@Override
		public double squareVolume() {
			// TODO Auto-generated method stub
			volume = len*len*len;
			System.out.println("The volume of square is : ");
			return volume;
			
		}
	   
		public static void main(String[] args) {
			Shape s1 = new Shape();
			System.out.println(s1.circleArea()); 
			System.out.println(s1.squareArea()); 
			System.out.println(s1.reactangleArea()); 
			System.out.println(s1.circleVolume()); 
			System.out.println(s1.squareVolume()); 
			System.out.println(s1.rectangleVolume());
			
		}

		

	}