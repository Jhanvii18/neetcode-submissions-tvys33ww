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
