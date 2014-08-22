/**
 * Created by tianlan on 8/20/2014.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        while (m!=0 && n!=0){
            if (A[m-1]>B[n-1]) {
                A[m+n-1]=A[m-1];
                m--;
            }
            else {
                A[m+n-1]=B[n-1];
                n--;
            }
        }
        //m==0, take care already
        if (m==0){
            for (int i=0; i<m+n; i++){
                A[i] = B[i];
            }
        }
    }
}
