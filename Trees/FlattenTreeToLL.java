/** Flatten Binary Tree to Linked List
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 */
class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        prev=root;
        root.left=null;
    }
}