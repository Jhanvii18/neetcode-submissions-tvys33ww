class Solution 
{
    public String minWindow(String s, String t) 
    {
        int[] freq = new int[128];

        for(char c : t.toCharArray())
        {
            freq[c]++;
        }

        char[] schar = s.toCharArray();

        int found = 0;
        int left = 0;
        int tofind = t.length();
        String res = "";
        int minlen = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++)
        {
            char ch = schar[right];

            freq[ch]--;

            if(freq[ch] >= 0)
            {
                found++;
            }

            while(found == tofind)
            {
                if((right - left + 1) < minlen)
                {
                    minlen = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                freq[schar[left]]++;

                if(freq[schar[left]] > 0)
                {
                    found--;
                }

                left++;
            }
        }

        return res;
    }
}