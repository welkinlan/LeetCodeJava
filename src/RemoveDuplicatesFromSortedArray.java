/**
 * Created by tianlan on 8/19/2014.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A==null || A.length==0) return 0;
        int index = 1;
        for (int i=1; i<A.length; i++){
            if (A[i] != A[i-1]){
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }
}
