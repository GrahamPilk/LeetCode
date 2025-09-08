import java.util.Arrays;

public class Solution3027 {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        //Sort by x ascending, if x is same , then y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; //higher y first
            }
            return a[0] - b[0]; // smaller x first
        });
        int result = 0;
        for (int i = 0; i < n; i++) {
            int aliceX = points[i][0];
            int aliceY = points[i][1]; //Alice is upper left
            int bestBobY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int bobX = points[j][0];
                int bobY = points[j][1]; //Bob is lower right

                //Bob must not be above Alice
                if(bobY > aliceY){
                    continue;
                }

                //Ensure no intermediate point invalidates the pair
                if(bobY > bestBobY){
                    result++;
                    bestBobY = bobY;
                }
            }
        }
        return result;
    }
}