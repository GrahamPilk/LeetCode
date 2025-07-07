package LeetCode.Java;
import java.util.ArrayList;
import java.util.Collections;
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //merge arrays
        //sort arrays
        //find middle in double
        ArrayList<Integer> merged = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            merged.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            merged.add(nums2[i]);
        }
        Collections.sort(merged);
        double x = 0.0;
        if(merged.size() % 2 == 0) {
            x = (double) (merged.get(merged.size()/2 - 1) + merged.get(merged.size()/2)) / 2.0; 
        }
        else {
            x = (double) merged.get(merged.size()/2);
        }
        return x;
    }

    public static void main (String[] args) {
        Solution4 sol = new Solution4();
        System.out.println("nums1 = [1,3], nums2 = [2], (2.00): " + sol.findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
    }
}
