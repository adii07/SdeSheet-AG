// Given the root node of a tree, print the right view of the tree

/**
 * BFS
 * 
 * use a queue to do bfs 
 * before the start of each level add the head of the queue to the ans, as it is the rightmost node
 * to get the right view, during the traversal add the right child before the left child
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            ans.add(q.peek().val);
            while(size-->0){
                TreeNode head=q.remove();
                if(head.right!=null) q.add(head.right);
                if(head.left!=null) q.add(head.left);
            }
        }
        return ans;
    }
}