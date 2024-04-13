import java.util.*;

public class BottomUpMergeSort {

    // Merge two sorted queues
    private static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> mergedQueue = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() < q2.peek()) {
                mergedQueue.offer(q1.poll());
            } else {
                mergedQueue.offer(q2.poll());
            }
        }

        while (!q1.isEmpty()) {
            mergedQueue.offer(q1.poll());
        }

        while (!q2.isEmpty()) {
            mergedQueue.offer(q2.poll());
        }

        return mergedQueue;
    }

    // Bottom-up merge sort
    public static Queue<Integer> bottomUpMergeSort(List<Integer> items) {
        Queue<Queue<Integer>> queueOfQueues = new LinkedList<>();

        // Initialize queues with individual items
        for (int item : items) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(item);
            queueOfQueues.offer(q);
        }

        // Merge pairs of queues until only one queue remains
        while (queueOfQueues.size() > 1) {
            Queue<Integer> q1 = queueOfQueues.poll();
            Queue<Integer> q2 = queueOfQueues.poll();
            queueOfQueues.offer(merge(q1, q2));
        }

        // Return the sorted queue
        return queueOfQueues.poll();
    }

    // Test the implementation
    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(5, 3, 8, 2, 9, 1, 7, 4, 6);
        Queue<Integer> sortedQueue = bottomUpMergeSort(items);

        // Print the sorted items
        System.out.println("Sorted items:");
        while (!sortedQueue.isEmpty()) {
            System.out.print(sortedQueue.poll() + " ");
        }
        System.out.println();
    }
}
