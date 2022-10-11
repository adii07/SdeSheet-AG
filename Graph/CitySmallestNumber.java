//Find the City With the Smallest Number of Neighbors at a Threshold Distance .1334
/*
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.

Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
Output: 0
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -> [City 1] 
City 1 -> [City 0, City 4] 
City 2 -> [City 3, City 4] 
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3] 
The city 0 has 1 neighboring city at a distanceThreshold = 2.
*/


//	NOTE: LOOK AT THE APPROACH 2


/**
 * Appraoch 1 : using dfs + priority queue
 * form an adjancy list
 * use a priority queue
**/
 class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int weight=edges[i][2];
            graph.get(from).add(new Pair(to,weight));
            graph.get(to).add(new Pair(from,weight));
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->{
            return a.distance-b.distance;
        });
        boolean[] vis=new boolean[n];
        int ans=0;
        int count=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int val=0;
            vis=new boolean[n];
            vis[i]=true;
            for(Pair temp:graph.get(i)){
                if(temp.distance<=distanceThreshold){
                    q.add(temp);
                }
            }
            
            while(!q.isEmpty()){
                Pair temp=q.remove();
                if(vis[temp.city]) continue;
                vis[temp.city]=true;
                val++;
                for(Pair p: graph.get(temp.city)){
                    if(!vis[p.city] && (p.distance+temp.distance)<=distanceThreshold) {
                        q.add(new Pair(p.city,(p.distance+temp.distance)));
                    }
                }
            }
            
            if(val<=count){
                count=val;
                ans=i;
            }
            // System.out.println(i+"->"+val);
        }
        return ans;
    }
}

class Pair{
    int city;
    int distance;
    Pair(int city,int distance){
        this.city=city;
        this.distance=distance;
    }
}

/**
 * Approach 2: using floydd warshal algorithm
 * find all pair shortest path using a grid
 * traverse the grid row wise and count he number of nodes with values less than threshold for that particular row
 * if the count of values is yet the smallest update the and to the current row
**/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=i==j?0:Integer.MAX_VALUE;
            }
        }
        for(int[] edge:edges){
            int from=edge[0];
            int too=edge[1];
            int weight=edge[2];
            graph[from][too]=weight;
            graph[too][from]=weight;
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE)
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        int city=0;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && graph[i][j]<=distanceThreshold)
                    count++;
            }
            if(ans>=count){
                ans=count;  
                city=i;
            }
        }
        return city;
    }
}
