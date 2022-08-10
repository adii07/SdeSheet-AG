// Find Eventual Safe States

/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. 
The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
A node is a terminal node if there are no outgoing edges. 
A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
Return an array containing all the safe nodes of the graph. 
The answer should be sorted in ascending order.

Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
*/


/**
 * The first thing to consider is that if there are no outgoing edges from the node, it is an safe node
 * this can be easily calculated by considering the graph array and length at ith index
 * The next step is to understand that a node is a safe node when it's terminal node/ end node has no outgoing edges
 * this simply means that the node doesnot lead to the creation of a cycle
 * Hence for each node we check if it leads to a cycle or not
 * if it forms a cycle it's not a safe node else its a safe node.
**/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        int[] visited=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            int[] edge=graph[i];
            if(edge.length==0) ans.add(i);
            else 
                if(dfs(i,graph,visited)) ans.add(i);
        }
        return ans;
    }
    
    public boolean dfs(int node,int[][] graph,int[] visited){
        if(visited[node]>0) return visited[node]==2;
        
        visited[node]=1;
        for(int edge:graph[node]){
            if(visited[node]==2) continue;
            if(visited[edge]==1 || !dfs(edge,graph,visited)) {
                return false;
            }
        }
        visited[node]=2;
        return true;
    }
}