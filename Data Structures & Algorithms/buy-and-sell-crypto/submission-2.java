class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int min =prices[0];
        int maxprofit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min =prices[i];
            }
            else
            {
                maxprofit=Math.max(maxprofit,prices[i]-min);
            }
        }
        return maxprofit;
    }
}
