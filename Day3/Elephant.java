class Animal {

public void eat()
{

System.out.println("Every animal eats something");

}

}

class Elephant extends Animal{

public void eat()
{

System.out.println("Elephant eats grass");


}

public static void main(String [] args)
{
Animal anobj1=new Animal();
anobj1.eat();
Elephant el2=new Elephant();
el2.eat();


}}