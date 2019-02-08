import java.util.HashMap;
import java.util.Map;

public class MapTests {
    public static void main(String[] args) {
        Map studentAges = new HashMap<String,Integer>();
        studentAges.put("Kolya",50);
        studentAges.put("Sasha",45);
        Integer old = (Integer) studentAges.put("Sasha",51);
        Integer kolyaAge = (Integer) studentAges.get("Kolya");
        System.out.println(old);
        System.out.println(kolyaAge);


    }
}
