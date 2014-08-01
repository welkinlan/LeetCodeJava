/**
 * Created by tianlan on 7/31/2014.
 */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int local = 0;
        int global = 0;
        for(int i=0;i<prices.length-1;i++)
        {
            local = Math.max(local+prices[i+1]-prices[i],0);
            global = Math.max(local, global);
        }
        return global;
    }

    public static void main(String[] args){
        int s[] = {9,4,8,7,5,3,5};
        System.out.print(maxProfit(s));

    }
}
