class Solution3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;
        for (int[] dimension : dimensions) {
            int length = dimension[0];
            int width = dimension[1];
            double diagonal = Math.sqrt(length * length + width * width);
            int area = length * width;
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            }
            else if (diagonal == maxDiagonal && area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        Solution3000 sol = new Solution3000();
        int[][] dimensions = {{3,4},{2,5},{1,6}};
        System.out.println(sol.areaOfMaxDiagonal(dimensions)); // Output: 6
    }
}

/*
 * This code defines a method to calculate the max diagonal. If multiple rectangles have the same max diagonal, it returns the area of the one with the largest area.
 */