/**
 * Created by tianlan on 8/31/14.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if(A==null || A.length==0)
            return false;
        int l = 0;
        int r = A.length-1;
        while(l<=r)
        {
            int m = (l+r)/2;
            if(A[m]==target)
                return true;
            if(A[m]>A[l])
            {
                if(A[m]>target && A[l]<=target)
                {
                    r = m-1;
                }
                else
                {
                    l = m+1;
                }
            }
            else if(A[m]<A[l])
            {
                if(A[m]<target && A[r]>=target)
                {
                    l = m+1;
                }
                else
                {
                    r = m-1;
                }
            }
            else
            {
                l++;
            }
        }
        return false;
    }
}
