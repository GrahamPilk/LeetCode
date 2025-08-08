package LeetCode.Java;

import java.util.HashMap;
import java.util.Map;

public class Solution808 {
    private Map<String, Double> memo = new HashMap<>();
    public double soupServings(int n){
        int cupA = n;
        int cupB = n;
        if (n > 5000) return 1.0;
        return helper((n+24) / 25, (n+24) / 25);
    }

    private double helper(int a, int b) {
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1.0;
        if(b <= 0) return 0;
        String key = a + "," + b;
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        double result = 0.25 * (
            helper(Math.max(0, a - 4), Math.max(0, b)) +      // Operation 1: 100ml from A, 0ml from B
            helper(Math.max(0, a - 3), Math.max(0, b - 1)) +  // Operation 2: 75ml from A, 25ml from B  
            helper(Math.max(0, a - 2), Math.max(0, b - 2)) +  // Operation 3: 50ml from A, 50ml from B
            helper(Math.max(0, a - 1), Math.max(0, b - 3))    // Operation 4: 25ml from A, 75ml from B
        );

        memo.put(key, result);
        return result;

    }
}

/*
 * You have two souple, A and B, each starting with n mL. On every turn,  one of the following four serving operations is choses at random, each with probability of 0.25 independently.
 * 1. pour 100mL from Type A and 0mL from type B
 * 2. pour 75mL from Type A and 25mL from type B
 * 3. pour 50mL from Type A and 50mL from type B
 * 4. pour 25mL from type A and 75mL from type B
 * There is no operation that pours 0mL from A and 100mL from B
 * The amounts from A and B are poured simultaneously during their turn. 
 * If an operation asks you to pour more than you have left of a soup, pour all that remains of that soup. 
 * The process ends after any turn in which one of the soups is used up. 
 * Return the probability that A is used up before B, plus half the probably that both soups are used up in the same turn. 
 * 
 * This is meant to be a recursive problem. It uses a HashMap to see how many left. 
 * Memoization + Recursion
*/
