/**
 * Use a queue
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> tmp=new ArrayList<>();
            while(size-->0){
                TreeNode head=q.remove();
                tmp.add(head.val);
                if(head.left!=null) q.add(head.left);
                if(head.right!=null) q.add(head.right);
            }
            ans.add(tmp);
        }
        return ans;
    }
}