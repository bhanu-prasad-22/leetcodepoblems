keep a map with characters and freq of it
slide over window and add  caharcters with their frequencies
  if map size >k
  remove the count of character at left
  if count == 0 remove character form map
  increment left
update maxLen
increment right
return right


import java.util.*;

class LongestSubstringWithKDistnictCharacters {

    static int LongestSubstringK(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcdeabcdeaaa";
        System.out.println("answer = " + LongestSubstringK(s, 5));
    }
}
