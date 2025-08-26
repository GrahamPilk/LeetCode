package LeetCode.Java;

import java.util.HashSet;
import java.util.Set;

public class Solution898 {
    public int subArrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            for (int x : prev) {
                curr.add(x | num);
            }
            res.addAll(curr);
            prev = curr;
        }
        return res.size();
    }
}

/*
 * My Plan: Iterate through arr and get a subArray and then do the bitWise OR operation. Add all to a HashSet and determine unique values.
 * It worked with terrible time efficiency (O(n^2)) but only passed 21/85 testcases. 
 * To Do: Fix solution and Better Time Efficiency.
 * Fix-Solution: It is not creating arrs bigger than 2 (i think)
 * Time Efficiency: Could do a Tree of some Sort and do that. 
 * 
 * Change: I changed to using HashSets which make it easier to iterate and do the operation. 
 */