/**
 * Created by tianlan on 8/27/2014.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        //count sort
        if(A==null || A.length==0)
        {
            return 1;
        }
        for(int i=0;i<A.length;i++)
        {
            //put A[i] to where it belongs
            //exchange with the element at that place and examine
            if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i])
            {
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }
        }
        for(int i=0;i<A.length;i++)
        {
            if(A[i]!=i+1)
                return i+1;
        }
        return A.length+1;

    }
}
