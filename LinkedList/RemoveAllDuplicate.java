// Remove All the duplicate nodes in Linked List.
// 1->1->2->3->3->4 => 2->4



/**
 * When we encounter a unique node, add it to the chain and makr it as the prev node
 * When we encounter duplicates, we traverse through the duplicates, and move to the next node which is not same as the prev
 * We don't directly add the next node to the chain(prev.next), this is because the next node might also be a series of duplicates and we need to check that
 * We use a flag to mark the presence of any duplicate in the list
 * IF DUPLICATES ARE PRESENT MARK THE NEXT OF THE PREV TO POINT TO NULL
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode();
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null){
            boolean flag=false;
            while(curr.next!=null && curr.val==curr.next.val){
                curr=curr.next;
                flag=true;
            }
            if(!flag){
                prev.next=curr;
                prev=curr;
            }
            if(flag) prev.next=null;
            curr=curr.next;
        }
        return dummy.next;
    }
}


/**
 * Simillar approach but without the flags.
 * We use a curr and a prev.
 * Initially the head is the curr node and the prev is a dummy node pointing to the curr node.
 * We start to traverse and skip the duplicates node if present
 * If the next of the pointer is the current node, it means that there we no duplicates present.
 * In this case we simply add the node to the chain and move to the node.
 * If the next of the prev is not equal to the curr node, it means there we duplicates and we had to traverse further.
 * In this case we make the next of the curr as the next of prev and move the curr to the same.
 * Mark how incase of duplicates we donot update the prev pointer, just the next of the prev.
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode();
        ListNode prev=dummy;
        ListNode curr=head;
        prev.next=curr;
        while(curr!=null){
            while(curr.next!=null && curr.val==curr.next.val){
                curr=curr.next;
            }
            if(prev.next!=curr){
                prev.next=curr.next;
                curr=prev.next;
            }else{
                prev=prev.next;    
                curr=curr.next;
            }
            
        }
        
        return dummy.next;
    }
}