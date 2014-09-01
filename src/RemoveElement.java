/**
 * Created by tianlan on 9/1/14.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if(A==null)
            return 0;
        int len = A.length-1;
        for(int i=0;i<=len;i++)
        {
            if(A[i]==elem)
            {
                A[i--] = A[len--];
            }
        }
        return len+1;
    }
}
