//Minimum Absolute Difference in BST
/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

Input: root = [4,2,6,1,3]
Output: 1

Input: root = [1,0,48,null,null,12,49]
Output: 1
*/


/**
 * Since it is an bst the inorder has to be in sorted order
 * therefore we use this property of the bst to find the min absolute difference between 2 consecutive sorted numbers as they have the posibilty of the min diff
 * now we can either do the inorder traversal and store the order in an array and then take the difference of 2 consecutive number
 * or
 * we can initalize a last pointer(that points to the prev node in the inorder travelsal) and an ans in the global scope of the program
 * then we subtract the current node with the previous node in the inorder traversal and store the min possible ans
 */
class Solution {
    int minDiff=Integer.MAX_VALUE;
    TreeNode last=null;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
 
    public TreeNode inorder(TreeNode root){
        if(root==null)
            return null;
        inorder(root.left);
        if(last!=null)
        minDiff=(minDiff<(root.val-last.val))?minDiff:(root.val-last.val);
        last=root;
        inorder(root.right);
        return null;
    }
}