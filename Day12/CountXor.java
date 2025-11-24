import java.util.HashMap;
import java.util.Map;

class CountXor {
    static int CountXOR(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0, result = 0;
        for (int num : nums) {
            prefix ^= num;
            int need = prefix ^ k;
            result += map.getOrDefault(need, 0);
            // record the current prefix XOR (not 'need')
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println("answer = " + CountXOR(nums, k)); // expected: answer = 4
    }
}
