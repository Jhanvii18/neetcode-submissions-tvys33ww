class Solution 
{
    public String encode(List<String> strs) 
    {
        String encoded="";
        for(String s:strs)
        {
            encoded=encoded+s.length()+"#"+s;
        }
        return encoded;
    }
    public List<String> decode(String str) 
    {
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<str.length())
        {
            int j=i;
            while(str.charAt(j)!='#')
            {
                j++;
            }
            int len=Integer.parseInt(str.substring(i,j));
            j++;
            String s = str.substring(j,j+len);
            i=j+len;
            list.add(s);
        }
        return list;
    }
}
