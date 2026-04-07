class Solution 
{
    public int rob(int[] nums) 
    {
        if(nums.length<2)//if array has one element just return it 
        return nums[0];

        int[] rob = new int[nums.length];
        rob[0]=nums[0];
        rob[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            rob[i]=Math.max((rob[i-2]+nums[i]),rob[i-1]);
        }
        return rob[nums.length-1];
    }
}
