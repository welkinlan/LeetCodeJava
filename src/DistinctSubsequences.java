import java.util.ArrayList;

/**
 * Created by tianlan on 8/6/2014.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if(T.length()==0)
        {
            return 1;
        }
        if(S.length()==0)
            return 0;
        int[] res = new int[T.length()+1];
        res[0] = 1;
        for(int i=0;i<S.length();i++)
        {
            for(int j=T.length()-1;j>=0;j--)
            {
                res[j+1] = (S.charAt(i)==T.charAt(j)?res[j]:0)+res[j+1];
            }
        }
        return res[T.length()];
    }

    public int numDistinct1(String S, String T) {
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= T.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= S.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }



    //my recursive : TLE
    public static int numDistinct2(String S, String T) {
        if (S==null || T==null || S.length()==0 || T.length()==0) return 0;
        ArrayList<Integer> re = new ArrayList<Integer>(); //pass into function as a reference (not use int)
        re.add(0);
        helper(re, S, T, 0, 0);
        return re.get(0);
    }

    public static void helper(ArrayList<Integer> re, String S, String T, int tp, int sp){
        //System.out.println(re+" "+tp+" "+sp);
        if (tp >= T.length() && sp <= S.length()){
            re.set(0,re.get(0)+1);
            return;
        }
        if (sp > S.length())return;
        char c = T.charAt(tp);
        for (int j=sp; j<S.length(); j++){
            if (S.charAt(j) == c){
                //System.out.println(S.charAt(j)+" "+c);
                helper(re, S, T, tp+1, j+1);
            }
        }
        return;
    }




    public static void main(String[] args){
        System.out.print(numDistinct("rabsbbit", "rabit"));
    }
}
