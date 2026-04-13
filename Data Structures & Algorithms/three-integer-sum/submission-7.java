class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();// cannot use hashset!!!
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++)
        {
            int left = i + 1;
            int right = nums.length - 1;
            if(i > 0 && nums[i] == nums[i-1]) continue;//chks duplictae for 1st num

            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0)
                {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));//see this line arrays as list
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]) left++;//checks duplicate for 2nd num
                    while(left < right && nums[right] == nums[right+1]) right--;//chceks duplicate for 3rd num
                }
                else if(sum > 0)
                {
                    right--;
                }
                else
                {
                    left++;
                }
            }
        }

        return res;
    }
}