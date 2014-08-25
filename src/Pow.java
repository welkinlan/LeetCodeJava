/**
 * Created by tianlan on 8/25/2014.
 */
public class Pow {
    //recursive
    public double pow(double x, int n) {
        if (n == 0) return 1;
        int exp = Math.abs(n);
        double half = pow(x, exp>>1);
        double res = half * half;
        if ((exp & 1) == 1) res *= x;
        return (n > 0) ? res : 1.0/res;
    }
    //iterative
    public double pow1(double x, int n) {
        double result = 1;
        for (int m = Math.abs(n); m > 0; x *= x, m >>= 1) {
            if ((m & 1) == 1) result *= x;
        }
        return (n >= 0) ? result : 1.0 / (result);
    }

}
