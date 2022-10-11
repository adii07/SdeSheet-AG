/**
 * Solution 1: Using priority queue and hashmap
 * Hashmap is not required here but is used to solve the issue of tle
 * map is used to check if we visited the src city with least stops earlier. if we visited with least stops priorly, then no need to continue the further iteration from the current src
 * 
 * rest the algorithm is the normal dijkstra's algorithm
*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            int from=flight[0];
            int too=flight[1];
            int price=flight[2];
            Pair tmp=new Pair(too,price,0);
            graph.get(from).add(tmp);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->{
            return a.price-b.price;
        });
        q.add(new Pair(src,0,0));
        while(!q.isEmpty()){
            Pair head=q.remove();
            if(head.dest==dst) return head.price;
            if(head.stops>k)continue;
            if(map.containsKey(head.dest) && map.get(head.dest)<=head.stops) continue;
            map.put(head.dest,head.stops);
            for(Pair tmp:graph.get(head.dest)){
                q.add(new Pair(tmp.dest,tmp.price+head.price,head.stops+1));
            }
        }
        return -1;
    }
}
class Pair{
    int dest;
    int price;
    int stops;
    Pair(){}
    Pair(int dest,int price,int stops){
        this.dest=dest;
        this.price=price;
        this.stops=stops;
    }
}       