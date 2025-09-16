package LeetCode.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        for (int num : nums) {
            stack.add(num);
            // Keep merging the top two if they are non-coprime
            while (stack.size() >= 2) {
                int a = stack.get(stack.size() - 2);
                int b = stack.get(stack.size() - 1);
                int g = gcd(a, b);
                if (g > 1) {
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    stack.add(LCM(a, b));
                } else {
                    break;
                }
            }
        }
        return stack;
    }

    public int LCM(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

/*
 * Steps: 
 * 1. Find any two adjacent numbers in nums that are non-coprime
 * 2. If no such numbers are found, stop the process.
 * 3. Otherwise delete the two numbers, and replace them with their LCM
 * 4. Repeat this process as long as you 
 * 
 * a non co-prime pair is when they have a common factor of something other than 1
 * 
 * What I do for the replaceNonCoPrimes method: 
 * - I used a list as a stack to build the result. 
 * - For each number in nums, I add it to the stack. 
 * - After adding, I check if the top two numbers in the stack are non-coprime (gcd > 1)
 * - If so, I remove both and replace them with their LCM, repeating this process until no more adjacent non-coprime pairs are found. 
 * 
 */
