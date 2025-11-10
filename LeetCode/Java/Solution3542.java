
import java.util.ArrayList;
import java.util.List;

public class Solution3542 {
    public int minOperations(int[] nums) {
        List<Integer> set = new ArrayList<>();
        int count = 0;
        for(int e : nums) {
            while(!set.isEmpty() && set.get(set.size()-1) > e) {set.remove(set.size()-1);}
            if(e == 0) continue;
            if(set.isEmpty() || set.get(set.size()-1) < e) {
                set.add(e);
                count++;
            }
        }
        return count;
    }
}