class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int left =0;
        int[] res = new int[nums.length-k+1];
        int c=0;
        for(int right = 0; right <= nums.length-k;right++)
        {
            int[] arr = new int[k];
            for(int i =0;i<k;i++)
            {
                arr[i]=nums[left+i];
            }
            Arrays.sort(arr);
            res[c++]=arr[arr.length-1];
            left++;
        }
        return res;
    }
}
