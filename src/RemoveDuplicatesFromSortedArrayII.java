import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by tianlan on 9/4/14.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A==null || A.length==0) return 0;
        int idx = 0;
        int count = 0;
        for(int i=0;i<A.length;i++)
        {
            if(i>0 && A[i]==A[i-1])
            {
                count++;
                if(count>=3)
                    continue;
            }
            else
            {
                count = 1;
            }
            A[idx++]=A[i];
        }
        return idx;
    }
}
