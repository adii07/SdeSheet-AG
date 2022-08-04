// Given a linkedlist with nodes with a next,prev and child pointer.
// Flatten the list in such a way that the child nodes come before the next nodes in the flatten list.

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    Node dummy=new Node();
    Node prevNode=null;
    public Node flatten(Node head) {
        Node ans=dummy;
        traverse(head);
        return ans.next;
    }
    
    public void traverse(Node head){
        while(head!=null){
            Node temp=head.next;
            head.prev=prevNode;
            Node child=head.child;
            head.child=null;
            
            dummy.next=head;
            dummy=dummy.next;
            prevNode=dummy;
            if(child!=null) traverse(child);
            head=temp;
        }
    }
}


// Iterative

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
        
        Node curr = head;
        while(curr!=null){
            if(curr.child==null){
            //case 1 :- If curr.child == null that means we just need to go to next node
            curr=curr.next;
            continue;
                
            }
            
            //case 2:- got child , find the tail of the child and link it to curr.next
            Node child = curr.child;
            
            // Find the tail of the child
            while(child.next!=null){
                child=child.next;
            }
            
             // Connect tail with curr.next, if it is not null
            child.next = curr.next;
            if(curr.next!=null){
                curr.next.prev = child;
            }
            //Connect curr with curr.child, and remove curr.child
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
            
        }
        
        return head;
    }
    
    
}