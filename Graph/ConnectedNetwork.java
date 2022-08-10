// Number of Operations to Make Network Connected
/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. 
Any computer can reach any other computer directly or indirectly through the network.
You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
*/

/**
 * Union and Find approach
 * start to make the connection and add nodes of the same component to the same parent
 * if the 2 nodes in the connection belong to the same mark that connection as redundant and increase the redundant count
 * The connection is marked redundant as even if the connection is removed, it will not affect the 2 nodes since they already belong to the same component and are always indirectly connected to one another
 * at the last count the number of nodes, which are their own parents
 * one of these is the actual parent of some connection and the rest are independent or disconnected nodes
 * if the number of disconnected nodes is less than or equal to the number of redundant connections, then we have an ans as the redundant connections can be displaced to form a completely connected component
 * else it's not possible to form a completely connected component as the number of disconnected components is greater than the number of extra/redundant wires*/
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int redundant=0;
        UnionFind uf=new UnionFind(n);
        for(int[] connection:connections){
            int too=connection[0];
            int from=connection[1];
            if(uf.find(too)==uf.find(from)){
                redundant++;
            }else{
                uf.union(too,from);
            }
        }
        int val=uf.check();
        
        if(val-1<=redundant) return val-1;
        return -1;
    }
}

class UnionFind{
    int[] parent;
    int[] rank;
    UnionFind(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int check(){
        int count=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i) count++;
        }
        return count;
    }
    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    public void union(int a,int b){
        int par1=parent[a];
        int par2=parent[b];
            if(rank[par1]>rank[par2]){
                parent[par2]=par1;
            }else if(rank[par2]>rank[par1]){
                parent[par1]=par2;
            }else{
                parent[par2]=par1;
                rank[par1]++;
            }
    }
}