/**
 * Created by tianlan on 4/29/14.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int single=0;
        for(int i:A) single^=i;
        return single;
    }
}
