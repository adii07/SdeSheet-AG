//Making A Large Island
/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
*/

/**
 * Solution 1: noraml dfs
 * keep the count of 0 converted to ones and apply the dfs algorithm to find the connected components
**/

/**
 * Solution 2: Use union find methods
 * find the components and assign the start of the component as the parent to all the nodes in the components
 * in the dfs to find the components keep track of the number of nodes in a conponent and the parent is marked with that number
 * in the meanwhile keep on adding all the zero's encountered to a queue
 * traverse the queue and check for the up,down,left and right neighbours of zero
 * check the count on the parent of that node(gives the total number of elements in the component), add them up and store the max
**/
class Solution {
    Pair[][] parent;
    int[][] rank;
    int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        parent=new Pair[n][n];
        rank=new int[n][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    Pair p=new Pair(i,j);
                    int val=formIsland(grid,i,j,n,p);
                    rank[i][j]=val;
                }
                if(grid[i][j]==0) q.add(new Pair(i,j));
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            Pair head=q.remove();
            int up=0,down=0,right=0,left=0;
            HashSet<Pair> set=new HashSet<>();
            for(int i=0;i<4;i++){
                if(head.r+dir[i][0]>=0 && head.r+dir[i][0]<n && head.c+dir[i][1]>=0 && head.c+dir[i][1]<n && grid[head.r+dir[i][0]][head.c+dir[i][1]]!=0)
                    set.add(parent[head.r+dir[i][0]][head.c+dir[i][1]]);
            }
            int sum=0;
            for(Pair temp:set) {
                sum+=rank[temp.r][temp.c];
            }
            ans=Math.max(sum+1,ans);
        }
        return ans==0?n*n:ans;
    }
    
    public int formIsland(int[][] grid,int row,int col,int n,Pair par){
        if(row<0 || col<0 || row>=n || col>=n || grid[row][col]!=1) return 0;
        grid[row][col]=2;
        parent[row][col]=par;
        int val=0;
        for(int i=0;i<4;i++){
            val+=formIsland(grid,row+dir[i][0],col+dir[i][1],n,par);
        }
        return val+1;
    }
}
class Pair{
    int r;
    int c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}