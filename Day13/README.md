StreamsExercise Day 13


import java.util.*;
import java.util.stream.*;

public class StreamsDay12 {

    public static void main(String[] args) {
        List<String> words = List.of("apple", "ant", "bat", "ball", "cat", "car", "dog");
        Map<String, Integer> lengths = words.stream()
                .collect(Collectors.toMap(w -> w, w -> w.length()));
        System.out.println("Lengths = " + lengths);

        //partitioningBy start with vowel
        Map<Boolean, List<String>> partition = words.stream()
                .collect(Collectors.partitioningBy(w -> "aeiou".indexOf(w.charAt(0)) != -1));
        System.out.println("partion start with vowel : " + partition);

        //groupinBy and mapping first letter to uppercase
        Map<Character, List<String>> upper = words.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.mapping(String::toUpperCase, Collectors.toList())
                ));
        System.out.println("upper : " + upper);
    }
}

output:

Part = {false=[apple, mango, grape, melon], true=[orange, banana]}
Joined = apple, orange, banana, mango, grape, melon
totalCharacters = 32
LongestWord = orange
Immutable = [apple, orange, banana, mango, grape, melon]
