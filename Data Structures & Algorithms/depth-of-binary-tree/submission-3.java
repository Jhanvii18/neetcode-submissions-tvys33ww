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
    public int maxDepth(TreeNode root) 
    {
        if(root==null)
        return 0;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        int depth=0;
        while(!pq.isEmpty())
        {
            int size = pq.size();
            for(int i =0;i<size;i++)
            {
                TreeNode node = pq.poll();
                if(node.left!=null)
                {
                    pq.add(node.left);
                }
                if(node.right!=null)
                {
                    pq.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
