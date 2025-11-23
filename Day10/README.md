java STreams intermediate ops:



import java.util.*;
import java.util.stream.*;

class StreamsDay10 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 20, 30, 40, 50, 60);
        List<Integer> mid = nums.stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("mid:" + mid);

        int sum = nums.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println("sum:" + sum);

        List<List<String>> nested = List.of(
                List.of("a", "b"),
                List.of("c", "d"),
                List.of("e")
        );
        List<String> flat = nested.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("flat=" + flat);
    }
}

output:

mid:[30, 40, 50]
sum:210
flat=[a, b, c, d, e]
