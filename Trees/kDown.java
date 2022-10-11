// All Nodes Distance K in Binary Tree
/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
*/

/** Solution
 * the basic ides is to use recursion to traverse the tree and keep count of the level(k)
 * if we find the target node we have to add all the elements k level below it to the ans
 * but if we consider an ancestor of k , we only have to consider k-(diff in height of target from ancestor)
 * example 2 is the target and it is the left child of 5 and the level k=3, now when we move the the right child of 5, there will be nodes at k distance from 2 hence we have to add them too
 * this can be done by returning 1 as we encounter the target and then the level will be k-child.
 * we pass a blocker as we donot want to travel back the path we came from
 */
class Solution {
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans=new ArrayList<>();
        helper(root,target,k);
        return ans;
    }
    
    public int helper(TreeNode root,TreeNode target,int k){
        if(root==null) return -1;
        if(root==target){
            kDown(root,k,null);
            return 1;
        }
        int left=helper(root.left,target,k);
        if(left!=-1){
            kDown(root,k-left,root.left);
            return left+1;
        }
        int right=helper(root.right,target,k);
        if(right!=-1){
            kDown(root,k-right,root.right);
            return right+1;
        }
        return -1;
    }
    
    public void kDown(TreeNode root,int k,TreeNode blocker){
        if(root==null || k<0 || root==blocker) return;
        
        if(k==0){
            ans.add(root.val);
            return;
        }
        kDown(root.left,k-1,blocker);
        kDown(root.right,k-1,blocker);
    }
}