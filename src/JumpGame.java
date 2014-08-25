/**
 * Created by tianlan on 8/24/14.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A==null || A.length==0) return false;
        int max = 0;
        for (int i=0; i<=max && i<A.length; i++){
            max = Math.max(A[i]+i,max); //local and max optimal
        }
        if (max<A.length-1) return false;
        return true;

    }
}
