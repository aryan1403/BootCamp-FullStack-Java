//static context can be accessed through static method
//remain unchanged
class StaticExample{

 int x=9;
public StaticExample()
{
System.out.println("Default Constructor");

}

public static void simpleMethod()
{
StaticExample ste=new StaticExample();

System.out.println("Inside non static method...the value of x is:"+ ste.x);
}

public static void main(String [] args)
{
StaticExample ste1=new StaticExample();
ste1.simpleMethod();
System.out.println("the value of x is:"+ ste1.x);
}




}