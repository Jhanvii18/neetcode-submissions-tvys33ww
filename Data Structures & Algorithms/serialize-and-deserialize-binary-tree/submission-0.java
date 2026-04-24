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

public class Codec 
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root==null)
        return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node==null)
            {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data.equals(""))
        return null;

        String[] nodes = data.split(",");
        int n = nodes.length;

        int i=0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[i++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode parent = q.poll();
            if(i<n && !nodes[i].equals("null"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left=left;
                q.add(left);
            }
            i++;

            if(i<n && !nodes[i].equals("null"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right=right;
                q.add(right);
            }
            i++;
        }
        return root;
    }
}
