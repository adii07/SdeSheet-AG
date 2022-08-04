// Reverse Linked List II
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
// Input: head = [1,2,3,4,5], left = 2, right = 4 Output: [1,4,3,2,5]


/**
 * FIND THE LEFT NODE AND MARK IT.
 * NOW START THE REVERSAL.
 * AFTER REVERSING, MARK THE NEW HEAD AS THE NEXT OF THE PREV NODE(prev to the left node)
 * THE TMP NODE, THE NODE NEXT TO THE RIGHT IS MARKED AS THE NEXT OF THE LEFT NODE.
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode();
        ListNode Prev=dummy;
        ListNode curr=head;
        int count=1;
        while(count<left){
            Prev.next=curr;
            Prev=curr;
            curr=curr.next;
            count++;
        }
        ListNode z=curr;
        ListNode tmp=null;
        while(count<=right){
            ListNode next=curr.next;
            curr.next=tmp;
            tmp=curr;
            count++;
            curr=next;
        }
        Prev.next=tmp;
        z.next=curr;
        return dummy.next;
    }
}