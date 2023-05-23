import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandling {
    public static void main(String[] args) {
        File f = new File("demo.txt");
        // Writing
//        try {
//            FileWriter fw = new FileWriter(f);
//            fw.append("We are good with Java ;)\n");
//            fw.append("We are good with Java ;)\n");
//            fw.append("We are good with Java ;)\n");
//            System.out.println("Appended Successfully");
//
//            fw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

       //Reading
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
