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
  * }
 PROPERTY: IF WE WRITE THE INORDER OF A BST IS ALWAYS IN SORTED ORDER!
 kth largest will be number of nodes-kth smallest
 */

class Solution 
{
    int ans=0;
    int c=0;
    void inorder(TreeNode root,int k)
    {
        if(root==null)
        return;

        inorder(root.left,k);

        c++;

        if(c==k)
        {
        ans=root.val;
        return;
        }

        inorder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) 
    {
        inorder(root,k);
        return ans;
    }
}
