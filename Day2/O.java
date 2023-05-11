class M{
    public void Mmethod()
    {
        System.out.println("INSIDE Mmethod");
    }
    


}
class N{
    public void Nmethod()
    {



        M mobj=new M();
        mobj.Mmethod();
        System.out.println("INSIDE Nmethod");



    }



}
class O{




    public void Omethod()
    {
        N nobj=new N();
        nobj.Nmethod();
        System.out.println("INSIDE Omethod");



    }
    public static void main(String [] args)
    {
        O obj=new O();
        obj.Omethod();



    }
}