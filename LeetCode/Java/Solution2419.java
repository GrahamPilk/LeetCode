package LeetCode.Java;

public class Solution2419 {
    public int longestSubarray(int[] nums) {
        int k = 0;
        for(int num : nums) {
            if(num > k){
                k = num;
            }
        }
        int streak = 0; 
        int maxStreak = 0;

        for(int num : nums) {
            if(num == k) {
                streak++;
                if (streak > maxStreak) maxStreak = streak;
            } else {
                streak = 0;
            }
        }

        return maxStreak;
    }
}


/*
 * Question: let k be the max val of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered. Return the len of the longest such subarray. 
 * First for loop is for finding the max bitwise AND
 * We initisalize streak and maxStreak representing the largest subarray when finding the len of it. 
 */