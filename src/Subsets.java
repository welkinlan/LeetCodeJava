import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 8/22/2014.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if (S==null || S.length==0) return null;
        Arrays.sort(S);
        for (int i=0; i<S.length; i++){
            int size = res.size();
            for (int j=0; j<size; j++){
                ArrayList<Integer> newSet= new ArrayList<Integer>(res.get(j));
                newSet.add(S[i]);
                res.add(newSet);
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> subsets1(int[] num) {
        if(num == null)
            return null;
        Arrays.sort(num);
        return helper(num, num.length-1);
    }
    private ArrayList<ArrayList<Integer>> helper(int[] num, int index)
    {
        if(index == -1)
        {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> elem = new ArrayList<Integer>();
            res.add(elem);
            return res;
        }
        ArrayList<ArrayList<Integer>> res = helper(num,index-1);
        int size = res.size();
        for(int i=0;i<size;i++)
        {
            ArrayList<Integer> elem = new ArrayList<Integer>(res.get(i));
            elem.add(num[index]);
            res.add(elem);
        }
        return res;
    }

}
