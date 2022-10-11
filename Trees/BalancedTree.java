// Balanced Binary Tree
/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
	a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Input: root = [3,9,20,null,null,15,7]
Output: true

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
*/

/**
 * we use recursion
 * since at each step both the height of the child and the balanced conditon of the child nodes will be required, we use a pair
 * now if the node is null return the height as zero and the balanced as true(given condition)
 * for each node call the helper function for the left and the right child recursively
 * now check if both the child nodes are themselves balanced and if their differnce of heights is less than 1, if so mark the current node as balanced else not
 * the height of the current node will be the max of the heights of the left and the right subtree + 1.
 * make a pair of the height of the current node and the balanced condition of the current node and return the ans.
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        Pair ans=helper(root);
        return ans.isBalanced;
    }
    
    public Pair helper(TreeNode root){
        if(root==null) return new Pair(0,true);
        
        Pair left=helper(root.left);
        Pair right=helper(root.right);
        Pair val=new Pair();
        val.height=Math.max(left.height,right.height)+1;
        val.isBalanced=false;
        if(Math.abs(left.height-right.height)<=1 && left.isBalanced && right.isBalanced)
            val.isBalanced=true;
        
        return val;
    }
}
class Pair{
    int height;
    boolean isBalanced;
    Pair(){}
    Pair(int heigth,boolean isBalanced){
        this.height=height;
        this.isBalanced=isBalanced;
    }
}