/**
 * Created by tianlan on 5/21/2014.
 */
public class RegularExpressionMatching {
    /*
    public static boolean isMatch(String s, String p) {
        char[] myArray = s.toCharArray();
        char[] reArray = p.toCharArray();
        int myPos = 0;
        int rePos = 0;
        char myPrev = '\0';
        char rePrev = '\0';
        while (myPos < s.length() && rePos < p.length()){
            if (reArray[rePos] == myArray[myPos] || reArray[rePos] == '.'){
                myPrev = myArray[myPos]; rePrev = reArray[rePos];
                myPos ++; rePos ++;
            }
            else if (reArray[rePos] == '*'){
                if (rePrev == '.' || (myPrev == myArray[myPos] && rePrev == myPrev)) {
                    myPos ++;
                }
                else{ //not match
                    rePrev = reArray[rePos];
                    rePos ++;
                }
            }
            else{
                rePrev = reArray[rePos];
                rePos ++;
            }
        }

        if (myPos == s.length()) {
            if (rePos == p.length() || (reArray[rePos]=='*' && rePos == p.length()-1)) {
                return true;
            }
            while (rePos < p.length()-1){
                if (reArray[rePos+1] == rePrev){
                    rePos ++;
                }
            }
            if (rePos == p.length()-1) return true;
            while (rePos < p.length()-3){
                if (reArray[rePos+1] == '.' && reArray[rePos+2] == '*') {
                    rePos += 2;
                }
                else return false;
            }
            if (rePos == p.length()-1 && reArray[rePos]=='*') return true;
            else return false;
        }
        else return false;
    }
    */

    public static boolean isMatch(String s, String p) {
        //Java note: s.substring(n) will be "" if n == s.length(), but if n > s.length(), index oob error
        // Start typing your Java solution below
        // DO NOT write main() function

        int i = 0, j = 0;
        //you don't have to construct a state machine for this problem

        if (s.length() == 0) {
            return checkEmpty(p);
        }

        if (p.length() == 0) {
            return false;
        }

        char c1 = s.charAt(0);
        char d1 = p.charAt(0), d2 = '0'; //any init value except '*'for d2 will do

        if (p.length()>1){
            d2 = p.charAt(1);
        }

        if (d2 == '*') {
            if (compare(c1, d1)) {
                //fork here: 1. consume the character, and use the same pattern again.
                //2. keep the character, and skip 'd1*' pattern

                //Here is also an opportunity to use DP, but the idea is the same
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }
            else {
                return isMatch(s, p.substring(2));
            }
        }
        else {
            if (compare(c1, d1)) {
                return isMatch(s.substring(1), p.substring(1));
            }
            else {
                return false;
            }
    }
}

    public static boolean compare(char c1, char d1){
        return d1 == '.' || c1 == d1;
    }

    public static boolean checkEmpty(String p) {
        if (p.length()%2 != 0) {
            return false;
        }

        for (int i = 1; i < p.length(); i+=2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        System.out.println(isMatch("ab", ".*c")); //F
    }
}
