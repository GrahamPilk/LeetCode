public class Solution2257 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int unguarded = 0;
        int[][] grid = new int[m][n]; //init grid for everythign
        for(int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1; //-1 if it is a wall.
        }
        for(int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1; //1 if it is a guard
        }

        for(int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            //up
           for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == -1 || grid[i][y] == 1) {
                    break;
                }
                grid[i][y] = 2;
            }
            //down
            for(int i = x + 1; i < m; i++) {
                if (grid[i][y] == -1 || grid[i][y] == 1) {
                    break;
                }
                grid[i][y] = 2;
            }
            //left
            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == -1 || grid[x][j] == 1) {
                    break;
                }
                grid[x][j] = 2;
            }
            //right
            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == -1 || grid[x][j] == 1) {
                    break;
                }
                grid[x][j] = 2;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguarded++;
                }
            }
        }
        return unguarded;
    }
}

/*
* Goal: Find every single unguarded cell 
How: Check up, down, right, left for unguarded cells. 
*/