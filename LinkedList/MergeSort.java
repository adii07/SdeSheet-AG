/**
 * Find the mid
 * Break the list
 * Sort the 2 halves recursively
 * merege the 2 sorted halves to get the list
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid=midNode(head);
        ListNode next=mid.next;
        mid.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(next);
        ListNode ans=mergeList(left,right);
        return ans;
    }
    public ListNode midNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeList(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode();
        ListNode prev=dummy;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                prev.next=head1;
                head1=head1.next;
            }else{
                prev.next=head2;
                head2=head2.next;
            }
            prev=prev.next;
        }
        prev.next=head1!=null?head1:head2;
        return dummy.next;
    }
}