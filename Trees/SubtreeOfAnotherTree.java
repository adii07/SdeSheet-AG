// Subtree of Another Tree

/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
 * The tree tree could also be considered as a subtree of itself.
 * 
 Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 Output: true
 */


class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null || subRoot==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean ans=false;
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            if(node.val==subRoot.val){
                ans=helper(node,subRoot);
                if(ans)break;
            }
            if(node.left!=null)q.add(node.left);
            if(node.right!=null)q.add(node.right);
        }
        return ans;
    }
    
    public boolean helper(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;
        if(root.val==subRoot.val && helper(root.left,subRoot.left) && helper(root.right,subRoot.right)) return true;
        else return false;
    }
}