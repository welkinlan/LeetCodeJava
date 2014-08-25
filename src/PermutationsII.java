import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 8/25/2014.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if (num==null || num.length==0){
            return re;
        }
        Arrays.sort(num);
        helper(num, new boolean[num.length], new ArrayList<Integer>(), re);
        return re;
    }

    private void helper(int[] num, boolean[] used, List<Integer> curList, List<List<Integer>> re){
        if (curList.size() == num.length){
            re.add(new ArrayList<Integer>(curList));
            return;
        }
        for (int i=0; i<num.length; i++){
            if (i>0 && num[i]==num[i-1] && !used[i-1]) continue;
            if(!used[i])
            {
                used[i] = true;
                curList.add(num[i]);
                helper(num, used, curList, re);
                curList.remove(curList.size()-1);
                used[i] = false;
            }
        }
    }
}
