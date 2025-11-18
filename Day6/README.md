Lambda, Comparator, and Sorting Deep Dive (practical examples)

Core ideas (short)

Comparator.comparing(...) builds comparators.

thenComparing(...) chains tie-breakers.

Lambdas let you write concise comparators: (a,b) -> a.age - b.age.

Use Collections.sort(list, comparator) or list.sort(comparator) or stream().sorted(...).


Examples using your Student class (fields: int id; String name; int age;)

1) Sort by name (case-insensitive)

students.sort(Comparator.comparing(s -> s.name.toLowerCase()));

2) Sort by age ascending, then name ascending

students.sort(
    Comparator.comparingInt((Student s) -> s.age)
              .thenComparing(s -> s.name.toLowerCase())
);

3) Sort by age descending

students.sort(Comparator.comparingInt((Student s) -> s.age).reversed());

4) Using Streams to get top-3 oldest students

List<Student> top3 = students.stream()
    .sorted(Comparator.comparingInt((Student s) -> s.age).reversed())
    .limit(3)
    .collect(Collectors.toList());

5) Comparator with method reference and multiple keys (clean)

students.sort(
    Comparator.comparing((Student s) -> s.name.toLowerCase())
              .thenComparingInt(s -> s.age)
);

Notes

Prefer comparingInt for primitive int keys (avoids boxing).

Use toLowerCase() in comparator if you want case-insensitive ordering.

thenComparing(Comparator.nullsLast(...)) useful if fields may be null.
