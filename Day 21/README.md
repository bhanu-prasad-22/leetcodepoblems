

# Java Streams Basics (Crash Session – 1 Hour)

Streams allow you to process collections in a **functional, concise** way using pipelines:

collection.stream()
          .intermediate operations...
          .terminal operation;

# Core Operations 

# filter()

Keeps elements that satisfy a condition.

List<Integer> nums = List.of(1, 2, 3, 4, 5);

List<Integer> even = nums.stream()
        .filter(n -> n % 2 == 0)
        .toList();

System.out.println(even); // [2, 4]


# map()

Transforms each element.

List<String> names = List.of("ram", "sham", "gita");

List<String> upper = names.stream()
        .map(String::toUpperCase)
        .toList();

System.out.println(upper); // [RAM, SHAM, GITA]

# collect()

Collect terminal result using Collectors:

* `toList()`
* `toSet()`
* `toMap()`
* `joining()`
* `groupingBy()`
* `counting()` etc.


# groupingBy()

Groups items based on a key function.

Example: group names by length:
Map<Integer, List<String>> grouped =
    names.stream()
         .collect(Collectors.groupingBy(String::length));

# counting()

Counts items (usually used inside grouping).

long count = names.stream().count();

Or inside `groupingBy`:

Map<Integer, Long> countByLength =
    names.stream()
         .collect(Collectors.groupingBy(String::length, Collectors.counting()));


# Task 1: Group names by first letter

Input:
List<String> names = List.of("Arun", "Aadi", "Bala", "Ben", "Charan", "Chiru");

Solution:
Map<Character, List<String>> result =
    names.stream()
         .collect(Collectors.groupingBy(name -> name.charAt(0)));

System.out.println(result);

Output Example:

A → [Arun, Aadi]
B → [Bala, Ben]
C → [Charan, Chiru]

--------------------------------------------------------------

#Task 2: Convert list → uppercase list

List<String> words = List.of("java", "spring", "stream");

List<String> upper =
    words.stream()
         .map(String::toUpperCase)
         .toList();

System.out.println(upper);

---

#Task 3: Count word lengths

List<String> words = List.of("apple", "dog", "banana", "cat");

Map<Integer, Long> countByLength =
    words.stream()
         .collect(Collectors.groupingBy(
             String::length,
             Collectors.counting()
         ));

System.out.println(countByLength);
----
Output Example:
3 → 2
5 → 1
6 → 1

---

# all in one exercise

List<String> words = List.of("java", "code", "chatgpt", "ai", "java");

Map<Integer, Long> result =
    words.stream()
         .map(String::toUpperCase)
         .filter(w -> w.length() > 2)
         .collect(Collectors.groupingBy(String::length, Collectors.counting()));

System.out.println(result);
