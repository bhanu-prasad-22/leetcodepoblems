
class MinWindowSubsequence {

    static String minSequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m == 0) {
            return "";
        }
        if (n < m) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        int bestStart = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(0)) {
                continue;//we search for a match for t cahr at index 0 in s
            }
            int sIdx = i;//starting index of s matched with first char of t at t[0]
            int tIdx = 0;//starting index of t

            while (sIdx < n && tIdx < m)//s goes till n and t till m
            {
                if (s.charAt(sIdx) == t.charAt(tIdx))//checks for subsequence of t in s
                {
                    tIdx++;//if found increment tIdx to got next sequence char
                }
                sIdx++;//then we increment to get next char of s to get another sequence char in s
            }

            if (tIdx == m)//we travesed and matched all t char sequence
            {
                int end = sIdx - 1;//last matched char index form s with t

                int k = end;// to backtrack for finding the start that still matches t
                int j = m - 1;//t last index tarvese form there to fist char index
                while (j >= 0) {
                    if (s.charAt(k) == t.charAt(j)) {
                        j--;//to move t index from last if match found
                    }
                    k--;//then s index decremented
                }

                int start = k + 1;//window start index
                int len = end - start + 1;
                if (len < minLen) {
                    minLen = len;
                    bestStart = start;
                }
                i = start;
            }
        }
        return (bestStart == -1) ? "" : s.substring(bestStart, bestStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println("result:" + minSequence("abcdebdde", "bde"));
    }
}
