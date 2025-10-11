
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3186 {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);
        List<Integer> unique = new ArrayList<>();
        List<Long> damages = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int curr = power[i];
            long sum = curr;
            while (i+1 < n && power[i+1] == curr) {
                i++;
                sum += curr;
            }
            unique.add(curr);
            damages.add(sum);
        }
        long[] dp = new long[unique.size() + 1];
        for(int j = unique.size() - 1; j >= 0; j--) {
            long skip = dp[j+1];
            long take = damages.get(j);
            int next = j+1;
            while (next < unique.size() && unique.get(next) - unique.get(j) <= 2) {
                next++;
            }
            take += dp[next];
            dp[j] = Math.max(skip, take);
        }
        return dp[0];
    }
}