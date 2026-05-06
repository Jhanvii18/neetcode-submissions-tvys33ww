class Solution 
{
    List<List<String>> res = new ArrayList<>();
    void backtrack(List<String> ans,String s)
    {
        if(s.length()==0)
        {
            res.add(new ArrayList<>(ans));
        }
        for(int i=0;i<s.length();i++)
        {
            String ss = s.substring(0,i+1);
            if(ispalindrome(ss))
            {
                ans.add(ss);
                backtrack(ans,s.substring(i+1));
                ans.remove(ans.size()-1);
            }
        }
    }
    boolean ispalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            return false;

            start++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) 
    {
        backtrack(new ArrayList<>(), s);
        return res;
    }
}
