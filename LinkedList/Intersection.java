// Intersection node of 2 linked list.
// Find the node that is common to both the linked list.
// If there is no such node, return null.


/**
 * Try to form a cycle without changing the original linked list.
 * The approach is to traverse the linked lists and as soon as one reaches it's end point it to the head the other linked list.
 * This approach also takes into consideration the length if the linked list (pen and paper example to verify).
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a;
    }
}


/**
 * Other ways are to use the difference in length to find the intersection point.
 * Another way is to use hashmap to store the common arrays.
 * Brute force is to travel one of the linked list one node at a time and check for all the other nodes if the other list.
*/