//can add only if count of closing parantehesis is less tahn count of opening paranthesis
//close < open
//valid if open count==close count
class Solution 
{
    List<String> res = new ArrayList<>();
    void backtrack(int open,int close,String s,int n)
    {
        if(open==n && close==n)
        {
            res.add(s);
        }
        if(open<n)
        {
            backtrack(open+1,close,s+"(",n);
        }
        if(close<open)
        {
            backtrack(open,close+1,s+")",n);
        }
    }
    public List<String> generateParenthesis(int n)
    {
        backtrack(0,0,"",n);
        return res;
    }
}
