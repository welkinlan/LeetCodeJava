/**
 * Created by tianlan on 8/24/14.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0) return 0;
        int min = Math.min(m,n);
        int max = Math.max(m,n);
        int array[] = new int[min];
        array[0] = 1;
        for (int i=0; i<max; i++){
            for (int j=1; j<min; j++){
                array[j] += array[j-1];
            }
        }
        return array[min-1];
    }
}
