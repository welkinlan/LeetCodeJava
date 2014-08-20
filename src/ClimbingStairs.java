/**
 * Created by tianlan on 8/19/14.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        //No matter what n is,  it must be reached  from n-1 or n-2 , then use array to  record unique ways from 0 to end
        int f1 = 1;
        int f2 = 2;
        if(n==1)
            return f1;
        if(n==2)
            return f2;
        for(int i=3;i<=n;i++)
        {
            int f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
