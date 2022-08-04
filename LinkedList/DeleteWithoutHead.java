// Given a pointer to a node. Delete that node from the list.

/**
 * Set the value of the next node as the value of the current node.
 * Remove the next pointer of the given node and make it point it to the next of the next node.
 * Therefore we basically delete the next node as assign the value of the next node to the current node.
*/
node.val=node.next.val;
node.next=node.next.next;