class Solution 
{
    public String longestPalindrome(String s) 
    {
        if(s.length()<=1)
        {
            return s;
        }
        String lps="";
        String palindrome="";
        for(int i =0;i<s.length();i++)
        {
            //odd case:
            int low = i;
            int high =i;
            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high))
            {
                //till n cause length is always n-1 no like indices
                low--;
                high++;
            }
            palindrome=s.substring(low+1,high);//cause in while before brek it increments
            if(palindrome.length()>lps.length())
            {
                lps=palindrome;
            }

            //even case:
            low=i-1;
            high=i;
            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high))
            {
                low--;
                high++;
            }
            palindrome=s.substring(low+1,high);//cause in while before brek it increments
            if(palindrome.length()>lps.length())
            {
                lps=palindrome;
            }
        }
        return lps;
    }
}
