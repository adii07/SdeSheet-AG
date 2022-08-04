// Given a head of a linked List and a value
// Arrange the nodes such that all the values smaller than val appear before all the values greater than equal to val.


/**
 * Make 2 dummy head one for smaller nodes and the other for larger
 * Make the smaller point ot the head of the larger linked list.
 * MAKE SURE TO MARK THE LAST NODE OF LARGER AS NULL, OTHERWISE IT WILL LEAD TO CYCLE FORMATION IN LINKEDLIST.
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode sHead=new ListNode();
        ListNode smaller=sHead;
        ListNode lHead=new ListNode();
        ListNode larger=lHead;
        while(head!=null){
            if(head.val<x){
                smaller.next=head;
                smaller=head;
            }else{
                larger.next=head;
                larger=head;
            }
            head=head.next;
        }
        smaller.next=lHead.next;
        larger.next=null;
        return sHead.next;
    }
}