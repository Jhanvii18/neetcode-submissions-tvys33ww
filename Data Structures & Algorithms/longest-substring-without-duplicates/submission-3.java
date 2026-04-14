class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int max_len =0;
        for(int i =0;i<s.length();i++)
        {
            Set<Character> set = new HashSet<>();
            int idx = i;
            int cur_len=0;
            while(idx<s.length())
            {
                if(!set.contains(s.charAt(idx)))
                {
                    set.add(s.charAt(idx));
                    idx++;
                    cur_len++;
                }
                else
                {
                    break;
                }
            }
            max_len=Math.max(cur_len,max_len);
        }
        return max_len;
    }
}
