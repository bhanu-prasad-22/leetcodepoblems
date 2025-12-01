 1-Hour Java Collections Session (Dec 1)


---

PART 1 — Theory (20–25 min)

1. List vs Set vs Map — 5 min

List

Ordered

Allows duplicates

Access by index
Examples: ArrayList, LinkedList


Set

No duplicates

Not indexed
HashSet: random order
LinkedHashSet: insertion order
TreeSet: sorted order


Map

Key → Value pairs

Keys cannot duplicate
HashMap: random order
LinkedHashMap: insertion order
TreeMap: sorted by key



---

2. HashMap Internals (8–10 min)

How it works:

1. hashCode() of key → bucket index


2. Each bucket = linked list or balanced tree


3. Collisions handled with chaining


4. When bucket list grows > 8 → becomes Red-Black tree


5. Load factor (default 0.75) triggers resize



Time complexities:

put() → O(1) avg

get() → O(1) avg

Worst case → O(log n) (tree)



---

3. HashSet / TreeSet Basics (7–8 min)

HashSet

Backed by HashMap (values = dummy object)

No duplicates

Unordered

O(1) add, remove, contains


TreeSet

Sorted (natural order or custom Comparator)

Backed by TreeMap

O(log n) for add, remove, search



---

PART 2 — SMALL TASKS (35–40 min)

 Task 1: Convert array → ArrayList (5 min)

Code

import java.util.*;

class Main {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d"};

        List<String> list = new ArrayList<>(Arrays.asList(arr));

        System.out.println(list);
    }
}

 Output:

[a, b, c, d]


---

 Task 2: Count frequency of chars using HashMap (20 min)

Problem:

Input: "banana"
Output: {b=1, a=3, n=2}

Code

import java.util.*;

class Main {
    public static void main(String[] args) {
        String s = "banana";

        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println(freq);
    }
}


---

 Task 3: Print sorted map keys (TreeMap) (10 min)

Code

import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("orange", 2);
        map.put("apple", 5);
        map.put("banana", 3);

        // Convert to TreeMap → sorted by key
        Map<String, Integer> sorted = new TreeMap<>(map);

        for (String key : sorted.keySet()) {
            System.out.println(key + " : " + sorted.get(key));
        }
    }
}

Output (sorted):

apple : 5
banana : 3
orange : 2

What today Completed Today (Dec 1)

✔ List vs Set vs Map

✔ HashMap internals

✔ HashSet / TreeSet basics

✔ Convert array → ArrayList

✔ Count char frequency

✔ Sorted map using TreeMap


ALL CONVERSIONS IN ONE TABLE

Conversion	Code

Array → List	         new ArrayList<>(Arrays.asList(arr))

Array → Set          	 new HashSet<>(Arrays.asList(arr))

Array → TreeSet	       new TreeSet<>(Arrays.asList(arr))

List → Array	         list.toArray(new String[0])

Set → Array	           set.toArray(new String[0])

Map keys → Array	     map.keySet().toArray(new String[0])

Map values → Array	   map.values().toArray(new Integer[0])

Map entries → Array	   map.entrySet().toArray(new Map.Entry[0])
