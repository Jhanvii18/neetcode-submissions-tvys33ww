class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int max = piles[0];
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]>max)
            {
                max=piles[i];
            }
        }
        int high = max;// when bpth these pointers meet its the optimum values so only return low 
        int low =1;//speed cant be 0
        while(low<=high)
        {
            int speed = (high+low)/2;
            int sum =0;
            for(int i =0;i<piles.length;i++)
            {
                int p = piles[i];
                sum = sum+((int)Math.ceil((double)p/speed));
                //or use (p+speed-1/speed)
            }
            if(sum<=h)
            {
               high=speed-1;
            }
            else
            {
               low=speed+1;
            }
        }
        return low;
    }
}
