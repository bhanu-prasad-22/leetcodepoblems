
import java.util.*;

class CountSubarraysDivBy5 {

    static int CountDivBy5(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int result = 0;
        for (int num : nums) {
            prefix += num;

            int rem = ((prefix % k + k) % k);//negative rem should also fit int correct buckets

            result += map.getOrDefault(rem, 0);//any previous prefix with same reaminder gives sunarray divisble by k

            map.put(rem, map.getOrDefault(rem, 0) + 1);

        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, -1};
        int k = 5;
        int result = CountDivBy5(nums, k);
        System.out.println(result);
    }
}
