// Add Two Numbers II
// You are given two non-empty linked lists representing two non-negative integers. 
// The most significant digit comes first and each of their nodes contains a single digit. 
// Add the two numbers and return the sum as a linked list.

/**
 * Reverse the original linked lists
 * Add the reversed linkedlists
 * Reverse the ans list also
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        return reverseList(addTwoNumber(l1,l2));
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
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
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