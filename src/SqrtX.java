/**
 * Created by tianlan on 8/23/14.
 */
public class SqrtX {
    public static int sqrt(int x) {
        if (x<0) return -1;
        if (x==0) return 0;
        int l=1;
        int r=x/2+1; //r^2 must be larger than x
        while(l<=r){
            int m = (l+r)/2;
            //if x is a real number,
            //when r-l < epsilon, the algo ends
            if (m <= x/m && x/(m+1)<m+1) return m;
            if (x/m < m) r = m - 1;
            else l = m + 1;
        }
        return 0;

    }

    public static void main(String[] args){
        System.out.print(sqrt(5));
    }
}
