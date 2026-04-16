/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*complexity: O(N log k)

Where:
	•	N = total nodes
	•	k = number of lists
    Heap always keeps smallest at top(min heap)

    LOVE THIS CODE ABSOLUTE 10/10
    REMEMBER THE CONCEPT OF DUMMY NODES ITS VERY VERY HELFUL
Got you — here are clean, exam-ready POINTWISE NOTES 🔥 (no extra fluff, just what you need to remember)

⸻

📌 MERGE K SORTED LINKED LISTS — NOTES

⸻

🔴 PROBLEM IDEA
	•	Given k sorted linked lists
	•	Merge into one sorted linked list

⸻

🔴 CORE APPROACH (MIN HEAP)
	•	Use PriorityQueue (min heap)
	•	Always pick smallest node among k lists

⸻

🔴 PRIORITY QUEUE NOTES
	•	Stores elements in sorted order (smallest first)
	•	Operations:
	•	add() → O(log k)
	•	poll() → O(log k)
	•	peek() → O(1)
	•	Needs comparator for objects:

(a, b) -> Integer.compare(a.val, b.val)


⸻

❗ VERY IMPORTANT RULE
	•	❌ PriorityQueue does NOT allow null
	•	Always check:

if (node != null)


⸻

🔴 ALGORITHM STEPS
	1.	Edge case

if (lists == null || lists.length == 0) return null;

	2.	Create min heap

PriorityQueue<ListNode> pq

	3.	Add first node of each list

for (ListNode node : lists)
    if (node != null)
        pq.add(node);

	4.	Create dummy node

ListNode dummy = new ListNode(0);
ListNode temp = dummy;

	5.	Process heap

while (!pq.isEmpty())

	6.	Get smallest node

ListNode smallest = pq.poll();

	7.	Attach to result

temp.next = smallest;
temp = temp.next;

	8.	Push next node

if (smallest.next != null)
    pq.add(smallest.next);

	9.	Return result

return dummy.next;


⸻

🔴 KEY INTUITION

Always keep track of the smallest current element among all lists

⸻

🔴 TIME COMPLEXITY
	•	N = total nodes
	•	k = number of lists

👉 O(N log k)

⸻

🔴 SPACE COMPLEXITY

👉 O(k) (heap size)

⸻

🔴 WHY OPTIMAL
	•	Must visit all nodes → O(N)
	•	Choosing smallest among k → log k

👉 Best possible = O(N log k)

⸻

🔴 COMMON MISTAKES

❌ Adding null to PQ
❌ Forgetting smallest.next
❌ Returning dummy instead of dummy.next
❌ Missing comparator
❌ Not handling empty input

⸻

🔴 FINAL ONE-LINE MEMORY

“Pick smallest node → add to result → push its next node → repeat”

*/

class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);//nodes always in ascending order
        for(ListNode node: lists)
        {
            if(node!=null)
            pq.add(node);
        }
        //Insert: 1, 1, 3
        //Heap:
        //1
       /// \
      //1   3
      ListNode dummy = new ListNode(0);
      ListNode temp=dummy;
        while(!pq.isEmpty())
        {
            ListNode smallest = pq.poll();
            temp.next=smallest;
            temp = temp.next;
            if(smallest.next!=null)
            {
                pq.add(smallest.next);
            }
        }
        return dummy.next;
    }
}
