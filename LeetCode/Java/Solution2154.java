public class Solution2154 {
    public int findFinalValue(int[] nums, int original) {
        int multValue = original;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == multValue) {
                multValue = multValue * 2;
                i = -1;
            }
        }
        return multValue;
    }
}