import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 8/27/14.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num == null || num.length==0)
            return res;
        Arrays.sort(num);
        helper(num,0,target,new ArrayList<Integer>(),res);
        return res;
    }
    private void helper(int[] num, int start, int target, List<Integer> item,
                        List<List<Integer>> res)
    {
        if(target == 0)
        {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if(target<0 || start>=num.length)
            return;
        for(int i=start;i<num.length;i++)
        {
            /**
             * duplicate elements are only considered one time,
             * consider the first appearance of element 'a'. after 'a' is added and the helper() returns (all cases done)
             * then 'a' is removed, goes to the next element
             * if the new element is still 'a', then we could ignore it as all cases have been handled already.
             *
             **/

            if(i>start && num[i]==num[i-1]) continue;
            item.add(num[i]);
            helper(num,i+1,target-num[i],item,res);
            item.remove(item.size()-1);
        }
    }
}
