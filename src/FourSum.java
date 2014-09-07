import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 9/7/14.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length==0)
            return res;
        Arrays.sort(num);
        for(int i=num.length-1;i>2;i--)
        {
            if(i==num.length-1 || num[i]!=num[i+1])
            {
                ArrayList<ArrayList<Integer>> curRes = threeSum(num,i-1,target-num[i]);
                for(int j=0;j<curRes.size();j++)
                {
                    curRes.get(j).add(num[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }
    private ArrayList<ArrayList<Integer>> threeSum(int[] num, int end, int target)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=end;i>1;i--)
        {
            if(i==end || num[i]!=num[i+1])
            {
                ArrayList<ArrayList<Integer>> curRes = twoSum(num,i-1,target-num[i]);
                for(int j=0;j<curRes.size();j++)
                {
                    curRes.get(j).add(num[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }
    private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int l=0;
        int r=end;
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
}
