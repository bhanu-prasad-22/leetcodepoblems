
import java.util.*;

class CountSubarraysWithEqualos1s
{
    static int Count0s1s(int[] nums)
    {
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefix=0;
        for(int i:nums)
        {
           int val=(i==0)?-1:1;
            prefix=prefix+val;
            count+=map.getOrDefault(prefix,0);
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums={0,0,1,0,1,1};
        int r=Count0s1s(nums);
        System.out.println(r);
    }
}


output:
5
