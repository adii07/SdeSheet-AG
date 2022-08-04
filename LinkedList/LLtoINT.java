// Convert a bianry number represented as a linked list to integer format.
// Most significant bit is at the head.
// eg. 1->0->1 = 5

/**
 * Since to convert binary too int we raise the set bit to 2 to it's power of the index and add the set bit values.
 * Since the head is the most significant bit, it will have the max power.
 * Therefore we first need to find the size of the Linked List to be able to perform the operation.
 * As we move one step forward we decrease the power by one, till we reach the least significant bit as it's power is zero.
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int size=getSize(head);
        size--;
        int ans=0;
        while(head!=null){
            int val=head.val;
            if(val==1) ans+=Math.pow(2,size);
            size--;
            head=head.next;
        }
        return ans;
    }
    
    public int getSize(ListNode head){
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        return size;
    }
}