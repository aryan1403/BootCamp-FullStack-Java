class Constructor{
    
            
    public static void main(String[] args) {
        Employee e1=new Employee();
        e1.dispaly();
    }
}
 
 class Employee {
    int age;
    String name;
    int id;

    Employee(){
        age=12;
        name="jay";
        id=123;
    }
    /**
     * 
     */
    void dispaly(){
        System.out.println(+age);
        System.out.println(name);
        System.out.println(+id);


    }

     
    
}
