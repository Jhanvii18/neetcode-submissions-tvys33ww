class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        if(s.length()!=t.length())
        return false;
        String[] s1 = s.split("");
        String[] t1 = t.split("");
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(t1,s1);
    }
}
//good soln but not optimal , we have to find optimal solution
/**class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        int[] bucket = new int[26];
        s=s.toLowerCase();
        t=t.toLowerCase();
        s=s.replace(" ","");
        t=t.replace(" ","");
        for(int i =0;i<s.length();i++)
        {
            bucket[s.charAt(i)-'a']++;//charcters behave as numbers in operations
        }
        for(int i =0;i<t.length();i++)
        {
            bucket[t.charAt(i)-'a']--;//charcters behave as numbers in operations
        }
        for(int i =0;i<26;i++)
        {
            if(bucket[i]!=0)
            return false;
        }
        return true;
    }
}**/