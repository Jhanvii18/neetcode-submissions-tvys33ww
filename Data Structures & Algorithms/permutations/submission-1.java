class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    void backtrack(int[] nums,List<Integer> ans,boolean[] used)
    {
        if(ans.size()==nums.length)
        {
            res.add(new ArrayList<>(ans));
        }
        for(int i =0;i<nums.length;i++)
        {
            if(used[i]==true)
            continue;

            ans.add(nums[i]);
            used[i]=true;

            backtrack(nums,ans,used);

            ans.remove(ans.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) 
    {
         boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used);
        return res;
    }
}
