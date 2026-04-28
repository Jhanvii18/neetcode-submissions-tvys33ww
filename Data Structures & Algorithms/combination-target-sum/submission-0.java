class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    void backtrack(List<Integer> list,int target,int nums[],int i)
    {
        if(i>=nums.length || target<0)
        {
            return;
        }
        if(target==0)
        {
            if(!set.contains(list))
            {
                res.add(new ArrayList<>(list));
                set.add(list);
                return;
            }
            else
            {
                return;
            }
        }
        list.add(nums[i]);
        backtrack(list,target-nums[i],nums,i+1);
        backtrack(list,target-nums[i],nums,i);
        list.remove(list.size()-1);
        backtrack(list,target,nums,i+1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        backtrack(new ArrayList<>(),target,nums,0);
        return res;
    }
}
