class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        String s = strs[0];
        String pre="";
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            for(int j=0;j<strs.length;j++)
            {
                if(i>=strs[j].length()||strs[j].charAt(i)!=ch)
                {
                    return pre;
                }
            }
            pre=pre+ch;
        }
        return pre;
    }
}