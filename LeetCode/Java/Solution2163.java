
import java.util.PriorityQueue;

public class Solution2163 {
    public static long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;
        long[] leftMins = new long[len];
        long[] rightMaxs = new long[len];
        long leftSum = 0, rightSum = 0;

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        //left
        for(int i =0; i < n; i++) {
            leftHeap.offer(nums[i]);
            leftSum += nums[i];
        }
        leftMins[n-1] = leftSum;
        for(int i = n; i < nums.length - n; i++) {
            int x = nums[i];
            if (x < leftHeap.peek()) {
                leftSum += x - leftHeap.poll();
                leftHeap.offer(x);
            }
            leftMins[i] = leftSum;
        }
        //right
        for(int i = nums.length-1; i >= nums.length-n; i--) {
            rightHeap.offer(nums[i]);
            rightSum += nums[i];
        }
        rightMaxs[nums.length-n] = rightSum;
        for(int i = nums.length-n-1; i >= n-1; i--) {
            if(nums[i] > rightHeap.peek()) {
                rightSum += nums[i] - rightHeap.poll();
                rightHeap.offer(nums[i]);
            }
            rightMaxs[i] = rightSum;
        }




        long minDiff = Long.MAX_VALUE;
        for (int i = n-1; i < nums.length-n;i++) {
            minDiff = Math.min(minDiff, leftMins[i] - rightMaxs[i+1]);
        }
        return minDiff;
    }

    public static void main (String[] args) {
        System.out.println("7,9,5,8,1,3: " + minimumDifference(new int[]{7,9,5,8,1,3}));
    }
}

/*
 * First Commit: O(n log n)
 * - Works but so inifficient because it goes through and adds every possible numsTwo to an ArrayList using recursion. 
 * - Basically creates an arraylist of every possible NumsTwo combination, finds the first and second part. finds the diffs and adds it to an arrayList of diffs then finds min of that. 
 * 
 * What I need to do:
 * - Make it more efficient by using a minHeap and maxheap
 * - A minHeap is a complete binary tree where the children nodes have a higher value than the parent nodes. 
 * - A MaxHeap is a binary tree where the parent nodes are higher value than the children. 
 * - We use a Priority Queue which basically stores these heaps. We can use the poll method to get first element of queue. (the one with the highest priority or the head)
 * - Offer returns a boolean value, true if successfuly inserted. It adds a specified element into the priority queue. When it is inserted, the PriorityQueue internally reorganizes itelse to maintian the priority order based on the elements natural ordering
 * - We use peek to retrieve the head of the queue in PriorityQueue. 
 */


