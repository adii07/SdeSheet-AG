//Sum of Left Leaves

/*
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
*/

/**
 * While traversing the tree keep a consider pointer which is true for the left child and false for the right child of a node
 * now check if a node is a leaf node and should it be considered or not? if yes return it's value else return 0
 * recursively call and return the sum of the left and the right child
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root,false);
    }
    
    public int helper(TreeNode root,boolean consider){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return consider?root.val:0;
        int left=helper(root.left,true);
        int right=helper(root.right,false);
        return left+right;
    }
}