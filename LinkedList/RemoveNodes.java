// Remove nodes with specified values from the Linked List

/**
 * Initiate a dummy pointer to deal with any null pointer exceptions.
 * Use a prev pointer to point to the last valid node.
 * If the node is the node to be deleted, simply move the prev's next pointer to  point to the next of the current node.
 * If the node is valid node as not to be deleted, move the prev's next pointer to point to the current node and move the prev to current node.
 * Move the current pointer. 
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode();
        ListNode prev=dummy;
        while(head!=null){
            if(head.val==val){
                prev.next=head.next;
            }else{
                prev.next=head;
                prev=head;
            }
            head=head.next;
        }
        return dummy.next;
    }
}