class Solution 
{
    public int maxArea(int[] heights) 
    {
        int l=0;
        int r=heights.length-1;
        int maxwater=0;
        while(l<r)
        {
            int width=r-l;
            int h=Math.min(heights[r],heights[l]);
            int water=h*width;
            maxwater=Math.max(maxwater,water);
            if(heights[r]>heights[l])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return maxwater;
    }
}
