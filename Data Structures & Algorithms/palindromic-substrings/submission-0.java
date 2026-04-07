class Solution 
{
    public int countSubstrings(String s)
    {
        if(s.length()<=1)
        return 1;
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            //even case
            int low =i;
            int high =i;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
            {
                low--;
                high++;
                c++;
            }
            //odd case
            low=i-1;
            high=i;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
            {
                low--;
                high++;
                c++;//count here cause like each palindrome we have to count 
            }
        }
        return c;
    }
}
