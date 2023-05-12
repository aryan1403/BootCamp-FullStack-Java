public class loopsExample {
    public static void main(String[] args) {
        // for, while, do-while

        // condition ? execute : terminate 

        // Principle - declaration / condition / execution / increment or decrement
        for(int i = 0; i < 10; i++) {
            // range : 0 - 9 = 10 times
            // System.out.println((i + 1) + " Aaryan");
        }

        // Brain Game

        // 5
        /* for (int i = 0; i < 10; i++) { // 1
            for (int j = 0; j < i; j++) { // 2 
                System.out.print("* ");
            }
            System.out.println();
        } */

        // 0 times
        // 1 times
        // 2 times
        // 3 times
        // 4 times
        // 5 times
        // ... 9th times

        // --- Breakdown ---
        // 1 sme - theory1 --> practicle1


        // Triangle

        /* for (int i = 0; i < 10; i++) {
            for (int j = 10 - i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        } */

        // Principle : condition - execution - update statement
        int i = 0;
        while(i < 10) {
            System.out.println(i);
            i++;
        }

        // Principle : execution - condition - update statement 
        // true ? run : 1 time
        int j = 0;
        do {
            // block
            System.out.println(j);
            j++;
        } while(j > 10);

    }
}
