package lab.hashmap;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<StringKey, String> map1 = new HashMap<StringKey, String>();

        StringKey sk1 = new StringKey("key1");
        StringKey sk2 = new StringKey("key1");
        StringKey sk3 = new StringKey("key1");

        map1.put(sk1, "Value1");
        map1.put(sk2, "Value2");
        map1.put(sk3, "Value3");

        System.out.println("sk3 gets: " + map1.get(sk3));

        StringKey sk4 = new StringKey("key4");
        StringKey sk5 = new StringKey("key5");
        StringKey sk6 = new StringKey("key6");

        map1.put(sk4, "Value4");
        map1.put(sk5, "Value5");
        map1.put(sk6, "Value6");

        System.out.println("sk6 gets: " + map1.get(sk6));
    }
}
