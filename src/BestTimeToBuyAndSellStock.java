/**
 * Created by tianlan on 7/31/2014.
 */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int res = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i] < min) min = prices[i];
            else if ((prices[i]-min) > res){
                res = (prices[i]-min);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int s[] = {9,4,8,7,5,3,5};
        System.out.print(maxProfit(s));

    }
}
