// Number of Islands
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

/**
 * Use a visited array to mark the visited cells.
 * We use dfs, using recursive technique.
 * use a loop to visit all the unvisited nodes.
 * while traversing through the nodes, mark then as visited and make recursive calls to the right,left,up and down neighbours.
 */
class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    helper(grid,i,j,visited);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void helper(char[][] grid,int row,int col,int[][] visited){
        if(row>=grid.length || col>=grid[0].length || col<0 || row<0) return;
        if(visited[row][col]==1 || grid[row][col]=='0') return;
        visited[row][col]=1;
        helper(grid,row+1,col,visited);
        helper(grid,row,col+1,visited);
        helper(grid,row-1,col,visited);
        helper(grid,row,col-1,visited);
    }
}