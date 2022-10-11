// Binary Tree Paths

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Input: root = [1]
Output: ["1"]
*/

class Solution {
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans=new ArrayList<>();
        helper(root,"");
        return ans;
    }
    
    public void helper(TreeNode root,String path){
        if(root==null) return;
        if(root.left==null && root.right==null){
            String val=path+root.val;
            ans.add(val);
            return;
        }
        String val=path+root.val+"->";
        helper(root.left,val);
        helper(root.right,val);
    }
}