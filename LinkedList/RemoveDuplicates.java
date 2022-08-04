// Remove duplicates in Linked List.
// 1->1->2->3->3 => 1->2->3
/**
 * Stand at the current node and traverse till the node which is same as the current node.
 * Then node the next of the current node to the next of whatever node the tmp pointer is.
 * Move curr to its next pointer.
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode curr=head;
        while(curr!=null){
            ListNode tmp=curr;
            while(curr.next!=null && curr.next.val==curr.val)
                curr=curr.next;
            tmp.next=curr.next;
            curr=curr.next;
        }
        return head;
    }
}