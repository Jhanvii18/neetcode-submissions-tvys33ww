//“ArrayList at every index can have more than 1 value but normal array cannot”
class Solution 
{
    public int[] topKFrequent(int[] nums, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int n = nums[i];
            map.put(n,map.getOrDefault(n,0)+1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];//we add[] in syntax cause size we a fixing
        for(int key:map.keySet())
        {
            int freq = map.get(key);
            if(bucket[freq]==null)
            {
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);//added at index
        }
        int[] res = new int[k];
        int idx=0;
        for(int i=bucket.length-1;i>=0;i--)
        {
            if(bucket[i]!=null)
            {
                for(int j = 0;j<bucket[i].size();j++)
                {
                    res[idx++]=bucket[i].get(j);//gotten from index
                }
                if(idx==k)
                return res;
            }
        }
        return res;
    }
}
