import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 5/23/2014.
 */
public class Combinations {

    static int N;
    static int K;
    static ArrayList<ArrayList<Integer>> combination;


    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n==0 || k==0 || k>n) return null;
        N = n;
        K = k;
        combination = new ArrayList<ArrayList<Integer>>();
        for (int now=1; now <= N-K+1; now++){
            //System.out.println("-------");
            minusKCombination(new ArrayList<Integer>(), now, K);
        }
        //System.out.println("-----result------");
        return combination;
    }

    public static void minusKCombination(ArrayList<Integer> tempAL, int now, int k){
        tempAL.add(now);
        //System.out.println(tempAL+",k="+k);
        if (k==1) { //no other options available
            combination.add(tempAL);
            //System.out.println(tempAL);
        }
        else {
            for (int next=now+1; next<=N-k+2; next++){
                ArrayList<Integer> newAL = new ArrayList<Integer>(tempAL); //create a deep copy of the existing arraylist
                minusKCombination(newAL, next, k-1);
            }
        }
    }

    public static void main(String[] args){
        System.out.print(combine(5,2));
    }
}
