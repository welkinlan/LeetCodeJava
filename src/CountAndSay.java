import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tianlan on 4/29/14.
 */
public class CountAndSay {

    static String countAndSay(int n) {
        int c = 1;
        String cur = "1";
        while (c < n) {
            cur = getNext(cur);
            c++;
        }
        return cur;
    }

    static String getNext(String n){
        String s = "";
        int nn = 0;

        char pre = n.charAt(0);
        char cur = n.charAt(0);
        nn = 1;
        for (int i=1; i<n.length(); i++){
            cur = n.charAt(i);
            //System.out.println(cur);
            if (cur == pre){
                nn += 1;
                pre = cur;
            }
            else{
                s = s + nn + pre;
                nn = 1;
                pre = cur;
            }
        }
        s = s + nn + pre;

        return s;
    }



    public static void main(String[] args) {
        System.out.print(countAndSay(5));
    }
}
