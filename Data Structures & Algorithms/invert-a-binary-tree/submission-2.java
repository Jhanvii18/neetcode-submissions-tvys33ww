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
 We are using LinkedList as a Queue
 code without recurssion:
 */

class Solution 
{
    public TreeNode invertTree(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if(root==null)
        return null;
        while(!queue.isEmpty())
        {
            TreeNode pq = queue.poll();
            TreeNode temp = pq.right;
            pq.right=pq.left;
            pq.left= temp;
            if(pq.left!=null)
            queue.add(pq.left);

            if(pq.right!=null)
            queue.add(pq.right);
        }
        return root;
    }
}
