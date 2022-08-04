// Given 2 numbers represented as linked list in reverse order(567=> 7->6->5)
// Add the 2 given linked list

/**
 * While either of the linked list is not empty or the carry is not zero keep on addding the numbers.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode prev=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry=sum>=10?1:0;
            prev.next=new ListNode(sum%10);
            prev=prev.next;
        }
        return dummy.next;
    }
}