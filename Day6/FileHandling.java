import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        File f = new File("demo.txt");
        // Writing
        try {
            FileWriter fw = new FileWriter(f);
            fw.append("We are good with Java ;)");
            System.out.println("Appended Successfully");

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading
        try {
            // BufferedReader br = new BufferedReader();
            Scanner sc = new Scanner(f);

            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }   
}