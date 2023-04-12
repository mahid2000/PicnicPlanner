import java.util.Map;
import java.util.HashMap;

public class HashMapTest {

    public static void main (String[] args) {

        Map<String, Integer> m = new HashMap<String, Integer>(1);

        m.put("one", 1);
        m.put("two", 2);
        m.put("three", 3);

        System.out.println(m);

        Integer v = m.get("four");
        if (v != null) {
            System.out.println("four -> " + v);
        } else {
            System.out.println("four -> null");
        }

        if (m.containsKey("three")) {
            System.out.println("three is in the map");
        }

        System.out.println("Iterating over keys");
        for (String k : m.keySet()) {
            System.out.println(k);
        }

        System.out.println("Iterating over values");
        for (int val : m.values()) {
            System.out.println(val);
        }

        System.out.println("Iterating over Key-Value entries");
        for (Map.Entry<String, Integer> kv : m.entrySet()) {
            System.out.println("Key: " + kv.getKey());
            System.out.println("Value: " + kv.getValue());
        }

    }

}
