// Reverse a given Linked List

/**
 * Iterative solution with the help of previous pointer.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}


/**
 * Recursive solution
 * Send the parent along with the recusive call
 * recursively call the same helper function for the child node
 * if child is null,i.e, reached the end return the prev(the last node)
 * in the preorder reverse the direction of the edges.
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(head,null);
    }
    
    public ListNode helper(ListNode curr,ListNode prev){
        if(curr==null) return prev;
        ListNode tmp=helper(curr.next,curr);
        curr.next=prev;
        return tmp;
    }
}