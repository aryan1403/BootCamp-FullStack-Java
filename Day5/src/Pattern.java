
public class Pattern {
    public static void main(String[] args) {
        int row = 10;
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= 2*row-1; j++) {
            	if (j>=row+i || j<=row-i) {
            		System.out.print("0");
            	}
            	else {
            		System.out.print("1");
            	}
            }
            System.out.println();
        }
    }
}