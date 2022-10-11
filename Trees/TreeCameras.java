/**
 * If either of the child has no camera install a camera and increment count
 * if either of the child has a camera we donot need a camera
 * else by default we need a camera
 */
class Solution {
    /*
    0-> not needed
    1-> installed
    -1-> needed
    */
    public int minCameraCover(TreeNode root) {
        int count[]=new int[1];
        int val=helper(root,count);
        if(val==-1) count[0]++;
        return count[0];
    }
    
    public int helper(TreeNode root,int[] count){
        if(root==null) return 0;
        int left=helper(root.left,count);
        int right=helper(root.right,count);
        if(left==-1 || right==-1){
            count[0]++;
            return 1;
        }
        if(right==1 || left==1) return 0;
        return -1;
    }
}