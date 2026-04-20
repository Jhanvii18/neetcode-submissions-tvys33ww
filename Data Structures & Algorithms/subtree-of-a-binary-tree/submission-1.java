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
 Perfect — this is the best way to learn 🔥
Here are your exact mistake-based memory points (keep this as revision 👇)

⸻

🧠 🌳 TREE SERIALIZATION — MUST REMEMBER

⸻

🔥 1. BASE CASE = HANDLE + STOP

👉 Rule:

if(root == null)
{
    sb.append("#,");
    return;
}

✅ Always:

* Mark null
* RETURN immediately

❌ Never continue recursion after null

⸻

🔥 2. ALWAYS INCLUDE NULL MARKERS

👉 Without this:
❌ Different trees look same

💡 Remember:

“Structure matters, not just values”

⸻

🔥 3. ALWAYS USE SEPARATORS

sb.append(root.val).append(",");

👉 Why?

* Avoid ambiguity (1 vs 11)

💡 Memory line:

“Values must not merge”

⸻

🔥 4. NEVER IGNORE RECURSION RESULTS

❌ Wrong mindset:

postorder(left);
postorder(right);

👉 That’s fine ONLY if:

* Using shared StringBuilder

💡 Otherwise:

“Recursion must either RETURN or ACCUMULATE”

⸻

🔥 5. ONE BUILDER PER TREE

StringBuilder sb1 = new StringBuilder();
StringBuilder sb2 = new StringBuilder();

❌ Never reuse same builder

💡 Memory line:

“Two trees → two strings”

⸻

🔥 6. RETURN TYPE CLARITY

👉 If using StringBuilder:

* Prefer void

❌ Returning string every call = confusing

💡 Memory:

“Builder accumulates, not returns”

⸻

🔥 7. ORDER MUST BE CONSISTENT

👉 Choose one:

* Preorder ✅ (most common)
* Postorder ✅
* Inorder ⚠ risky sometimes

💡 Memory:

“Same traversal for both trees”

⸻

🔥 8. FINAL CHECK

s1.contains(s2)

👉 Works ONLY IF:

* null included ✅
* separator included ✅

⸻

⚡ YOUR FINAL CHECKLIST (SUPER IMPORTANT)

Before submitting:

✔ Null handled + returned
✔ Null marker added (#,)
✔ Separator added (,)
✔ Separate builders used
✔ Same traversal used
✔ No ambiguity

⸻

💯 ONE-LINE MASTER RULE

“Serialize tree with structure (nulls + separators), then use substring match.”

⸻

🔥 Bonus (exam/interview killer line)

If asked “why null?”:

👉 Say:

“Without null markers, different tree structures can produce identical traversals.”

⸻

If you want next:

* I’ll give same problem without strings (most optimal)
* Or a trick to solve ALL tree comparison problems easily
 */

//remember to add null also in the ordering 
class Solution 
{  
    void postorder(TreeNode root,StringBuilder sb)
    {
        if(root==null)
        {
        sb.append("null");
        return;//remeber this 
        }
        postorder(root.left,sb);
        postorder(root.right,sb);
        sb.append(root.val);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        postorder(root,sb1);
        postorder(subRoot,sb2);
        String s1=sb1.toString();
        String s2=sb2.toString();
        if(s1.contains(s2))
        return true;
        else
        return false;
    }
}
