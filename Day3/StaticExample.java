//static context can be accessed through static method
//remain unchanged
class StaticExample{

 int x=9;
static int y=9;
public StaticExample()
{
System.out.println("Default Constructor");
x++;
y++;
System.out.println("Non static x is:"+ x);
System.out.println("Static y is:" + y);
}

public static void simpleMethod()
{
StaticExample ste=new StaticExample();

System.out.println("Inside non static method...the value of x is:"+ ste.x);
}

public static void main(String [] args)
{
StaticExample ste1=new StaticExample();
//ste1.simpleMethod();
//System.out.println("the value of x is:"+ ste1.x);
StaticExample ste2=new StaticExample();
StaticExample ste3=new StaticExample();
StaticExample ste4=new StaticExample();


}




}