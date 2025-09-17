package LeetCode.Java;

import java.util.LinkedList;
import java.util.List;

public class Solution989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];  
                i--;
            }
            res.addFirst(k % 10); 
            k /= 10;              
        }

        return res;
    }
}

/*
 * Goal: turn the int[]num into an int and add k, then go to list
 * 
 * How it works: LinkedList to achieve O(1) insertion. go through num and add digit of k 1 at a time. then return the list added up. 
 * The addFirst method is used to add an element to the first or top of a data structure. 
 */