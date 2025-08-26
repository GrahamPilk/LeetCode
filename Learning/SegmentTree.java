package Learning;

public class SegmentTree {
    //root of the segment tree
    private SegmentTreeNode root;
    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    //Build the Segment tree recursively
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end) {
            //Leaf node: store the value directly
            node.sum = nums[start];
        } else {
            int mid = start +(end - start) / 2;
            //build left subtree
            node.left = buildTree(nums, start, mid);
            //build right subtree
            node.right = buildTree(nums, start, mid);
            //combine values from children
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
    //Query the range sum[i,j]
    public int rangeSum(int i, int j) {
        return rangeSum(root, i, j);
    }
    private int rangeSum(SegmentTreeNode node, int start, int end) {
        if (node == null || start > node.end || end < node.start) {
            //out of range or null node
            return 0;
        }
        if (start <= node.start && end >= node.end) {
            //fully covered by this node
            return node.sum;
        }
        return rangeSum(node.left, start, end) + rangeSum(node.right, start, end);
    }
    public void update(int i, int val) {
        update(root, i, val);
    }
    private void update(SegmentTreeNode node, int index, int val) {
        if(node.start == node.end) {
            //Leaf node: update the value
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if(index <= mid) {
                //update left subtree
                update(node.left, index, val);
            } else {
                //update right subtree
                update(node.right, index, val);
            }
            //Recalculate sum
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(nums);
        System.out.println("Range Sum (0, 2): " + segmentTree.rangeSum(0, 2)); //Output: 9
        segmentTree.update(1,10); //udate index 1 tp value 10
        System.out.println("Range Sum (0, 2): " + segmentTree.rangeSum(0, 2)); //output 16

    }
}

class SegmentTreeNode {
    //Rane of indices covered by this node.
    int start, end;
    //sum of values in the range
    int sum;
    SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.left = null;
        this.right = null;
    }
}


/*
 * Build Operation - used to construct the segment tree from the given array. O(n)
 * Range Query Operation - used to retrive the aggregate information such as sum, min or max over a specified range. O(log n)
 * Update Operation - used to modify the value of element in an array and it is update the corresponding segment tree nodes. O(log n)
 * 
 * Application of Segment Tree: Segment trees are powerful data structures with the different applications in computational problems where the efficient querying
 * ad updates over the range are required. Here are some applications.
 * - Range Sum Queries
 * - Range Min/Max Queries
 * - Range GCD Queries
 * - Range Update Queries
 * - Inversion count in an Array
 * - Finding the k-th smallest element in a subaarray
 * 
 * Organization of a Segment Tree - is a binary tree where each node represents the interval or segment of the array. The root of the segment tree represents the entire array and each leaf represents the single element of an array. Internal nodes represent the union of the children intervals. 
 * 
 * Let us consider this array [1,3,5,7,9,11]
 * Leaf Nodes are represent the individual elements of an array. Leaf Nodes are:
 * - [0,0] represents 1
 * - [1,1] represents 3
 * - [2,2] represents 5
 * - [3,3] represents 7
 * - [4,4] represents 9
 * - [5,5] represents 11
 * Internal Nodes are represent the sum of their children. Internal Nodes are:
 * - [0,1] represents the sum of 1 & 3
 * - [0,2] represents the sum of 1,3,5
 * - [0,3] represents the sum of 7 & 9
 * - [0,4] represents the sum of 7,9,11
 * - [0,5] represents the sum of all elements in the array. 
 */