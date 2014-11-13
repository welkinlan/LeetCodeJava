/**
 * Created by tianlan on 7/31/2014.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0)
            return 0;
        int res = 0;
        for(int i=0;i<prices.length-1;i++)
        {
            int diff = prices[i+1]-prices[i];
            if(diff>0)
                res += diff;
        }
        return res;
    }


}
