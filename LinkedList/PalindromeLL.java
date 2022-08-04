// Check if the linked list is palindrome or not.

/**
 * The approach is simple.
 * We just find the mid, reverse the list after the mid and start to compare the nodes from the head and the node after the mid.
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode midNode=mid(head);
        midNode.next=reverse(midNode.next);
        midNode=midNode.next;
        while(midNode!=null){
            if(head.val!=midNode.val) return false;
            head=head.next;
            midNode=midNode.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return prev;
    }
    public ListNode mid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}