Streams Exercise of day 12:


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

Lengths = {apple=5, ball=4, bat=3, car=3, ant=3, cat=3, dog=3}
partion start with vowel : {false=[bat, ball, cat, car, dog], true=[apple, ant]}
upper : {a=[APPLE, ANT], b=[BAT, BALL], c=[CAT, CAR], d=[DOG]}
