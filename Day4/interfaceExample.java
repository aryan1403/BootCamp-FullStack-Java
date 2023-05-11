interface Human {
    void walk();
    void talk();
    void sing();
    void name();
    void gender();
}

interface i2 {
    void i3();
}

public class interfaceExample implements Human, i2 {
    @Override
    public void walk() {
        System.out.println("Singing");
    }

    @Override
    public void talk() {
        System.out.println("Singing");
    }

    @Override
    public void sing() {
        System.out.println("Singing");
    }

    @Override
    public void name() {
        System.out.println("Aaryan");
    }

    @Override
    public void gender() {
        System.out.println("Male");
    }

    public static void main(String[] args) {
        /* interfaceExample ie = new interfaceExample();
        ie.gender(); */
        new interfaceExample().gender();
    }

    @Override
    public void i3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'i3'");
    }
}

