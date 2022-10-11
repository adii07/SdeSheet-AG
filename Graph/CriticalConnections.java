/*
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
Return all critical connections in the network in any order.
*/
/**
 * Use bridges and articulation points concetps,i.e, Trajan's algorithm
 * here we have a discovery array to represent the time it current node was discovered,it also doubles as an visited array
 * Then we also have an low array which represents the lowest node the current node can contact if the path it came from is removed
 * We also have a parent array to mark the parent if an node as we have to ignore the path that we came from
**/
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans=new ArrayList<>();
        
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(List<Integer> edge:connections){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        
        int[] disc=new int[n];Arrays.fill(disc,-1);
        int[] low=new int[n];Arrays.fill(low,-1);
        int[] parent=new int[n];Arrays.fill(parent,-1);
        
        
        for(int i=0;i<n;i++){
            if(disc[i]==-1){
                helper(ans,graph,i,disc,low,parent);
            }
        }
        
        return ans;
    }
    static int time=0;
    public void helper(List<List<Integer>> ans,List<List<Integer>> graph,int node,int[] disc,int[] low,int[] parent){
        
        
        disc[node]=low[node]=time++;
        
        for(int adj:graph.get(node)){
            if(disc[adj]==-1){
                parent[adj]=node;
                helper(ans,graph,adj,disc,low,parent);
                low[node]=Math.min(low[node],low[adj]);
                
                if(low[adj]>disc[node]){
                    List<Integer> subans=new ArrayList<>();
                    subans.add(node);
                    subans.add(adj);
                    ans.add(new ArrayList<>(subans));
                }
            }
            else if(parent[node]!=adj){
                low[node]=Math.min(low[node],disc[adj]);
            }
        }
        
    }
}