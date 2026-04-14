class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int buy_price=prices[0];
        int current_profit=0;
        int max_profit=0;
        for(int i =1;i<prices.length;i++)
        {
            if(prices[i]<buy_price)
            {
                buy_price=prices[i];
            }
            current_profit=prices[i]-buy_price;
            max_profit=Math.max(max_profit,current_profit);
        }
        return max_profit;
    }
}
