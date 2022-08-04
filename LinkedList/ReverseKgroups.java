// Reverse Nodes in k-Group
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode();

        ListNode prev=dummy; // points to the previous node
        ListNode curr=head;  // points to the current node

        while(curr!=null){   // traverse till list is not empty

            int tmp=k;
            ListNode tmpCurr=curr;  // tmpcurr stores the current node in the list, stores the node that comes after kth node
            int count=0;
            
            while(tmpCurr!=null && tmp-->0){
                tmpCurr=tmpCurr.next;
                count++;  // Keeps count of the number of elements that have been traversed
            }
            
            if(count==k){ // if there are k elements present to be reversed.
                prev.next=reverseList(curr,k); // add the kth node to the chain in reversed order 
                prev=curr;  // the prev pointer now points to the current array;
            }else{    // If k elemets are not present directly assign the current node to the chain
                prev.next=curr; 
            }
            curr=tmpCurr; // the node next to the kth node is now the new curr array,i.e., the traversal now resumes from here
        }
        
        return dummy.next;
    }
    
    public ListNode reverseList(ListNode node,int k){
        ListNode prev=null;
        ListNode curr=node;
        while(k-->0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}