package LeetCode.Java;

class Solution3439 {
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] duration = new int[n];
        for (int i = 0; i < n; i++) {
            duration[i] = endTime[i] - startTime[i];
        }
        // Calculate all possible gaps
        int[] gaps = new int[n + 1];
        // Gap before first meeting
        gaps[0] = startTime[0];
        // Gaps between meetings
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        gaps[n] = eventTime - endTime[n - 1];

        if (k == 0) {
            int maxGap = 0;
            for (int gap : gaps) maxGap = Math.max(maxGap, gap);
            return maxGap;
        }

        int maxFree = 0;
        for (int i = 0; i + k < gaps.length; i++) {
            int mergedGap = 0;
            for (int j = i; j <= i + k; j++) {
                mergedGap += gaps[j];
            }
            maxFree = Math.max(maxFree, mergedGap);
        }
        return maxFree;
    }



    public static void main (String[] args) {
        System.out.println("First Test for Array: (Should be 6): " + maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10}));
        System.out.println("Second Test: (Should be 7) : " + maxFreeTime(21,1,new int[]{7,10,16}, new int[]{10,14,18}));
    }
}