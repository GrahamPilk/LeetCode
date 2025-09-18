import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution3408 {
    private PriorityQueue<int[]> pq;
    private Map<Integer,Integer> taskPriority;
    private Map<Integer,Integer> taskOwner;

    public Solution3408(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b) -> {
            if (b[0] != a[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        taskPriority = new HashMap<>();
        taskOwner = new HashMap<>();
        for (List<Integer> t : tasks) add(t.get(0), t.get(1), t.get(2));
    }

    public void add(int userId, int taskId, int priority) {
        pq.add(new int[]{priority, taskId});
        taskPriority.put(taskId, priority);
        taskOwner.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        pq.add(new int[]{newPriority, taskId});
        taskPriority.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        taskPriority.put(taskId, -1);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int p = t[0], id = t[1];
            if (taskPriority.getOrDefault(id, -2) == p) {
                taskPriority.put(id, -1);
                return taskOwner.getOrDefault(id, -1);
            }
        }
        return -1;
    }
}

/*
 * Goal: Make a task manager that can assign a task to a user, give each task a priority, allow us to edit, remove, execute the top priority task. 
 * 
 * Constructor: We are using PriorityQueue for tasks are supposed to be based on some priority. 
 * Add: We add the task to the pq, keeping priority as first parameter,. We then map the taskId to its priority and taskId to its userId
 * Edit: We add it with its new priority in the heap and update its priority in the priority map. We do not update the taskOwner map as the userId remains the same. 
 * Remove: We mark the task priority as -1 which is used t oindicate it has been removed. 
 * Execute: 
 * - We need to remove the task with its max priority and print its userId
 * - We keep popping the queue until we find an element with valid priority, or an element which has its priority marked as its current priority. 
 * - as soon as we find that we return that. 
 * 
 * 
 * 
 */