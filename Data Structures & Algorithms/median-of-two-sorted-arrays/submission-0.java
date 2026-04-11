class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int smaller[] = nums1.length<nums2.length?nums1:nums2;
        int larger[] = nums1.length<nums2.length?nums2:nums1;//Use SAME condition for both lines
        int low =0;
        int high=smaller.length;//no minus 1
        int tot=nums1.length+nums2.length;
        while(low<=high)
        {
            int parx=(low+high)/2;
            int pary=(tot+1)/2-parx;//+1 ensures LEFT gets extra element when total is odd
            int l1 = parx==0?Integer.MIN_VALUE:smaller[parx-1];
            int r1 = parx==smaller.length?Integer.MAX_VALUE:smaller[parx];
            int l2 = pary==0?Integer.MIN_VALUE:larger[pary-1];//“Nothing on left → treat as -∞”
            int r2 = pary==larger.length?Integer.MAX_VALUE:larger[pary];//“Nothing on right → treat as +∞”
            if(l1<=r2&&l2<=r1)
            {
                if(tot%2==0)
                {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else
                {
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2)
            {
                high=parx-1;
            }
            else
            {
                low=parx+1;
            }
        }
        return -1;
    }
}
