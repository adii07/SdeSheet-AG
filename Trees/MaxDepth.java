// Maximum Depth of Binary Tree

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Input: root = [3,9,20,null,null,15,7]
Output: 3

Input: root = [1,null,2]
Output: 2
*/


/**
 * Solution 1: recursion
 * the depth of a node is the max of the depth of it's child +1(it's own height)
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}


/**
 * Solution 2: bfs using queue
 * with each level increment the depth by one
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        int depth=0;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode head=q.remove();
                if(head.left!=null) q.add(head.left);
                if(head.right!=null) q.add(head.right);
            }
            depth++;
        }
        return depth;
    }
}