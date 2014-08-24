import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 8/23/14.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if (num==null || num.length==0) return null;
        Arrays.sort(num);
        int start = 0;
        for (int i=0; i<num.length; i++){
            int currentSize = res.size();
            for (int j=start; j<currentSize; j++){
                List<Integer> newSet = new ArrayList<Integer>(res.get(j));
                newSet.add(num[i]);
                res.add(newSet);
            }
            if (i<num.length-1 && num[i]==num[i+1]) start=currentSize;
            else start = 0;
        }
        return res;
    }

}
