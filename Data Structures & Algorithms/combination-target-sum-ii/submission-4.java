class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    void backtrack(int[] candidates,int target,int i,List<Integer> list)
    {
       if(target == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        if(i>=candidates.length || target<0)
        {
            return;
        }
        list.add(candidates[i]);
        backtrack(candidates,target-candidates[i],i+1,list);
        list.remove(list.size()-1);
        int next = i + 1;
        while(next < candidates.length && candidates[next] == candidates[i])
        {
            next++;
        }
        backtrack(candidates, target, next, list);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>());
        return res;
    }
}
