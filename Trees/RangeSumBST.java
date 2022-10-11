/** Range Sum of BST
 * Given the root node of a binary search tree and two integers low and high, 
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 
 Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 Output: 32
 Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

 Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 Output: 23
 Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 */

/**
 * if the value at root is smaller than the low value, it means no value to the left of root is usefull as they all will be smaller than the low, hence we move to the right of the root
 * if the value at root is larger than the high value, it means no value to the right of root is usefull as they all will be greater than the high, hence we move to the left of the root
 * else if the root value is within the given range, greater than low and samller than high we add the root value and make recursive calls to the right and the left subtree
**/
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right,low,high);
        if (root.val > high) return rangeSumBST(root.left,low,high);
        return root.val+rangeSumBST(root.right,low,high)+rangeSumBST(root.left,low,high); 
    }
}