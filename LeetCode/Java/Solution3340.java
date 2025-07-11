package LeetCode.Java;
import java.util.*;

class Solution3340 {
    public boolean findGap(int[] gaps, int time, int index, int n) {
        for (int i = 0; i < n + 1; i++) {
            if (gaps[i] >= time && i != index && i != index + 1) {
                return true;
            }
        }
        return false;
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] meetings = new int[n];
        int[] gaps = new int[n + 1];

        for (int i = 0; i < n; i++) {
            meetings[i] = (endTime[i] - startTime[i]);
        }

        gaps[0] = startTime[0];
        gaps[n] = eventTime - endTime[n - 1];

        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int leftGap = gaps[i];
            int rightGap = gaps[i + 1];

            if (findGap(gaps, meetings[i], i, n)) {
                ans = Math.max(ans, leftGap + rightGap + meetings[i]);
            } else {
                ans = Math.max(ans, leftGap + rightGap);
            }
        }

        return ans;
    }
}
