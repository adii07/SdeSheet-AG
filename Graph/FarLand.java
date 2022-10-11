// As Far from Land as Possible
/*
Given an n x n grid containing only values 0 and 1, 
where 0 represents water and 1 represents land, 
find a water cell such that its distance to the nearest land cell is maximized, and return the distance. 
If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.

Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
*/


/**
 * Approach 1: Use dfs
 * the max level that can be reached encountering only zero grid from all the one grid at once is the max distance possible
 * add all the the one cells to a queue
 * start a bfs traversal in the queue
 * add only the adjacent cells(up,down,left,right) which have zero value
 * mark those zero cells as one such that they are not traversed again
 * maintain and ans value and update it with the current level.
**/
class Solution {
    int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int maxDistance(int[][] grid) {
        int ans=-1;
        Queue<Pair> q=findLand(grid);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            level++;
            while(size-->0){
                Pair top=q.remove();
                for(int i=0;i<4;i++){
                    int row=top.row+dir[i][0];
                    int col=top.col+dir[i][1];
                    if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==1)
                        continue;
                    
                    q.add(new Pair(row,col));
                    grid[row][col]=1;
                    ans=level;
                }
            }
        }
        return ans;
    }
    
    public Queue<Pair> findLand(int[][] grid){
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0) q.add(new Pair(i,j));
            }
        }
        return q;
    }
}
class Pair{
    int row;
    int col;
    Pair(){}
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

/**
 * Approach 2: use of dynamic programming
 * we cannot keep track of both the previously encountered cells(up and left) and cells yet to be encountered(down and right) all together.
 * there we run the loops 2 times, once for up and left , and the other time for down and right
 * in the first loop we keep a sum counter which counts the number of the total value of the grid
 * this sum helps helps us with the edge cases, where either all cells are 1(sum=n*n) or all cells are 0(sum=0), in these case we directly return -1.
 * else we check the next values from a cell and take the min of the given condition and 1 for the current cell
 * we skip any grid that has value of 1
**/

class Solution {
    public int maxDistance(int[][] grid) {
        int sum=0;
        int n=grid.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=grid[i][j];
                if(grid[i][j]==1) continue;
                
                int up=i-1>=0?dp[i-1][j]:2*n;
                int left=j-1>=0?dp[i][j-1]:2*n;
                
                dp[i][j]=Math.min(up,left)+1;
            }
        }
        if(sum==n*n || sum==0) return -1;
        int ans=0;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1) continue;
                
                int down=i+1<n?dp[i+1][j]:2*n;
                int right=j+1<n?dp[i][j+1]:2*n;
                dp[i][j]=Math.min(Math.min(down,right)+1,dp[i][j]);
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}