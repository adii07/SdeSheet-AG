// Reorder List / Fold Linked List

/**
 * Uses mid and reverse algorithm
 * Find the mid
 * reverse the list after mid
 * BREAK THE CONNETCTION AFTER MID(LINE 13 very very important) 
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid=middleNode(head);
        ListNode secondHead=reverseList(mid.next);
        mid.next=null;
        while(secondHead!=null){
            ListNode h1=head.next;
            ListNode h2=secondHead.next;
            head.next=secondHead;
            secondHead.next=h1;
            head=h1;
            secondHead=h2;
        }
    }
    
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
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