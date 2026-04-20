/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 PS THSI SOLN IS OPTIMAL!!!!1
 */

class Solution 
{
    int height(TreeNode root)
    {
        if(root==null)
        return 0;
        int left = height(root.left);
        int right = height(root.right);

        if(left==-1)
        return -1;

        if(right==-1)
        return -1;

        if(Math.abs(left-right)>1)
        return -1;

        return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) 
    {
       int val= height(root);
       if(val==-1)
       return false;
       else
       return true;
    }
}
