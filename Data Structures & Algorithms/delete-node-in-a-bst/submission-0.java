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
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        if(root==null)
        return null;
        else if(root.val>key)
        {
            root.left  = deleteNode(root.left,key);
        }
        else if(root.val<key)
        {
            root.right = deleteNode(root.right,key);
        }
        else
        {
            if(root.right==null)//only left child present
            return root.left;

            else if(root.left==null)//only right child present
            return root.right;

            else//2 children
            {
                TreeNode curr = root;
                curr=curr.right;
                while(curr.left!=null)
                {
                    curr=curr.left;
                }
                root.val=curr.val;
                root.right=deleteNode(root.right,curr.val);
            }
        }
        return root;
    }
}