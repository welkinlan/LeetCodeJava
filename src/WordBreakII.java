import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by tianlan on 6/9/2014.
 */
public class WordBreakII {
    //brute force
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        if(s==null || s.length()==0)
            return res;
        if (isWordBreak(s, dict)){
            helper(s,dict,0,"",res);
        }
        return res;
    }
    private void helper(String s, Set<String> dict, int start, String item, List<String> res)
    {
        if(start>=s.length())
        {
            res.add(item);
            return;
        }
        StringBuilder str = new StringBuilder();
        for(int i=start;i<s.length();i++)
        {
            str.append(s.charAt(i));
            if(dict.contains(str.toString()))
            {
                String newItem = item.length()>0?(item+" "+str.toString()):str.toString();
                helper(s,dict,i+1,newItem,res);
            }
        }
    }


    public boolean isWordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
            return true;
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(0, i + 1));
            for (int j = 0; j <= i; j++) {
                if (res[j] && dict.contains(str.toString())) {
                    res[i + 1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
}
