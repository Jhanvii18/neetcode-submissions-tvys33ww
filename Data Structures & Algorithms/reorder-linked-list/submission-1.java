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
//find midpoint - floyd warshall algo. if fast reaches the end then slow pointer
//points the middle element
//divide ll into 2 differnet portions
// reverse the second half
//join them again
class Solution 
{
    public void reorderList(ListNode head) 
    {
        //finding mid
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow=slow.next;
        }
        ListNode mid = slow.next;//slow.next not slow
        slow.next=null;//Cut the list into two parts
        //ie now the first part end points to null

        //reversing second half
        ListNode curr,prev;
        curr=mid;
        prev=null;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        //joining 
        ListNode p1=head;
        ListNode p2=prev;
        while(p1!=null && p2!=null)
        {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;

            p1.next=p2;
            p2.next=t1;

            p1=t1;
            p2=t2;
        }
    }
}
