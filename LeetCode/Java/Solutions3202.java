package LeetCode.Java;

import java.util.HashMap;
import java.util.Map;

public class Solutions3202 {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int maxLen = 0;
        for (int num : nums) {
            int remainder = num % k;
            for (int target = 0; target < k; target++) {
                dp.putIfAbsent(target, new HashMap<>());
                Map<Integer, Integer> targetMap = dp.get(target);
                int prevRemainder = (target - remainder + k) % k;
                int prevLen = targetMap.getOrDefault(prevRemainder, 0);
                int newLen = Math.max(targetMap.getOrDefault(remainder, 0), 
                                    prevLen + 1);
                targetMap.put(remainder, newLen);
                maxLen = Math.max(maxLen, newLen);
            }
        }
        return maxLen;
    }
}



/*
 * What the problem is solving: The code finds the longest subsequence of numbers where the sum is divisible by k. 
 * 
 * Insights
 * - If we have numbers that add up to remainder r1, and we want to add a number with remainder r2
 * - The new total remainder will be (r1 + r2) % k
 * - We want this to eventually equal 0 (divisible by k)
 * 
 * The data Structure: 2 maps
 * - Outer map: For each possible target remainder (0 to k-1)
 * - inner map: for each remainder weve seen, what is the max length we an achieve?
 * 
 * This works because dynamic programming stores the best solution for each state (remainder combination) as we process each number, we update all possible ways it could contribute to reaching each target remainder.
 * The final answer is the max length found across all target remainders, but we are particulary interested in target remainder 0 (divisible by k)
 * This is a sophisticated DP approack that efficienty explores all possible subsequence combinations without actually generating them. 
 * 
 * Understanding
 * - Map<Integer, Integer> means if we look up a number, we get another number.
 * - A map inside of a map: A filing cabinet (outer Map) with drawers labeled 0,1,2,3,4. Each drawer contains folders (inner map) with different labels. Each folder contains a number (the longest length we have found.)
 * - Think of a map like a dictionary or phone book, you look up a key (name) and get back a value (phone number).
 * - Dynamic programming is a fancy term for "remember what you have calculated before so you dont have to do it again" Instead of trying every possible combination, the code remembers: "The best I can do with remainder 3 is length 4" and builds on that. 
 * - The final answer (maxLen) is the longest sequence found that adds up to any multiple of k. 
 * 
 * 
 */
