

import java.util.HashMap;
import java.util.Map;

public class Solution904 {
    public int totalFruit(int[] fruits) {
        int left = 0, maxLen = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);
            while (count.size() > 2) {
                count.put(fruits[left], count.get(fruits[left]) - 1);
                if (count.get(fruits[left]) == 0) {
                    count.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

/*
 * Goal: Return the max number of fruits you can pick. 
 * Question: You only have 2 baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold. 
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fir in your baskets, you must stop. 
 * 
 * My solution, Use a map (0,1) to find out count of fruits in one basket. 
 * 
 */