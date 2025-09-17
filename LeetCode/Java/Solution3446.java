
import java.util.ArrayList;
import java.util.List;

public class Solution3446 {
    public int[][] sortMatrix(int[][] grid) {
        //bottom left diagonals
        for(int i = grid.length - 1; i >= 0; i--) {
            List<Integer> diagonal = new ArrayList<>();
            int r = i, c = 0;
            while (r < grid.length && c < grid.length) {
                diagonal.add(grid[r][c]);
                r++;
                c++;
            }
            diagonal.sort((a, b) -> b - a);
            r = i; c = 0;
            int pos = 0;
            while (r < grid.length && c < grid.length) {
                grid[r][c] = diagonal.get(pos++);
                r++;
                c++;
            }
        }

        //top right diagonals
        for(int i = 1; i < grid.length; i++) {
            List<Integer> diagonal = new ArrayList<>();
            int r = 0, c = i;
            while (r < grid.length && c < grid.length ) {
                diagonal.add(grid[r][c]);
                r++;
                c++;
            }
            diagonal.sort(Integer::compareTo);

            r = 0; c = i;
            int pos = 0;
            while (r < grid.length && c < grid.length) {
                grid[r][c] = diagonal.get(pos++);
                r++;
                c++;
            }
        }
        return grid;
    }
}

/*
 * So you have a matrix here that is n length.
 * The diaganols in the bottom left triangle (including the middle) are sorted in non increasing order. 
 * The diagonals in the top right triangle are sorted in non decreasing order. 
 * 
 * Approach: 
 * 1. Identify all diagonals form 
 *  - the last row (first column)
 *  - the first row (columns from 1 to m-1)
 * 2. For each diagonal
 *  - Extract all elements into a temp vector
 *  - Sort the vector in descending order
 * 3. Store all diagonals in a list.
 * 4. Rewrite the matrix by filling back each sorted diagonal. 
 */
