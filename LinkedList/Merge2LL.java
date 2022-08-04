// Merge 2 given Linked List in ascending order


/**
 * Compare the nodes and add the samller node to the chain
 * At the end if any of the list has any values left and if yes, append those values.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode();
        ListNode prev=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                prev.next=list1;
                prev=list1;
                list1=list1.next;
            }else if(list2.val<list1.val){
                prev.next=list2;
                prev=list2;
                list2=list2.next;
            }  
        }
        if(list1!=null) prev.next=list1;
        if(list2!=null) prev.next=list2;
        
        return dummy.next;
    }
}

//Sol 2
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val>list2.val){
            ListNode temp=list1;
            list1=list2;
            list2=temp;
        }
        ListNode head=list1;
        while(list1!=null && list2!=null){
            ListNode prev=null;
            while(list1!=null && list1.val<=list2.val){
                prev=list1;
                list1=list1.next;
            }
            prev.next=list2;
            ListNode temp=list1;
            list1=list2;
            list2=temp;
        }
        return head;
        
    }
}