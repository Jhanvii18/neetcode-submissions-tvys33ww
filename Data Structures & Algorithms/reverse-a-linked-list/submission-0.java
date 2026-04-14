/**
 * Definition for singly-linked list.
 * public class ListNode 
   {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) 
       { 
         this.val = val; 
        }
 *     ListNode(int val, ListNode next) 
        { 
           this.val = val; 
           this.next = next; 
        }
 *  }
 */

class Solution 
{
    public ListNode reverseList(ListNode head) 
    {
        ListNode prev=null;
        ListNode current,nextnode;
        current=nextnode=head;
        while(nextnode!=null)
        {
          nextnode=nextnode.next;
          current.next=prev;
          prev=current;
          current=nextnode;
        }
        head=prev;
        return head;
    }
}
