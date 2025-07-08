package NeetCode.ArraysHashing;

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
