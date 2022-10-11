/**
 * since we have to validate a bst, all the nodes to the left of the node must be smaller and all the nodes to the right of the node must be greater
 * 
 * therefore we simply use this conditon to validate the bst , along with the condition that both the subtree must also be an bst(recurison )
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);     
    }
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root==null) return true;
        if(min!=null && root.val<=min.val) return false;
        if(max!=null && root.val>=max.val) return false;
        if(!isValidBST(root.left, min, root)) return false;
        if(!isValidBST(root.right, root, max)) return false;
        return true;
    }
}