
public class Solution3201 {
    public int maximumLength(int[] nums) {
        int odd = 0;
        int even = 0;
        int count = 1;
        int prev = 0;

        if(nums[0] % 2 == 0) prev = 1;

        for(int i  = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }

            if(prev == 1 && nums[i] % 2 == 1) {
                prev = 0;
                count++;
            } else if(prev == 0 && nums[i] % 2 == 0) {
                count++;
                prev = 1;
            }

        }
        return Math.max(odd, Math.max(even, count));
    }
}
