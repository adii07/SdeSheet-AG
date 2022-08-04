//Middle of the linked List

/*
-> Check if head or next node to head is null or not.
-> If yes return head, else continue.
-> Set a fast and a slow pointer.
-> Slow moves one step at a time.
-> Fast Moves two steps at a time.
-> Run a loop till either fast or the next pinter to fast is not null.
-> return the slow pointer at the end.
-> This works as since slow moves at half the speed, by the time fast reaches the end of the list, slow reaches the middle.
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}