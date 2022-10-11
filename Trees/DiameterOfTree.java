//Diameter of Binary Tree

/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
*/


/**
 * The diameter of a node is the (left subtree height+ right subtree height) or the max of left or the right subtree
 * we take a pair or else at each step we would have to find the height of the subtrees which would have added to the time complexity. 
**/
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        Pair head=helper(root);
        return head.diameter;
    }
    
    public Pair helper(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair curr=new Pair();
        Pair left=helper(root.left);
        Pair right=helper(root.right);
        
        int diameter=left.height+right.height;
        curr.diameter=Math.max(diameter,Math.max(left.diameter,right.diameter));
        curr.height=Math.max(left.height,right.height)+1;
        
        return curr;
    }
}
class Pair{
    int diameter;
    int height;
    Pair(){}
    Pair(int diameter,int height){
        this.diameter=diameter;
        this.height=height;
    }
}