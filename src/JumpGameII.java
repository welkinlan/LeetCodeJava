/**
 * Created by tianlan on 8/25/2014.
 */
public class JumpGameII {
    public int jump(int[] A) {
        if (A==null || A.length==0) return 0;
        int lastReach = 0; //step-1
        int reach = 0; //step
        int step = 0;
        for(int i=0;i<=reach&&i<A.length;i++)
        {
            if(i>lastReach) //need another step
            {
                step++;
                lastReach = reach; //go as far
            }
            reach = Math.max(reach,A[i]+i); //updated farthest
        }
        if(reach<A.length-1)
            return 0;
        return step;
    }
}
