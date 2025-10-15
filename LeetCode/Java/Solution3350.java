import java.util.List;

public class Solution3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[] array = nums.stream().mapToInt(i -> i).toArray();
        int n = array.length;
        int maxK = 0, prev = 0, curr = 1;
        for(int i = 1; i < n; i++) {
            if(array[i] > array[i-1]) {
                curr++;
            } else {
                maxK = Math.max(maxK, Math.max(curr / 2, Math.min(prev, curr)));
                prev = curr;
                curr = 1;
            }
        }
        maxK = Math.max(maxK, Math.max(curr / 2, Math.min(prev, curr)));
        return maxK;
    }
}
