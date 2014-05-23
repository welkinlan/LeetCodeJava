import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 5/23/2014.
 */
public class Combinations {

    static int N;
    static int K;


    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n==0 || k==0 || k>n) return null;
        N = n;
        K = k;
        ArrayList<ArrayList<Integer>> combination = new ArrayList<ArrayList<Integer>>();
        for (int first=1; first<n-k ; first++){
            for (int second=first+1; second<=n; second++){
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(first);item.add(second);
                combination.add(item);
            }
        }

        return combination;
    }

    public static void recursiveOutput(int i, String s){
        if (i == chars.length){
            result.add(s);
        }
        else{
            List<Character> options = digitChar.get(chars[i]);
            for (char c : options){
                recursiveOutput(i+1, s+c);
            }
        }
    }

    public static void main(String[] args){

    }
}
