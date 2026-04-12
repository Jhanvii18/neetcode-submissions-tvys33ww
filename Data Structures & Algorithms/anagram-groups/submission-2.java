class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(int i =0;i<strs.length;i++)
        {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if(!map.containsKey(sorted))
            {
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}
