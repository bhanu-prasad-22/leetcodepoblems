Streams Exercise

import java.util.*;
import java.util.stream.*;

class StreamsDay11 {

    public static void main(String[] args) {
        List<String> words = List.of("apple", "bat", "cat", "ball", "car", "dog", "doll");

        //gorup by first letter
        Map<Character, List<String>> groups = words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("group by first letter:" + groups);

        //group and count
        Map<Character, Long> count = words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0),
                        Collectors.counting()));
        System.out.println("Group and Count:" + count);

        //group and sum length of words
        Map<Character, Integer> totalLength = words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0),
                        Collectors.summingInt(String::length)));
        System.out.println("group and sum length of words:" + totalLength);
    }
}

output:
group by first letter:{a=[apple], b=[bat, ball], c=[cat, car], d=[dog, doll]}
Group and Count:{a=1, b=2, c=2, d=2}
group and sum length of words:{a=5, b=7, c=6, d=7}
