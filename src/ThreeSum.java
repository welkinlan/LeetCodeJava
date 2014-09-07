import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 9/6/14.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num==null || num.length<=2)
            return res;
        Arrays.sort(num);
        for(int i=num.length-1;i>=2;i--)
        {
            if(i<num.length-1 && num[i]==num[i+1])
                continue;
            ArrayList<ArrayList<Integer>> curRes = twoSum(num,i-1,-num[i]);
            for(int j=0;j<curRes.size();j++)
            {
                curRes.get(j).add(num[i]);
            }
            res.addAll(curRes);
        }
        return res;
    }

    private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end,int target)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<=1)
            return res;
        int l = 0;
        int r = end;
        while(l<r)
        {
            if(num[l]+num[r]==target)
            {
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(num[l]);
                item.add(num[r]);
                res.add(item);
                l++;
                r--;
                while(l<r&&num[l]==num[l-1])
                    l++;
                while(l<r&&num[r]==num[r+1])
                    r--;
            }
            else if(num[l]+num[r]>target)
            {
                r--;
            }
            else
            {
                l++;
            }
        }
        return res;
    }
    /*
    public List<List<Integer>> threeSum(int[] num) {
        if (num==null || num.length==0) return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        subroutine(num, 0, 1, res, 0, new ArrayList<Integer>());
        return res;
    }

    private void subroutine (int[] num, int index, int n, List<List<Integer>> res, int sum, ArrayList<Integer> list){
        if (n==3){
            if (num[index]==sum) {
                ArrayList<Integer> l = new ArrayList<Integer>(list);
                res.add(l);
            }
            return;
        }
        for (int i=index; i<num.length-n; i++){
            list.add(num[i]);
            subroutine(num, i+1, n+1, res, sum-num[i], list);
            list.remove(num[i]);
        }
    }
    */
}
