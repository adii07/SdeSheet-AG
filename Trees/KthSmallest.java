class Solution {
  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();

    while (true) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }
}

/**
 * We follow the same approach for dfs traversal using stack
 * we donot use a pair to couple the node and it's state(0-pre,1-in,2-post)
 * we add the root and keep on adding till is leftmost child
 * then we remove the left most child and make the current node the right of the leftmost child
 * this is done as in inorder the left comes first then the node and then right
 * hence when the node is first added it's preorder is done
 * then when it is removed it's in inorder phase
 * then we add its right child */