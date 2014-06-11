import java.util.ArrayList;

/**
 * Created by tianlan on 6/10/2014.
 */
public class PermutationSequence {
    //factorial = (n-1)!
    public static String getPermutation(int n, int k) {
        if(n<=0)
            return "";
        k--;
        StringBuilder res = new StringBuilder();
        int factorial = 1;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=2;i<n;i++)
        {
            factorial *= i;
        }
        for(int i=1;i<=n;i++)
        {
            nums.add(i);
        }
        int round = n-1;
        while(round>=0)
        {
            int index = k/factorial;
            k %= factorial;
            res.append(nums.get(index));
            //remove it
            nums.remove(index);
            if(round>0)
                factorial /= round;
            round--;
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.print(getPermutation(4,8));
        System.out.print(8/10);
    }
}
