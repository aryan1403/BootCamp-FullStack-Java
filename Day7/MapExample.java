import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Aaryan", 123456789);
        map.put("Sushil", 123456789);
        map.put("Jaya", 123456789);

        // System.out.println(map.get("Aaryan"));

        map.remove("Aaryan");

        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
    
}