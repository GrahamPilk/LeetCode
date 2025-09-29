
import java.util.Arrays;

public class Solution3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] used = new boolean[baskets.length];
        Arrays.fill(used, false);
        int count = 0;
        for(int i = 0; i < fruits.length; i++) {
            boolean placed = false;
            for(int j = 0; j < baskets.length; j++) {
                if(fruits[i] <= baskets[j] && used[j] == false){
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if(!placed) count++;
        }
        return count;
    }
}

/*
 * Goal: Return the number of fruit types that remain unplaced aftera ll possible allocations are made. 
 * - Eah fruit type must be placed in the leftmost avaolable basket with a capacity greater than or equal to the quantity of that fruit type.
 * - Each basket can hold only one type of fruit. 
 * - If a fruit type cannot be placed in any basket, it remains unplaced. 
 * 
 * My solution works well and makes sense. I had a logic error at first which was marking the fruits position as true even though it should have been baskets. Then it counts fruits that could not be placed in any basket. 
 */
