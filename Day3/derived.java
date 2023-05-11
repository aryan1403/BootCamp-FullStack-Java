
class derived  implements Aapp,Bapp{


public void Amethod()
{
System.out.println("inside Amethod call");

}
public void Bmethod()
{
System.out.println("inside Bmethod call");



}


public static void main(String [] args)
{


derived  d=new derived();

d.Amethod();
d.Bmethod();


}}