// Maximum Number of Visible Points
/*
You are given an array points, an integer angle, and your location, where location = [posx, posy] and points[i] = [xi, yi] both denote integral coordinates on the X-Y plane.

Initially, you are facing directly east from your position. 
You cannot move from your position, but you can rotate. In other words, posx and posy cannot be changed. 
Your field of view in degrees is represented by angle, determining how wide you can see from any given view direction. 
Let d be the amount in degrees that you rotate counterclockwise. 
Then, your field of view is the inclusive range of angles [d - angle/2, d + angle/2].

You can see some set of points if, for each point, the angle formed by the point, your position, and the immediate east direction from your position is in your field of view.
There can be multiple points at one coordinate. There may be points at your location, and you can always see these points regardless of your rotation. Points do not obstruct your vision to other points.
Return the maximum number of points you can see.

https://assets.leetcode.com/uploads/2020/09/30/89a07e9b-00ab-4967-976a-c723b2aa8656.png
*/


class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
		int same = 0;
		for (List<Integer> p : points) {
			int dx = p.get(0) - location.get(0);
			int dy = p.get(1) - location.get(1);
			if (dx == 0 && dy == 0) { // edge case of same point
				same++;
			} else {
				angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
			}
		}
		Collections.sort(angles);
		List<Double> tmp = new ArrayList<>(angles);
		for (double d : tmp) angles.add(d + 360); // concatenate to handle edge case

		int res = 0, i = 0;
		for (int j = 0; j < angles.size(); j++) {
			while (angles.get(j) - angles.get(i) > angle) {
				i++;
			}
			res = Math.max(res, j - i + 1);
		}
		return res + same;
    }
}