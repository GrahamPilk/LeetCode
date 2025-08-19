package LeetCode.Java;

public class Solution2348 {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                curr++;
            } else {
                ans += (1L * curr*(curr+1)/2);
                curr = 0;
            }
        }
        ans += (1L * curr*(curr+1)/2);
        return ans;
    }
}

/*
 * Goal: Given an integer array nums, return the number of subarrays filled with 0
 * The only confusing thing is ans += line. 
 * What it does: It calculates the number of subarrays filled with zeros for the current streak of consecutive zeros. 
 * For example, if curr = 3 (i.e., [0,0,0], the subarrays are: )
 * - [0],[0],[0] (each single zero)
 * - [0,0],[0,0] (each pair of zeros)
 * - [0,0,0] (all three zeros)]
 * Total: 3 (single) + 2(pair) + 1(triple) = 6
 * Why 1L *: To ensure the calculation is done in the long type.
 */