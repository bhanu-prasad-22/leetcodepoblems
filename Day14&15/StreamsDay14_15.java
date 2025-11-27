import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

class StreamsDay14_15 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "ant", "bat", "ball", "banana", "car");

        // A) toMap: key = first letter, value = word (if collision combine using comma)
        Map<Character, String> map = words.stream()
            .collect(Collectors.toMap(
                w -> w.charAt(0),
                Function.identity(),
                (a, b) -> a + "," + b  // merge function handles collisions
            ));
        System.out.println("toMap with merge: " + map);

        // B) flatMap -> list of characters per word, flattened
        List<String> chars = words.stream()
            .flatMap(w -> w.chars().mapToObj(c -> String.valueOf((char)c)))
            .distinct()
            .collect(Collectors.toList());
        System.out.println("flattened chars (distinct): " + chars);

        // C) collectingAndThen -> to unmodifiable map of counts by first letter
        Map<Character, Long> counts = words.stream()
            .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()),
                Collections::unmodifiableMap
            ));
        System.out.println("counts (unmodifiable): " + counts);
    }
}

output:
toMap with merge: {a=apple,ant, b=bat,ball,banana, c=car}
flattened chars (distinct): [a, p, l, e, n, t, b, c, r]
counts (unmodifiable): {a=2, b=3, c=1}
