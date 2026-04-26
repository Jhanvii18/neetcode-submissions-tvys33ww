class Solution 
{
    List<List<Integer>> result = new ArrayList<>();
    void backtrack(int[] nums,List<Integer> ans,int i)
    {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(ans));
            return;
        }
            ans.add(nums[i]);
            backtrack(nums,ans,i+1);
            ans.remove(ans.size()-1);
            backtrack(nums,ans,i+1);
    }
    public List<List<Integer>> subsets(int[] nums)
    {
        backtrack(nums,new ArrayList<>(),0);
        return result;
    }
}
