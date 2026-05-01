class Solution 
{
    List<List<Integer>> res = new ArrayList<>();

    void backtrack(int[] nums, List<Integer> ans)
    {
        if(ans.size() == nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(ans.contains(nums[i])) continue;

            ans.add(nums[i]);

            backtrack(nums, ans);

            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        backtrack(nums, new ArrayList<>());
        return res;
    }
}