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
val at each node = val+(max left+max right)
 we find ulta u like structre for eevry node
 while traversing we cannot coeme back to thenode again
 */

class Solution 
{
    int max=Integer.MIN_VALUE;
    int helper(TreeNode root)
    {
        if(root==null)
        return 0;

        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));

        max=Math.max(max,root.val+left+right);

        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) 
    {
        int ans= helper(root);
        return max;
    }
}
