class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        Set<Integer> set = new HashSet<>();
        for(int n:nums)
        {
            set.add(n);
        }
        int count=0;
        int current_num=0;
        int longest=0;
        for(int n:nums)
        {
            if(!set.contains(n-1))
            {
                count=1;
                current_num=n;
                while(set.contains(current_num+1))
                {
                    count++;
                    current_num=current_num+1;
                }
            }
            if(count>longest)
            {
                longest=count;
            }
        }
        return longest;
    }
}
