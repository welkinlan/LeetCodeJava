/**
 * Created by tianlan on 9/4/14.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if(x==Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int num = Math.abs(x);
        int res = 0;
        while(num!=0)
        {
            if(res>(Integer.MAX_VALUE-num%10)/10)
                return x>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res*10+num%10;
            num /= 10;
        }
        return x>0?res:-res;
    }
}
