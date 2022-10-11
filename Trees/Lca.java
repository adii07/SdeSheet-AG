// Lowest common ancestor of a binary searh tree

/*
Given a binary search tree and 2 of it's nodes, find the lowest common ancestor of those nodes in the tree
ccording to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*/


/**
 * Solution
 * 
 * since it is a bst all the nodes to the left of the node are smaller and all the nodes to the right of the nodes are greater than the node
 * hence if both the target nodes are smaller than the current node we move to the right of the current node, as we'll then find the greater nodes
 * simillarly if the target nodes are greater than the current node we move th the left child of the current node(smaller)
 * else if either of the node is smaller than the current node and the other is greater , it means that the nodes are in two differnt subtrees hence the current node is the ancestor of the target nodes
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}