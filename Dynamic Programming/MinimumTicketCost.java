//Minimum Cost For Tickets
/*
You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:
	a 1-day pass is sold for costs[0] dollars,
	a 7-day pass is sold for costs[1] dollars, and
	a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total, you spent $17 and covered all the days of your travel.
*/


// Solution 1
// use while loop to skip the days which can be covered by the day passed are bought(nextDay pointer)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length];
        Arrays.fill(dp,-1);
        return helper(days,costs,0,dp);
    }
    public int helper(int[] days,int[] costs,int day,int[] dp){
        if(day>=days.length) return 0;
        if(dp[day]!=-1) return dp[day];
        
        int nextDay=day;
        while(nextDay<days.length && days[nextDay]<days[day]+1) 
            nextDay++;
        int daily=costs[0]+helper(days,costs,nextDay,dp);
        
        while(nextDay<days.length && days[nextDay]<days[day]+7) 
            nextDay++;
        int weekly=costs[1]+helper(days,costs,nextDay,dp);
        
        while(nextDay<days.length && days[nextDay]<days[day]+30) 
            nextDay++;
        int monthly=costs[2]+helper(days,costs,nextDay,dp);
        
        return dp[day]=Math.min(daily,Math.min(weekly,monthly));
    }
}


// Solution 2
// skip the days you donot need to travel, else buy a pass
// consider the whole year
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set=new HashSet<>();
        int[] dp=new int[366];
        Arrays.fill(dp,-1);
        for(int day:days) set.add(day);
        return helper(days,costs,1,set,dp);
    }
    public int helper(int[] days,int[] costs,int day,HashSet<Integer> set,int[] dp){
        if(day>365) return 0;
        if(dp[day]!=-1) return dp[day];
        if(!set.contains(day)) return helper(days,costs,day+1,set,dp);
        
        int daily=costs[0]+helper(days,costs,day+1,set,dp);
        int weekly=costs[1]+helper(days,costs,day+7,set,dp);
        int monthly=costs[2]+helper(days,costs,day+30,set,dp);
        
        return dp[day]=Math.min(daily,Math.min(weekly,monthly));
    }
}