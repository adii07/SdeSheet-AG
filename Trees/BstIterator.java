// Binary Search Tree Iterator

/*
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

	-BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. 
		The pointer should be initialized to a non-existent number smaller than any element in the BST.
	-boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
	-int next() Moves the pointer to the right, then returns the number at the pointer.
	Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
*/

/**
 * Solution
 * so since it is a binary search tree and we have to return the elements in an sorted order, we use inorder traversal
 * but how do we do inorder traversal using a stack
 * inorder traversal = left->node->right
 * there we add the node to the stack and then add all of it's left child
 * then when we have to remove a node we remove the top node, and start to add it's right child , we also need to add the left child of each right node
 * therefore, add the node , add its left child remove the left first(as it is on top of the stack) return the node and add its right child
 */
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode node=st.pop();
        TreeNode curr=node;
        while(curr!=null){
            curr=curr.right;
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */