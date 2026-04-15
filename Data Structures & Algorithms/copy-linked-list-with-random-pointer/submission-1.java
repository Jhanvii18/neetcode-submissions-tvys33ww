/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution 
{
    public Node copyRandomList(Node head) 
    {
        if(head == null) return null;
        // adding nodes in between
        Node curr = head;
        while(curr!=null)
        {
            Node newnode = new Node(curr.val);
            newnode.next=curr.next;
            curr.next=newnode;
            curr=newnode.next;
        }
        //adding connection for random pointer 
        curr= head;
        while(curr!=null)
        {
            if(curr.random != null)
                curr.next.random=curr.random.next;

            curr=curr.next.next;
        }
        //removing the original nodes from new ll
        //mistake: do not remove it rather seperate it okay?
        curr=head;
        Node newhead = curr.next;
        Node newcurr = newhead;
        while(curr!=null)
        {
            curr.next=newcurr.next;
            curr=curr.next;
             if(curr != null)
             {
               newcurr.next=curr.next;
               newcurr=newcurr.next;
             }
        }
        return newhead;
    }
}
