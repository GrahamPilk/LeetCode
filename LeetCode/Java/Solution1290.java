package LeetCode.Java;

public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        //go through list, add 1 to count = 
        int count = head.val;
        while (head.next != null) {
            count = (count << 1) | head.next.val;
            head = head.next;
        }
        return count;
    }
}
