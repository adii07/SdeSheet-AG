// Convert a sorted array to binary search tree

/**
 * In a bst all the nodes to the left of a node are smaller and all the nodes to the right are greater than the node itself
 * now since the array is sorted, the middle element can be the node and the right half and the left can form the right and the left subtree respectively
 * we find the mid, make it the root node
 * call the recursive function with start till mid-1 to form the left subtree(samller half)
 * call the recursive function with mid+1 till end to form the right subtree(greater half)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    
    public TreeNode helper(int[] nums,int start,int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        
        int mid=(start+end)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=helper(nums,start,mid-1);
        node.right=helper(nums,mid+1,end);
        return node;
    }
}