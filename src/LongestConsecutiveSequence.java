import java.util.HashMap;

/**
 * Created by tianlan on 4/30/14.
 */
public class LongestConsecutiveSequence {

    static int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i:num){
            map.put(i,1);
        }
        //for

        return map.get(3);
    }


    public static void main(String[] args) {
        int num[] =  {1,56,7,3,8,2,67,5,21,4,3,3};
        System.out.print(longestConsecutive(num));
    }
}
