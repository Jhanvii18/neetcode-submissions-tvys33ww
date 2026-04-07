class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int n=cost.length;
        int[] min = new int[n+1];
        min[0]=0;
        min[1]=0;
        for(int i=2;i<=n;i++)
        {
            min[i]=Math.min((cost[i-1]+min[i-1]),(cost[i-2]+min[i-2]));
        }
        return min[n];
    }
}
 