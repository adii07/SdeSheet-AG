// Copy List with Random Pointer
// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.


class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr=head;
        while(curr!=null){
            Node nextNode=curr.next;
            Node temp=new Node(curr.val);
            curr.next=temp;
            temp.next=nextNode;
            curr=nextNode;
        }
        curr=head;
        while(curr!=null){
            Node randomNode=curr.random;
            curr.next.random=(randomNode==null?null:randomNode.next);
            curr=curr.next.next;
        }
        Node dummy=new Node(0);
        Node tempHead=dummy;
        curr=head;
        while(curr!=null){
            Node copyNode=curr.next;
            Node nextNode=curr.next.next;
            curr.next=nextNode;
            copyNode.next=nextNode==null?null:nextNode.next;
            tempHead.next=copyNode;
            tempHead=copyNode;
            curr=nextNode;
        }
        return dummy.next;
    }
}