package LeetCode.Java;
public class Solution11 {
    //O(n)
    public int maxArea(int[] height) {
        int left = 0; 
        int right = height.length -1;
        int maxWater = 0;
        //keep moving the pointers towards each other
        while(left < right) {
            int currentWater = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, currentWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
    


    /*

    Created in O(n^2) which checks every possible pair but is terrible time iniffecient

    Needs to be in O(n) where each element is visited at most once. (Two Pointers)
        This works because we start with the maximum width (leftmost and rightmost lines)
        We systematically eliminate impossible candidates - if the left line is shorter, no point checking any pairs with the left line and lines closer to the center. 
        We never miss the optimal solution because we're guranteed to check the pair that gives maximum area.


     * public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (Math.min(height[i], height[j]) * (j - i) > max) {
                    max = Math.min(height[i], height[j]) * (j - i);
                }
            }
        }
        return max;
    }
     */
}
