import java.util.HashMap;

/**
 * Created by tianlan on 7/7/2014.
 */
public class SingleNumberII {
    //1: hashmap
    public int singleNumber(int[] A) {
        HashMap<Integer,Integer> intTime = new HashMap<Integer, Integer>();
        for (int i:A){
            if (intTime.containsKey(i)) {
                intTime.put(i,intTime.get(i)+1);
            }
            else {
                intTime.put(i,1);
            }
        }
        for (int key:intTime.keySet()){
            if (intTime.get(key) != 3){
                return key;
            }
        }
        return 0;
    }

    //2:
    public int singleNumber1(int[] A) {
        int[] digits = new int[32];
        for(int i=0;i<32;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                digits[i] += (A[j]>>i)&1;
            }
        }
        int res = 0;
        for(int i=0;i<32;i++)
        {
            res += (digits[i]%3)<<i;
        }
        return res;
    }
}

