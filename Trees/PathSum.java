/* Path Sum

Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
*/

/**
 * Solution : recursive
 * check if the node is a leaf node and the target is zero, if yes return zero
 * else recursively check for the left and the right subtree
 * return false if encounter a null node(given condition)
**/

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null) return targetSum-root.val==0;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}