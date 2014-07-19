import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 5/30/2014.
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s==null || s.length()==0)
            return res;
        helper(s, getDict(s),0,new ArrayList<String>(), res);
        return res;
    }

    private static void helper(String s, boolean[][] dict, int start, ArrayList<String> item, List<List<String>> res)
    {
        if(start==s.length())
        {
            res.add(new ArrayList<String>(item));
            return;
        }
        for(int i=start;i<s.length();i++)
        {
            if(dict[start][i])
            {
                item.add(s.substring(start,i+1));
                //System.out.println("a:"+start+item);
                helper(s,dict,i+1,item,res);
                item.remove(item.size()-1);
                //System.out.println("r:"+start+item);
            }
        }
        //System.out.println();
    }
    private static boolean[][] getDict(String s)
    {
        boolean[][] dict = new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--)
        {
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j) && ((j-i<2)||dict[i+1][j-1]))
                {
                    dict[i][j] = true;
                }
            }
        }
        return dict;
    }

    public static void main(String[] args){
        List<List<String>> res = partition("aab");
        boolean[][] dict = getDict("aab");
//        for (int i=0; i<dict.length; i++){
//            for (int j=0; j<dict.length; j++){
//                System.out.print(dict[i][j]);
//            }
//            System.out.println();
//        }
    }
}


