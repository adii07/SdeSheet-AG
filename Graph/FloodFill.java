// Flood Fill

/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
*/

/**
 * Here the image matrix also acts as the visited matrix, as we only traverse those cells which have the same colour as the original cell and skip the rest.
*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int colour) {
        if(image[sr][sc]!=colour)
            helper(image,sr,sc,colour,image[sr][sc]);
        return image;
    }
    
    public void helper(int[][] image,int sr,int sc,int colour,int originalColour){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=originalColour)
            return;
        
        image[sr][sc]=colour;
        
        helper(image,sr+1,sc,colour,originalColour);
        helper(image,sr,sc+1,colour,originalColour);
        helper(image,sr,sc-1,colour,originalColour);
        helper(image,sr-1,sc,colour,originalColour);       
    }
}