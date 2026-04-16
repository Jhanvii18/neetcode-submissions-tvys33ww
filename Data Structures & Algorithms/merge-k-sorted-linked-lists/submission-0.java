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

*/

class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);//nodes always in ascending order
        for(ListNode node: lists)
        {
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
