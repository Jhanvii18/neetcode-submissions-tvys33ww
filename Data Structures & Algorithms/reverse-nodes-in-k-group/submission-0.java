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
 // done reversing on the first group first then thought abt other
//kth node will always be the new head
//every k elements we have to make it individual ll in order to reverse properly 
//also like 1 to k no so we preserve the link to the next list but remove the link at the last of kth
/*
👉 Step 1: Find k nodes

👉 Step 2: Break the group

👉 Step 3: Reverse + reconnect
prevGroup = connector between old and new list
🔹 POINTERS (IN POINTS)
	•	dummy
	•	Extra node before head
	•	Handles edge cases
	•	Always stays at start
	•	prevGroup
	•	Points before current group
	•	Used to connect previous part to reversed group
	•	Moves to end of reversed group
	•	kth
	•	Finds the k-th node of group
	•	Checks if enough nodes exist
	•	If null → stop
	•	groupStart
	•	First node of group
	•	Becomes last after reverse
	•	Used to connect to next group
	•	nextGroup
	•	Stores next part of list
	•	Prevents losing nodes after breaking
	•	prev
	•	Used in reversing
	•	Becomes new head of reversed group
	•	curr
	•	Traverses nodes while reversing
	•	temp
	•	Stores next node temporarily
	•	Prevents losing link

⸻

🔹 FLOW (IN POINTS)
	1.	Find kth node
	2.	Mark groupStart and nextGroup
	3.	Break the group (kth.next = null)
	4.	Reverse the group
	5.	Connect:
	•	prevGroup.next = newHead
	•	groupStart.next = nextGroup
	6.	Move prevGroup = groupStart
	7.	Repeat

⸻

🔹 ONE LINE MEMORY

👉 Find → Break → Reverse → Connect → Move
*/

class Solution 
{
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prevnode = dummy;
        ListNode kth=null;
        while(true)
        {
            kth=prevnode;
        for(int i=0;i<k;i++)
        {
            if(kth.next==null)
            return dummy.next;
            kth=kth.next;
        }
        ListNode start = prevnode.next;
        ListNode nextgroupstart = kth.next;
        kth.next=null;
        ListNode curr=start;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        prevnode.next=prev;
        start.next=nextgroupstart;
        prevnode=start;
        }
    }
}
