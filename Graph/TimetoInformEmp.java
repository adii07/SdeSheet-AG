//Time Needed to Inform All Employees
/*
A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.
*/

/**
 * The basic essence of this problem is that since the organisation structure forms a tree, we donot need to keep track of the visited nodes as there will be no tree
 * start with the head of the organisation and keep on incrementing the time by the given values each time
 * return the max time of all the nodes
 * **/
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int time=0;
        Queue<int[]> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int i=0;i<manager.length;i++){
            if(i!=headID) list.get(manager[i]).add(i);
        }
        q.add(new int[]{0,headID});
        while(!q.isEmpty()){
            int[] head=q.remove();
            int val=head[0];
            int node=head[1];
            time=Math.max(val,time);
            for(int i:list.get(node))
                q.add(new int[]{val+informTime[node],i});
        }
        return time;
    }
}