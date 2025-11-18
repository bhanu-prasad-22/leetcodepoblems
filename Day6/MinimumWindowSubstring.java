
import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int required = need.size(), formed = 0;
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            window.put(r, window.getOrDefault(r, 0) + 1);

            if (window.get(r).intValue() == need.getOrDefault(r, 0)) {
                formed++;
            }
            right++; // right is exclusive (one past last included)

            // shrink while window is valid
            while (formed == required) {
                // current window length is right - left
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                window.put(l, window.get(l) - 1);
                if (window.get(l) < need.getOrDefault(l, 0)) {
                    formed--;
                }

                if (window.get(l) == 0) {
                    window.remove(l);
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // expected "BANC"
        System.out.println(minWindow("a", "a"));               // "a"
        System.out.println(minWindow("a", "aa"));              // ""
    }
}
