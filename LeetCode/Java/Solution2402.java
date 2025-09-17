
import java.util.Arrays;

public class Solution2402 {
    public int mostBooked(int n, int[][] meetings) {
        //track room end times
        int[] count = new int[n];
        long[] busy = new long[n];
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]); //sort by meeting times
        //for each meeting, assign it to a room free at start. If none are free then find the earlist room and delay the meeting. 
        //count how many times each room is used. 
        for(int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            long earliest = Long.MAX_VALUE;
            int roomIndex = -1;
            boolean assigned = false;
            for(int i = 0; i < n; i++) {
                if (busy[i] < earliest) {
                    earliest = busy[i];
                    roomIndex = i;
                }
                if (busy[i] <= start) {
                    busy[i] = end;
                    count[i]++;
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                busy[roomIndex] += (end - start);
                count[roomIndex]++;
            }
        }
        int max = 0, res = 0; //finding max for ans
            for (int i = 0; i < n; i++) {
                if (count[i] > max) {
                    max = count[i];
                    res = i;
                }
            }
        return res;
    }
}
