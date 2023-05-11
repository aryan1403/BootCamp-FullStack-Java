
    interface overloading{
        void play();
        void watch(String movie, String drama);
        void eat(String pizza, String momo, String burger);
    }
    class Polymorphism implements overloading{

        @Override
        public void play() {
            // TODO Auto-generated method stub
            System.out.println("football");
            
        }

        @Override
        public void watch(String movie, String drama) {
            // TODO Auto-generated method stub
            System.out.println("you can watch  "+movie +"   "  +    drama);
            
        }

        @Override
         public void eat(String pizza, String momo, String burger) {
            // TODO Auto-generated method stub
            
            System.out.println("you can eat  "+pizza+"    " + momo +"   "+ burger);
        }
        public static void main(String[] args) {
            Polymorphism p1 = new Polymorphism();
            p1.play();
            p1.watch("Nepali","English");
            p1.eat("Mac-PIzza","Buff-momo","chicken-burger");
           
    
        }
        }

