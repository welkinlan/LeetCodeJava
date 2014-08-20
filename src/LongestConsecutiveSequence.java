import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by tianlan on 4/30/14.
 */
public class LongestConsecutiveSequence {

    static int longestConsecutive(int[] num) {
        if(num == null || num.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 1;
        for(int i=0;i<num.length;i++)
        {
            set.add(num[i]);
        }
        while(!set.isEmpty())
        {
            Iterator iter = set.iterator();
            int item = (Integer)iter.next();
            set.remove(item);
            int len = 1;
            int i = item-1;
            while(set.contains(i))
            {
                set.remove(i--);
                len++;
            }
            i = item+1;
            while(set.contains(i))
            {
                set.remove(i++);
                len++;
            }
            if(len>res)
                res = len;
        }
        return res;
    }


    public static void main(String[] args) {
        int num[] =  {1,56,7,3,8,2,67,5,21,4,3,3};
        System.out.print(longestConsecutive(num));
    }
}
