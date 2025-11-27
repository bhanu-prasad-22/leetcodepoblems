first calculate total sum of array elements.
check if it is divisble by 3 to divide 3 equal parts.
make target==total/3.
use prefixsum.
traverse through array and add numbers to prefix.
if prefix ==target increment countPrefixTarget.
if prefix == 2* target increment ways=ways+CountPrefixtarget.
return ways.

class NoOfWaysToSplitArrayInto3Parts {

    static int NoOfWays(int[] nums) {
        long total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 3 != 0) {
            return 0;
        }
        long target = total / 3;

        int prefix = 0;
        int ways = 0;
        long countPrefixTarget = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            prefix += nums[i];
            if (prefix == 2 * target) {
                ways += countPrefixTarget;
            }
            if (prefix == target) {
                countPrefixTarget++;

            }
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 3};
        int result = NoOfWays(nums);
        System.out.println(result);

    }
}

output:
2
