
public class Solution2044 {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for(int i : nums) {
            maxOR |= i;
        }
        return dfs(nums, 0, 0, maxOR);
    }

    private int dfs(int[] nums, int index, int currOr, int maxOr){
        if(index == nums.length) {
            return currOr == maxOr ? 1 : 0;
        }
        //include nums[index]
        int with = dfs(nums, index+1, currOr | nums[index], maxOr);
        //exculde
        int without = dfs(nums, index + 1, currOr, maxOr);
        return with + without;
    }

}

/*
 * Goal: Find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the max bitwise OR
 * An array is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the element chosen are differnt. 
 * The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length-1] (0 indexed)
 * so lost lmao...
 * I used a DFS (depth first search which traverses trees or graph data structures. ) Starts at top then goes down by leftmost Tree, completes deepest and leftmost next everytime from parent (1 under)
 * How it works:
 * 1. Find the Max OR by computing maximum possible bitwise OR by OR-ing all elements in nums.
 * 2. Count subsets with Max OR (DFS). You use a recursive function dfs to explore each index with two choices, Include or Exclude
 *  - Include: nums[index] in the current subset, updates currOr with | nums[index]
 *  - Exclude: nums[index] keeps currOr unchanged
 * 3. Base Case, when you reach end of the array, you check if the current OR (currOr) equals maxOR, if yes return 1, if not return 0
 * 4. Combine results, for each call, you sum the results of including and excluding the curr element. 
 * 5. Return total count, The initial call to dfs starts the process and returns the total number of subsets. 
 */
