
import java.util.HashMap;
import java.util.Map;



class HM{
    public static void main(String[] args) {
        int[] a={1,2,2,3,3,3};
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:a)
        {
            m.put(i,m.getOrDefault(i,0)+1);

        }

        for(Map.Entry<Integer,Integer> e : m.entrySet())
        {
            System.out.println(e.getKey()+"->"+e.getValue());
        }


    }
}

output:
1->1
2->2
3->3
