// Find cycle in LinkedList

/**
 * Initialize 2 pointer fast and slow.
 * Slow moves 1 step at a time whereas fsat moves 2 steps at a time.
 * Since fast is moving with double the speed of the slow pointer, by the time slow has finished one cycle , fast will be in its second cycle and will colide with the slow pointer.
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
}