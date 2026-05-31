class Solution {
    public int maxArea(int[] heights) {
        //Arrays.sort(heights);

        int maxArea = 0;
        int l = 0, r = heights.length -1;
        
        while (l < r) {
            var newArea = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(maxArea, newArea);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
