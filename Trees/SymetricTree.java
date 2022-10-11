// Symetric tree
/* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Input: root = [1,2,2,3,4,4,3]
Output: true

Input: root = [1,2,2,null,3,null,3]
Output: false
*/

/**
 * BFS using Queue
 * add the left and the right child of the root
 * then check if they are null or not, if both are null continue, else if either is null return false
 * then first add the left child of the left, then the right child of the right, then the right of left and finally the left of the right.
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(q.size()!=0){
            TreeNode left=q.remove();
            TreeNode right=q.remove();
            if(left==null && right==null) continue;
            else if(left==null || right==null || left.val!=right.val) return false;
            
            q.add(left.left);q.add(right.right);
            q.add(left.right);q.add(right.left);
            
        }
        return true;
    }
    
}

/**
 * DFS
 * comapre the roots using a helper function
 * check if null, if both are null return true, else if either is null return false.
 * then check if both are equal or not and call the same helper function on the left and the right subtree recursively.
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        else if(root1==null || root2==null) return false;
        
        return (root1.val==root2.val)&&helper(root1.left,root2.right)&&helper(root1.right,root2.left); 
    }
}