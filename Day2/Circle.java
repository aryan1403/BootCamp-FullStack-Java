class Circle {

    private double radius = 1.0;

    private String color = "red";


    public Circle()

    {
        System.out.println("Inside Default Constructor");

    }

    public Circle(double radius)

    {
        this.radius = radius;
    }



    public double getRadius()

    {
        return this.radius;
    }



    public double getArea()

    {


        double Area = 3.14 * radius * radius;


        return Area;
    }



    public static void main(String[] args)

    {
        Circle cobj1 = new Circle();

        Circle cobj2 = new Circle(2.0);



        System.out.println(cobj2.getRadius());

        System.out.println(cobj2.getArea());


    }


}
