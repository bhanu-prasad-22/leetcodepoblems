⭐ Day 5 — Java Streams API


🔥 Why Streams?

Declarative, expressive style for collection processing.
Can chain multiple operations succinctly.
Enables parallelism easily (parallelStream()), but don’t use until correct.
Very common in production code and interview coding tests.

🎯 Core intermediate operations
filter(Predicate<T>)
Keeps only elements that match a condition.
List<String> names = list.stream()
                         .filter(s -> s.length() > 3)
                         .collect(Collectors.toList());

map(Function<T,R>)
Transforms each element.
List<Integer> lengths = names.stream()
                             .map(String::length)
                             .collect(Collectors.toList());

flatMap
Flattens nested streams — useful for lists of lists.
List<List<Integer>> nested = ...
List<Integer> flat = nested.stream()
                           .flatMap(Collection::stream)
                           .collect(Collectors.toList());

sorted(), distinct()
list.stream().distinct().sorted().collect(toList());

⚡ Terminal operations
collect(Collectors.toList())

Commonly used to materialize result.

forEach
Use for side-effects (printing).
stream.forEach(System.out::println);

count()
Number of elements after pipeline.
long cnt = stream.filter(...).count();

reduce
Combine elements to a single result.
Optional<Integer> sum = nums.stream().reduce(Integer::sum);
int s = nums.stream().reduce(0, Integer::sum);

anyMatch, allMatch, noneMatch
Boolean checks on predicate.
boolean hasAdult = people.stream().anyMatch(p -> p.getAge() >= 18);

🧩 Collectors (powerful stuff)
Collectors.groupingBy()
Group elements by a classifier.
Map<String, Long> byDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

Collectors.partitioningBy()
Boolean partition into two groups.
Map<Boolean, List<Person>> parts = people.stream()
    .collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
    
Collectors.joining()
Join strings.
String csv = names.stream().collect(Collectors.joining(", "));

🧪 Small examples (read, run mentally)
Sum of even numbers from list:
int sumEven = list.stream().filter(x->x%2==0).mapToInt(Integer::intValue).sum();


Top 3 highest salaries:
List<Employee> top3 = employees.stream()
    .sorted(Comparator.comparing(Employee::getSalary).reversed())
    .limit(3)
    .collect(Collectors.toList());


Count frequency using streams:
Map<Integer, Long> freq = nums.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

✅ Day 5 Streams Assignment (pick one — do one now)

A. Transform & filter (easy — 10–12 min)

Given List<String> names = List.of("bhanu","raj","arun","ananya");

Produce uppercase names whose length > 3, sorted alphabetically.

B. Frequency map with groupingBy (medium — 12–15 min)

Given int[] arr = {1,2,2,3,3,3,4};

Produce Map<Integer, Long> of frequencies using streams.

C. Employee grouping (use small class) (harder — 15–20 min)

A,B solution:

import java.util.*;
impoimport java.util.stream.Collector;
import java.util.stream.*;
import java.util.function.Function;


class Exercise5
{
    public static void main(String[] args) {

        List<String> names = List.of("bhanu","raj","arun","ananya");

        List<String> n = names.stream()
                              .filter(s -> s.length() > 3)
                              .map(String::toUpperCase)
                              .sorted()
                     }

        System.out.println(n);

        int[] arr = {1,2,2,3,3,3,4};

        Map<Integer, Long> freq = Arrays.stream(arr)
                                     .boxed()  // convert int -> Integer
                                     .collect(Collectors.groupingBy(
                                         Function.identity(),
                                         Collectors.counting()
                                     ));

        System.out.println(freq);
    }
}


