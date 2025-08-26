package LeetCode.Java;

public class Solution2411 {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] last = new int[32]; // last seen index for each bit
        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 32; b++) {
                if (((nums[i] >> b) & 1) == 1) {
                    last[b] = i;
                }
            }
            int maxLen = 1;
            for (int b = 0; b < 32; b++) {
                if (last[b] > i) {
                    maxLen = Math.max(maxLen, last[b] - i + 1);
                }
            }
            answer[i] = maxLen;
        }
        return answer;
    }
}


/*
 * Goal: let Bij be the bitwise OR of the subarray nums[i...j]. You need to find the smllest subarray starting ast i, such that bitwise OR of this subarray is equal to max(Bik) where i <= k <= n-1
 * The bitwise OR of an array is the bitwise OR of all the numbers in it. 
 * Return an integer array answer of size n where answer[i] is the length of the min sized subarray starting at i with max bitwise OR.
 * 
 * How it works: 
 * last[32] array: Tracks the last index from right to left where each bit (0-31) is set in nums. This helps you know, for each bit, how far you need to go from index i to include al bits that contribute to the max OR
 * You process nums from the end to the start(i = n-1 to 0). For each number, you update last[b] for every b that is set in nums[i]
 * Finding the min Subarray length: for each index i , you want to include all bits that will ever appear from i to end. For each bit, if its last occurrence is after i, you need to exted your subarray to at least that index. 
 * maxLen keeps track of the farthest such index for all bits, so the min subarray length is maxLen. 
 * Result: answer[i] is set to the min length needed to include all bits that contribute to the max OR from i onward.
 * 
 * My understanding: 
 * a bit: 1-32.
 * going through nums, your are suppose to find the shortest subarray that yields it (max bitwise OR). Add that length to an array and return that. 
 * 
 */