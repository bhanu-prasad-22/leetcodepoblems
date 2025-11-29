Today I completed:

The classic Longest Subarray with Equal 0s and 1s

Deep revision of prefix-sum logic

Multiple prefix-sum traces

Reviewed and strengthened my understanding of 5 key DSA patterns

Reflected on syntax and conceptual mistakes

Reviewed Java project concepts (Q&A)


 Solved: Longest Subarray With Equal 0s and 1s

Concept:
Convert 0 → -1, use prefix sum + HashMap storing first occurrence.

Final Code

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
        System.out.println(func(nums)); // 6
    }
}


 The 5 Core DSA Patterns I Reviewed Today

These 5 patterns form the backbone of most medium–hard problems.



Pattern 1: Sliding Window – Longest Substring Without Repeating Characters

int left = 0;
Map<Character, Integer> map = new HashMap<>();
int maxLen = 0;

for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);

    if (map.containsKey(c)) {
        left = Math.max(left, map.get(c) + 1);
    }

    map.put(c, right);
    maxLen = Math.max(maxLen, right - left + 1);
}



 Pattern 2: Sliding Window – Min Window Substring

Map<Character, Integer> need = new HashMap<>();
Map<Character, Integer> window = new HashMap<>();

int have = 0, required = need.size();
int left = 0;
int minLen = Integer.MAX_VALUE;
int start = 0;

for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    window.put(c, window.getOrDefault(c, 0) + 1);

    if (window.get(c).equals(need.get(c))) {
        have++;
    }

    while (have == required) {
        if (right - left + 1 < minLen) {
            minLen = right - left + 1;
            start = left;
        }
        char l = s.charAt(left);
        window.put(l, window.get(l) - 1);

        if (window.get(l) < need.getOrDefault(l, 0)) {
            have--;
        }
        left++;
    }
}



Pattern 3: Prefix Sum – Subarray Sum Equals K

Map<Integer,Integer> map = new HashMap<>();
map.put(0, 1);

int prefix = 0;
int count = 0;

for (int num: nums) {
    prefix += num;
    count += map.getOrDefault(prefix - k, 0);
    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
}



Pattern 4: Prefix XOR – Count Subarrays with XOR = K

Map<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int prefix = 0, count = 0;

for (int num : nums) {
    prefix ^= num;
    int need = prefix ^ k;
    count += map.getOrDefault(need, 0);
    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
}


Pattern 5: Balanced Subarray (0s = 1s)

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

Project Review Concepts (Q & A Section)

Q1: Why do we use try-with-resources?

A:
It automatically closes files/streams, even if an exception occurs.
Prevents memory leaks and file-lock problems.

Q2: Why do we escape commas and quotes in CSV?

If a name contains: ,",
it breaks CSV formatting.
So we wrap names in quotes and escape inner quotes.

Example:
Ravi, Kumar → "Ravi, Kumar"

Q3: What does LinkedHashMap preserve?

Insertion order
Useful for predictable iteration.


Q4: When to use sorted()?

.sorted() → uses natural ordering

.sorted(Comparator.comparing(...)) → custom sorting

Q5: What does Function.identity() mean?

It returns the value as it is.

Useful in:

Collectors.groupingBy(Function.identity(), Collectors.counting())

It means:
“Group by the elements themselves.”


Summary of What I Completed Today

DSA

Learned and coded Balanced Subarray using Prefix Sum

Completed two major prefix-sum problems (560, 974)

Understood remainder normalization

Fixed misconceptions on containsKey vs containsValue

Strongly reviewed 5 DSA patterns


JAVA PROJECT

Reviewed CSV parser

Understood quoting and escaping

Reviewed JSON export

Understood grouping, sorting, summing (Streams)
