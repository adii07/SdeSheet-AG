/**  Invert Binary Tree
 * Given the root of a binary tree, invert the tree, and return its root.
 * left subtree in original = right subtree in new tree and vice versa.
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}