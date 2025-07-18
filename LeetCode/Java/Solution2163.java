package LeetCode.Java;

import java.util.ArrayList;
import java.util.Collections;

public class Solution2163 {
    public static long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        ArrayList<Integer> diffs = new ArrayList<>();
        // Helper to generate all combinations
        generateCombinations(nums, n, 0, new ArrayList<>(), diffs);
        return Collections.min(diffs);
    }

    // Helper function to generate all combinations of removing n elements
    private static void generateCombinations(int[] nums, int n, int start, ArrayList<Integer> removedIdx, ArrayList<Integer> diffs) {
        if (removedIdx.size() == n) {
            // Build numsTwo by skipping removedIdx
            ArrayList<Integer> numsTwoList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (!removedIdx.contains(i)) {
                    numsTwoList.add(nums[i]);
                }
            }
            int[] numsTwo = numsTwoList.stream().mapToInt(Integer::intValue).toArray();
            // Split and sum
            int first = 0, second = 0;
            for (int j = 0; j < numsTwo.length / 2; j++) first += numsTwo[j];
            for (int k = numsTwo.length / 2; k < numsTwo.length; k++) second += numsTwo[k];
            diffs.add(first - second);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            removedIdx.add(i);
            generateCombinations(nums, n, i + 1, removedIdx, diffs);
            removedIdx.remove(removedIdx.size() - 1);
        }
    }


    public static void main (String[] args) {
        System.out.println("7,9,5,8,1,3: " + minimumDifference(new int[]{7,9,5,8,1,3}));
    }
}


