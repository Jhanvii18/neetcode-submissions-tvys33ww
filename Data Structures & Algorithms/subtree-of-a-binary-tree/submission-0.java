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
 USEEE ONLY POST,PRE OR INORDER TRAVERSAL DO NOT USE LEVEL ORDER CAUSE IT WONT GIVE THE CORRECT ANSWE
 TAKE IN ACCOUNT THE NULL VALUES AS WELL OF THE TREE
 */

class Solution 
{  
    String postorder(TreeNode root,StringBuilder sb)
    {
        if(root==null)
        {
        sb.append("null");
        return sb.toString();
        }
        postorder(root.left,sb);
        postorder(root.right,sb);
        sb.append(root.val);
        return sb.toString();
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String s1=postorder(root,sb1);
        String s2=postorder(subRoot,sb2);
        if(s1.contains(s2))
        return true;
        else
        return false;
    }
}
