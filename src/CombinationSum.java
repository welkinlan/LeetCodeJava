import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 8/27/14.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length==0)
            return res;
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<Integer>(),res);
        return res;
    }
    private void helper(int[] candidates, int start, int target, List<Integer> item,
                        List<List<Integer>> res)
    {
        if(target<0)
            return;
        if(target==0)
        {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start;i<candidates.length;i++)
        {
            if(i>0 && candidates[i]==candidates[i-1])
                continue;
            item.add(candidates[i]);
            helper(candidates,i,target-candidates[i],item,res);
            item.remove(item.size()-1);
        }
    }
}
