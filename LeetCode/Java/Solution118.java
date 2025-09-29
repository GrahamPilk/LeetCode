

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                } else {
                    rows.add(tri.get(i - 1).get(j - 1) + tri.get(i - 1).get(j));
                }
            }
            tri.add(rows);
        }
        return tri;
    }
}

/*
 * Given an integer numRows, return the first numRows of Pascal's Triangle
 * In Pascal's Triangle, each number is the sum of the two numbres directly above them. 
 * 
 * Example 1: Input: numRows = 5
 * output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * Explanation: Creating the main double arrList, going through the numRows...
 * Creating another list for what were going to add to the main array. 
 * Check if it is beggining or end and add 1 since outide is always 1
 * else: we add the numbers from the previous number on the tri together to get an added number. 
 */