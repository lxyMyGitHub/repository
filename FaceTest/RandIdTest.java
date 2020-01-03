package cfca.xfraud.api.test;

import java.util.HashMap;
import java.util.Map;

public class RandIdTest {
    public static void main(String[] args) {
        Map map = new HashMap<String,String>();
        map.put("key", 1);
        Map m1 = map;
        m1.put("key", 2);
        System.out.println(map.get("key"));
        
    }
}
