package First;


interface House {
    void bedroom();
    void livingroom(); 
    void bathroom();
    void kitchen();
    void basement();
}

interface I2 { 
    void i3();
}

public class InterfaceExample implements House, I2 { 

    public static void main(String[] args) {
        System.out.println("Here are the purpose of each rooms in the house:");
        System.out.println("In the basement we have a");
        new InterfaceExample().basement();
        System.out.println("In the kitchen we cook our");
        new InterfaceExample().kitchen();
        System.out.println("One of many purpose of bathroom is to take a");
        new InterfaceExample().bathroom();
        System.out.println("Favourite place to");
        new InterfaceExample().bedroom();
        System.out.println("To chill and watch");
        new InterfaceExample().livingroom();
    }

    @Override
    public void i3() {
        throw new UnsupportedOperationException("Unimplemented method 'i3'");
    }

    @Override
    public void bedroom() {
        System.out.println("sleep");
    }

    @Override
    public void livingroom() {
        System.out.println("TV");
    }

    @Override
    public void bathroom() {
        System.out.println("shower");
    }

    @Override
    public void kitchen() {
        System.out.println("food");
    }

    @Override
    public void basement() {
        System.out.println("gym");
    }


}
