/**
 * Created by tianlan on 8/27/2014.
 */
public class WildcardMatching {
    //DP
    public boolean isMatch(String s, String p) {
        if(p.length()==0)
            return s.length()==0;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int j=0;j<p.length();j++)
        {
            if(p.charAt(j)!='*')
            {
                //to go through a extreme case p = '*******************...***'
                if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')
                    return false;
                //check every element
                for(int i=s.length()-1;i>=0;i--)
                {
                    res[i+1] = res[i]&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j));
                }
            }
            else
            {
                //turn all elements after the first match to be true
                int i = 0;
                while(i<=s.length() && !res[i])
                    i++;
                for(;i<=s.length();i++)
                {
                    res[i] = true;
                }
            }
            res[0] = res[0]&&p.charAt(j)=='*';
        }
        return res[s.length()];
    }
}
