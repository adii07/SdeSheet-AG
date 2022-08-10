//Shortest Bridge

/*
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
You may change 0's to 1's to connect the two islands to form one island.
Return the smallest number of 0's you must flip to connect the two islands.
 
Example 1:
Input: grid = [[0,1],[1,0]]
Output: 1

Example 2:
Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Example 3:
Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
*/

/**
 * First traverse one of the components in dfs fashion.
 * while treversing mark all the nodes as visited and add the visited nodes to the queue for future reference
 * once you have traversed one of the components, start the bfs using the queue formed during the dfs
 * while travelling the queue, increase the level after travelling through a level
 * take note of the first unvisited cell with the value 1 can return the value of that level
 * this is done as this is the first node/cell of the second component reached
 * return the level once this node is reached
*/
class Solution {
    
    int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
    
    public int shortestBridge(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        Queue<Pair> q=formIsland(grid,visited);
        
        
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair head=q.remove();
                for(int i=0;i<direction.length;i++){
                    int row=head.row+direction[i][0];
                    int col=head.col+direction[i][1];
                    if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col]) continue;
                    if(grid[row][col]==1) return level;
                    q.add(new Pair(row,col));
                    visited[row][col]=true;
                }
            }
            level++;
        }
        return -1;
    }
    
    public Queue<Pair> formIsland(int[][] grid,boolean[][] visited){
        Queue<Pair> q=new LinkedList<>();
        boolean flag=true;
        for(int i=0;i<grid.length && flag;i++){
            for(int j=0;j<grid[0].length && flag;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited,q);
                    flag=false;
                }
            }
        }
        return q;
    }
    
    public void dfs(int[][] grid,int row,int col,boolean[][] visited,Queue<Pair> q){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length || grid[row][col]==0 || visited[row][col]) return;
        
        visited[row][col]=true;
        q.add(new Pair(row,col));
        for(int i=0;i<direction.length;i++){
            dfs(grid,row+direction[i][0],col+direction[i][1],visited,q);
        }
    }
}

class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}