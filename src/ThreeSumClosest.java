import java.util.Arrays;

/**
 * Created by tianlan on 9/7/14.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length<3) return 0;
        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];
        for (int i=0; i<num.length-2; ++i) {
            // skip duplicates
            if (i>0 && num[i]==num[i-1]) continue;
            for (int j=i+1; j<num.length-1; ++j) {
                // skip duplicates
                if (j>i+1 && num[j]==num[j-1]) continue;
                // binary search for the third element
                int start=j+1, end=num.length-1;
                while (start<=end) {
                    int mid = (start+end)/2;
                    int sum = num[i] + num[j] + num[mid];
                    int diff = sum - target;
                    if ( Math.abs(diff) < Math.abs(res - target) ) {
                        res = sum;
                    }
                    if (diff == 0) { // find the target
                        return res;
                    } else if (diff < 0) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return res;
    }
}
