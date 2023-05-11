//one name many forms
//Polymorphism is implemented in 2 ways 1. static binding and 2. dynamic binding

//static binding means method overloading same method name but different argument in the same class
//dynamic binding means method overriding same method name same argument in derived class.
class PolyDemo{


public int CalculateArea(int l,int b)
{
return l*b;
}

public double CalculateArea(float radius)
{
return 3.14*radius*radius;
}
public int CalculateArea(int side)
{

return side * side;

}
public static void main(String [] args)
{

PolyDemo pd1=new PolyDemo();
System.out.println("The area of rectangle is:" +pd1.CalculateArea(2,4));
System.out.println("The area of Circle is :" +pd1.CalculateArea(2.2f));

System.out.println("The area of Square is: "+ pd1.CalculateArea(5));



}}