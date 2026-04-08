class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int rowidx=findrow(matrix,target);
        if(rowidx==-1)
        {
            return false;
        }
        boolean val=findcol(rowidx,matrix,target);
        if(val)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    int findrow(int[][]matrix,int target)
    {
        int low=0;
        int high = matrix.length-1;//length of row
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1])
            {
                return mid;
            }
            else if(matrix[mid][0]>target)
            {
               high = mid-1;
            }
            else if(matrix[mid][0]<target)
            {
                low=mid+1;
            }
        }
        return -1;
    }
    boolean findcol(int rowidx,int matrix[][],int target)
    {
        int low =0;
        int high = matrix[0].length;//length of column
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(matrix[rowidx][mid]==target)
            {
                return true;
            }
            else if(matrix[rowidx][mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return false;    
    }
}
