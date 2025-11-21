Revision on LongestSubstringWithoutRepeatingCharacters

solution:


import java.util.HashMap;
import java.util.Map;

class  LongestSubstringWithoutRepeating
{
    static int LongestSubstring(String s)
    {
        Map<Character,Integer> map=new HashMap<>();
        int left=0,right=0;
        int maxLen=Integer.MIN_VALUE;
        while(right<s.length())
        {
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c, 0)+1);
           
                while(map.get(c)>1){
                char l=s.charAt(left);
                map.put(l,map.getOrDefault(l, 0)-1);
                left++;
                }
                maxLen=Math.max(maxLen,right-left+1);
          
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(LongestSubstring("aabbabcd"));
    }
}


learn Comparator.thenComparing()

Task:

Given this list:

List<Student> students = List.of(
    new Student(3, "Bhanu", 20),
    new Student(1, "Arun", 22),
    new Student(2, "Chandu", 19),
    new Student(4, "Arun", 18)
);

Sort by:

1. Name (alphabetical)


2. If names same → age ascending



Code:

students.stream()
        .sorted(
            Comparator.comparing((Student s) -> s.name.toLowerCase())
                      .thenComparingInt(s -> s.age)
        )
        .forEach(System.out::println);


added feature to projectSMS
.Count how many studentss are above age 20.
