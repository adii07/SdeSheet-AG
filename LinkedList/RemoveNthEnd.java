// Remove the nth node from the endp of the array.

/**
 * Make use of fast and slow pointers.
 * This time the fast pointer does not move fast in speed but in time.
 * It travels n nodes before the slow pointer.
 * Therefore by the time it reaches the last node, the slow pointer is n-1 nodes behind(N-1th NODE FROM THE END).
 * then we can simply make the next pointer point to the next of the next node to delete the next(Nth) node.
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode Fast=dummy;
        ListNode slow=dummy;
        while(n-->0){
            Fast=Fast.next;
        }
        while(Fast.next!=null){
            Fast=Fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}