/**
 * Created by tianlan on 8/24/14.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        if((A.length+B.length)%2==1)
            return helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1);
        else
            return (helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2)
                    +helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1))/2.0;
    }

    private int helper(int A[], int B[], int i, int i2, int j, int j2, int k)
    {
        int m = i2-i+1;
        int n = j2-j+1;
        if(m>n)
            return helper(B,A,j,j2,i,i2,k);
        if(m==0)
            return B[j+k-1];
        if(k==1)
            return Math.min(A[i],B[j]);
        int posA = Math.min(k/2,m);
        int posB = k-posA;
        if(A[i+posA-1]==B[j+posB-1])
            return A[i+posA-1];
        else if(A[i+posA-1]<B[j+posB-1])
            return helper(A,B,i+posA,i2,j,j+posB-1,k-posA);
        else
            return helper(A,B,i,i+posA-1,j+posB,j2,k-posB);
    }
}
