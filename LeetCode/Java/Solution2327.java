
import java.util.HashMap;
import java.util.Map;

public class Solution2327 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1000000007;
        long know = 1;
        long spread = 0;
        Map<Integer, Integer> forgetOnDay = new HashMap<>();
        Map<Integer, Integer> beginSpread = new HashMap<>();

        beginSpread.put(delay+1, 1);
        forgetOnDay.put(forget+1, 1);
        for (int day = 2; day <= n; day++) {
            spread = (spread +beginSpread.getOrDefault(day, 0) - forgetOnDay.getOrDefault(day, 0) + MOD) % MOD;
            know = (know + spread - forgetOnDay.getOrDefault(day, 0) + MOD) % MOD;
            beginSpread.put(day+delay, (int)spread);
            forgetOnDay.put(day+forget, (int)spread);
        }
        return (int)know;
    }
}
