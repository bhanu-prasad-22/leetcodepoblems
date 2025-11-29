import java.util.HashMap;
import java.util.Map;

class LongestSubarrayWithEqual0s1s {
    static int func(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += (nums[i] == 0 ? -1 : 1);

            if (map.containsKey(prefix)) {
                maxLen = Math.max(maxLen, i - map.get(prefix));
            } else {
                map.put(prefix, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,1,1};
        System.out.println(func(nums)); 
    }
}

output:
6
