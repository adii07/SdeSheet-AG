/**
 * Recursive
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    public void helper(TreeNode node,List<Integer> ans){
        if(node==null) return;
        if(node.left!=null) helper(node.left,ans);
        ans.add(node.val);
         if(node.right!=null) helper(node.right,ans);
    }
}


/**
 * Iterative
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ans = new ArrayList<Integer>();

        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !st.empty()){
            while(cur!=null){
                st.add(cur);
                cur = cur.left;
            }
            cur = st.pop();
            ans.add(cur.val);
            cur = cur.right;
        }

        return ans;
    }
}