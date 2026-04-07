class Solution 
{
    public int numDecodings(String s) 
    {
        int n = s.length();
        int[] waystodecode = new int[n+1];
        waystodecode[0]=1;
        waystodecode[1]=s.charAt(0)=='0'?0:1;//charat 0 see;
        for(int i=2;i<=n;i++)
        {
            int first = Integer.valueOf(s.substring(i-1,i));//check note book 
            int second = Integer.valueOf(s.substring(i-2,i));// substring follows 0 based 

            if(first>0)
            {
                waystodecode[i]=waystodecode[i]+waystodecode[i-1];
            }

            if(second>=10 && second<=26)
            {
                waystodecode[i]=waystodecode[i]+waystodecode[i-2];
            }
        }
        return waystodecode[n];
    }
}
