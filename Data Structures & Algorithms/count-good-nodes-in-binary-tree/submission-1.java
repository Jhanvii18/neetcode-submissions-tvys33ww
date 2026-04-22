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
 */

class Solution 
{
    int c=0;
    void helper(TreeNode root,int max)
    {
        if(root==null)
        return;

        if(root.val>=max)
        c++;

        max=Math.max(max,root.val);

        helper(root.left,max);
        helper(root.right,max);
    }
    public int goodNodes(TreeNode root) 
    {
        helper(root,root.val);
        return c;
    }
}
