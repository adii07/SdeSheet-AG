/* 	Add a row to the tree at the given depth

* Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
* Note that the root node is at depth 1.
* The adding rule is:
    Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
    cur's original left subtree should be the left subtree of the new left subtree root.
    cur's original right subtree should be the right subtree of the new right subtree root.
    If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
*/

/** Solution 1: Recursion
 * use recusiron with a decrement in depth at each level
 * when the depth is one, add new nodes as the left and the right child of the node at the depth
 * make the original left child point to the left of the node and right child to the right of the new right node
 * Make sure to add new nodes to both the left and right, if only a single new node is added the appending of previous child nodes will cause an issue
 
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        helper(root,val,depth-1);
        return root;
    }
    
    public void helper(TreeNode root,int val,int depth){
        if(root==null) return;
        if(depth==1){
            TreeNode leftChild=root.left;
            TreeNode rightChild=root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=leftChild;
            root.right.right=rightChild;
            return;
        }
        helper(root.left,val,depth-1);
        helper(root.right,val,depth-1);
    }
}

/** Solution 2: BFS using queue
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=1;
        while(!q.isEmpty()){
            if(level==depth-1){
                while(!q.isEmpty()){
                    TreeNode temp=q.remove();
                    TreeNode tempLeft=temp.left;
                    TreeNode tempRight=temp.right;
                    temp.left=new TreeNode(val);
                    temp.right=new TreeNode(val);
                    temp.left.left=tempLeft;
                    temp.right.right=tempRight;
                }
            }
            int size=q.size();
            while(size-->0){
                TreeNode head=q.remove();
                if(head.left!=null)q.add(head.left);
                if(head.right!=null)q.add(head.right);
            }
            level++;
        }
        
        
        return root;
    }
}