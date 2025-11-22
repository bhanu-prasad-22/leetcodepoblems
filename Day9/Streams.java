
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class StreamsDay9 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 3, 9, 1, 3, 5, 8, 5);

// a) Frequency map using streams
        Map<Integer, Long> freq = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);

// b) Top 3 largest using streams
        List<Integer> top3 = nums.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(top3);

// c) Distinct sorted
        List<Integer> distinctSorted = nums.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(distinctSorted);
    }
}

output:

{1=1, 3=2, 5=3, 8=1, 9=1}
[9, 8, 5]      
[1, 3, 5, 8, 9]
