import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 8/25/2014.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        if (num == null || num.length==0) return null;
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        helper(num, new boolean[num.length], new ArrayList<Integer>(), re);
        return re;
    }

    private void helper(int[] num, boolean[] used, List<Integer> temp, List<List<Integer>> re){
        if (temp.size() == num.length) {
            //          cannot add temp directly like "re.add(temp);" the reference will be changed later
            //          temp.remove(temp.size()-1);
            //          used[i] = false;
            //          the items would be removed
            re.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i=0; i<num.length; i++){
            if(!used[i])
            {
                used[i] = true;
                temp.add(num[i]);
                helper(num, used, temp, re);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }
    }


    //iterative
    public List<List<Integer>> permute1(int[] num) {
        if (num == null || num.length==0) return null;
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(num[0]);
        re.add(temp);
        //add a new element to all existing permutations
        for (int i=1; i<num.length; i++){
            List<List<Integer>> newRes = new ArrayList<List<Integer>>();
            //for all existing permutations
            for(int j=0;j<re.size();j++)
            {
                List<Integer> cur = re.get(j);
                //add the new element num[i] to all positions in this permutation
                for(int k=0;k<cur.size()+1;k++)
                {
                    ArrayList<Integer> item = new ArrayList<Integer>(cur);
                    item.add(k,num[i]);
                    newRes.add(item);
                }
            }
            re = newRes;
        }
        return re;
    }
}
