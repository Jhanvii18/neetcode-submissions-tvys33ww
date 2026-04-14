class Solution 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        int[] freq = new int[26];
        for(int i =0;i<s1.length();i++)
        {
            freq[s1.charAt(i)-'a']++;
        }
        int k = s1.length();//window size
        for(int i =0;i<=s2.length()-k;i++)
        {
            int[] windfreq = new int[26];
            int idx=i;
            int count=0;
            while(count<k)
            {
                windfreq[s2.charAt(idx)-'a']++;
                idx++;
                count++;
            }
            if(Arrays.equals(windfreq,freq))
            {
                return true;
            }
        }
        return false;
    }
}
