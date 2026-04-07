class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left =0;
        int max=0;
        for(int right=0;right<n;right++)
        {
            char ch = s.charAt(right);
            while(set.contains(ch))
            {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
