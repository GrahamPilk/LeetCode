
public class Solution2210 {
    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) continue;

            int left = i - 1;
            while (left >= 0 && nums[left] == nums[i]) left--;

            int right = i + 1;
            while (right < nums.length && nums[right] == nums[i]) right++;

            if (left < 0 || right >= nums.length) continue;

            if (nums[i] > nums[left] && nums[i] > nums[right]) count++;
            if (nums[i] < nums[left] && nums[i] < nums[right]) count++;
        }
        return count;
    }
}

/*
 * This code defines a method to count the number of hills and valleys in an array of integers.
 * A hill is defined as a position where the value is greater than its immediate neighbors,
 * and a valley is where the value is less than its immediate neighbors.
 * The method iterates through the array, skipping equal neighbors, and checks the conditions for hills
 * and valleys by finding the closest non-equal neighbors on both sides.
 * It returns the total count of hills and valleys found in the array.
 * 
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(1), as no additional space is used that scales with input size.
 * 
 * 2nd best time complexity solution. 
 */