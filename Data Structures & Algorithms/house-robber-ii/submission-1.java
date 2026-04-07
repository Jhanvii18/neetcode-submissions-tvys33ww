class Solution 
{
    public int rob(int[] nums) 
    {
        int n = nums.length;

        if(n == 1) return nums[0];
        
        int[] robfirst = new int[n-1];
        int[] roblast = new int[n-1];

        int k=0;
        for(int i=0;i<n-1;i++)
        {
            robfirst[k]=nums[i];
            roblast[k]=nums[i+1];
            k++;
        }
        int rf = rob_individual(robfirst);
        int rl = rob_individual(roblast);

        return Math.max(rf,rl);
    }
    int rob_individual(int[] number)
    {
        if(number.length<2)//if array has one element just return it 
        return number[0];

        int n = number.length;
        int[] rob = new int[n];
        rob[0]=number[0];
        rob[1]=Math.max(number[0],number[1]);
        for(int i=2;i<n;i++)
        {
            rob[i]=Math.max((rob[i-2]+number[i]),rob[i-1]);
        }
        return rob[n-1];
    }
}
