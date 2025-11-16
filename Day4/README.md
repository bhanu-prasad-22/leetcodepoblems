1) Map basics

Map<K,V> is the interface. Common implementations:

HashMap — average O(1) get/put, no order, allows one null key.

LinkedHashMap — maintains insertion order (or access order if configured), useful for ordered iteration or simple LRU caches.

TreeMap — sorted order by key, backed by a Red-Black tree; O(log n) ops.

2) When to use each

Use HashMap for fast lookups when order doesn’t matter.

Use LinkedHashMap when iteration order matters (or for access-order LRU).

Use TreeMap when you need keys sorted or need firstKey()/lastKey() operations.

3) Example snippets

HashMap

Map<String,Integer> freq = new HashMap<>();
freq.put("a", 1);
freq.put("b", 2);
System.out.println(freq.getOrDefault("c", 0)); // 0


LinkedHashMap (preserves insertion order)

Map<String,Integer> lmap = new LinkedHashMap<>();
lmap.put("x",1);
lmap.put("y",2);
for (Map.Entry<String,Integer> e : lmap.entrySet()) {
    System.out.println(e.getKey()+" -> "+e.getValue());
}


TreeMap (sorted)

Map<Integer,String> tmap = new TreeMap<>();
tmap.put(10,"ten");
tmap.put(5,"five");
for (Map.Entry<Integer,String> e : tmap.entrySet()) {
    System.out.println(e.getKey()); // prints 5 then 10
}

4) Short exercises (pick one and code)

A. Insert keys in a HashMap, update counts, and print entries.
B. Use LinkedHashMap to store insertion order of names and then print them.
C. Use TreeMap to count integers from an array and print counts in ascending key order.

solution:

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class Day4Map
{
    public static void main(String[] args) {
        Map<Integer,Integer> hm=new HashMap<>();
        int[] arr={2,2,2,3,4,1,3,2,1};

        for(int i:arr)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            System.out.println(e.getKey()+":"+e.getValue());

        }

        Map<String,Integer> lhm=new LinkedHashMap<>();
        lhm.put("BhanuPrasad",1);
        lhm.put("java developer",2);
         for (Map.Entry<String, Integer> e : lhm.entrySet()) {
            System.out.println(e.getKey()+":"+e.getValue());

        }

        Map<Integer,Integer> tm=new TreeMap<>();


        for(int i:arr)
        {
            tm.put(i,tm.getOrDefault(i,0)+1);
        }
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            System.out.println(e.getKey()+":"+e.getValue());

        }


    }

}
