public class Solution876 {
    public ListNode middleNode(ListNode head) {
        if(head==null) {return null;}
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

/*
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */