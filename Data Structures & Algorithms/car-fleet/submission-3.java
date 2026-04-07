class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n=position.length;
        Integer[] ind = new Integer[n];
        for(int i =0;i<n;i++)
        {
            ind[i]=i;
        }
        Arrays.sort(ind,(a,b)->position[b]-position[a]);
        double prev=0.0;
        int fleets=0;
        for(int i:ind)
        {
            double time = (double)(target-position[i])/speed[i];
            if(time>prev)
            {
                fleets++;
                prev=time;
            }
        }
        return fleets;
    }
}
