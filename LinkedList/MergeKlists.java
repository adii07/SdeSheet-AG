// Merge K sorted lists
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.


/**
 * Divide the array into equal parts in each part.
 * Divide till only 1 element is left in the array.
 * Start merging 2 list at a time
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length-1);
    }
    
    public ListNode mergeKLists(ListNode[] lists,int start,int end){
        if(start>end) return null;
        if(start==end) return lists[start];
        int mid=start+(end-start)/2;
        ListNode l1=mergeKLists(lists,start,mid);
        ListNode l2=mergeKLists(lists,mid+1,end);
        return merge2List(l1,l2);
    }
    
    public ListNode merge2List(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode();
        ListNode prev=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;
            }else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
        }
        prev.next=l1!=null?l1:l2;
        
        return dummy.next;
    }
}

/**
 * Another approach is to use priority queue to store all the elements and then make a new linked list
 * Another approach is the brute force one to merege 2 lists at a time.
*/