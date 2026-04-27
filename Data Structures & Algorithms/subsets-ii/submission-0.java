class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    void backtrack(int nums[],List<Integer> ans,int i)
    {
        if(i==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        backtrack(nums,ans,i+1);
        int idx=i+1;
        while(idx<nums.length && nums[idx]==nums[idx-1])
        {
            idx++;
        }
        ans.remove(ans.size()-1);
        backtrack(nums,ans,idx);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(),0);
        return res;
    }
}
