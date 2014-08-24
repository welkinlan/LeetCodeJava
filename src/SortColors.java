/**
 * Created by tianlan on 8/23/14.
 */
public class SortColors {
    public void sortColors(int[] A) {
        if (A==null || A.length==0) return;
        int s0 = 0, s1 = 0;
        for (int i=0; i<A.length; i++){
            if(A[i]==0){
                A[i] = 2; //add 2, push back last 2 pos
                A[s1++] = 1; //add 1, push back last 1 pos
                A[s0++] = 0; //add 0, push back last 0 pos
            }
            else if(A[i]==1){
                A[i] = 2;
                A[s1++] = 1;
            }
        }
    }
}
