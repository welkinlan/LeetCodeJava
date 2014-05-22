/**
 * Created by tianlan on 5/21/2014.
 */
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        return false;
    }


    public static void main(String[] args){
        System.out.print(isMatch("aa","a"));
        System.out.print(isMatch("aa","aa"));
        System.out.print(isMatch("aaa","aa"));
        System.out.print(isMatch("aa", "a*"));
        System.out.print(isMatch("aa", ".*"));
        System.out.print(isMatch("ab", ".*"));
        System.out.print(isMatch("aab", "c*a*b"));
    }
}
