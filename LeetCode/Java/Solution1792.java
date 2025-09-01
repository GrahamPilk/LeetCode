
import java.util.PriorityQueue;

class Solution1792 {
    private class Pair {
        int index;
        double ratio;
        private Pair(int index, double ratio) {
            this.index = index;
            this.ratio = ratio;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> -Double.compare(a.ratio, b.ratio));
        for (int i = 0; i < classes.length; i++) {
            double curr = (double) classes[i][0] / classes[i][1];
            double next = (double) ++classes[i][0] / ++classes[i][1];
            pq.offer(new Pair(i, next - curr));
        }
        while (extraStudents-- > 0) {
            int i = pq.poll().index;
            double curr = (double) classes[i][0] / classes[i][1];
            double next = (double) ++classes[i][0] / ++classes[i][1];
            pq.offer(new Pair(i, next - curr));
        }
        double averageRatio = 0;
        for (int[] c : classes) {
            averageRatio += (double) --c[0] / --c[1];
        }
        return (double) averageRatio / classes.length;
    }
}

/*
 * Goal: Return the max posible average pass ratio after assigning the extraStudents. 
 * The pass ratio of a class is = to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes. 
 */