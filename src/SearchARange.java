/**
 * Created by tianlan on 5/13/2014.
 */
public class SearchARange {
    public int[] searchRange(int[] A, int target) {
        int range[] = {-1,-1};
        int a = 0;
        int b = A.length;
        while(a <= b) {
            int m = (a + b) / 2;
            if (m >= A.length) break;
            if (target > A[m]) {
                a = m + 1;
            } else if (target < A[m]) {
                b = m - 1;
            } else {
                int n = m;
                while (n>=0 && A[n] == target) {
                    n -= 1;
                }
                range[0] = n+1;
                n=m;
                while (n<A.length && A[n] == target) {
                    n += 1;
                }
                range[1] = n-1;
                break;
            }
        }
        return range;
    }
}
