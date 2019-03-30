package ru.roman.algo.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printList;

/**
 *
 */
class StackAndQueueExample {

    public static void main(String[] args) {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};

        System.out.println("=1=== Add to End, Remove from Head =====================");
        addAndRemoveFromQueue(arr, new LinkedList<>());
        addAndRemoveFromQueue(arr, new ArrayDeque<>());
        addAndRemoveFromQueue(arr, new PriorityQueue<>());
        System.out.println("=2=== Offer to End, Poll from Head =====================");
        offerAndPollFromQueue(arr, new LinkedList<>());
        offerAndPollFromQueue(arr, new ArrayDeque<>());
        offerAndPollFromQueue(arr, new PriorityQueue<>());
        System.out.println("=3======================================================");
        addAndRemoveFromDeque(arr, new LinkedList<>());
        addAndRemoveFromDeque(arr, new ArrayDeque<>());
        System.out.println("=4======================================================");
        offerAndPollFromDeque(arr, new LinkedList<>());
        offerAndPollFromDeque(arr, new ArrayDeque<>());
        System.out.println("=5=== Push and Poll/Pop - Stack Mode ===================");
        pushAndPollFromDeque(arr, new LinkedList<>());
        pushAndPollFromDeque(arr, new ArrayDeque<>());
        System.out.println("=6======================================================");
        pushAndPopFromDeque(arr, new LinkedList<>());
        pushAndPopFromDeque(arr, new ArrayDeque<>());
    }

    private static void addAndRemoveFromQueue(int[] arr, Queue<Integer> q) {
        for (int i : arr) {
            q.add(i);
        }
        List<Integer> result = new ArrayList<>(q.size());
        while (!q.isEmpty()) {
            result.add(q.remove());
        }
        System.out.println("Queue type                : " + q.getClass());
        System.out.println("Add to Queue in order     : " + printArray(arr, 2));
        System.out.println("Remove from Queue in order: " + printList(result, 2));
        System.out.println();
    }

    private static void offerAndPollFromQueue(int[] arr, Queue<Integer> q) {
        for (int i : arr) {
            q.offer(i);
        }
        List<Integer> result = new ArrayList<>(q.size());
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        System.out.println("Queue type              : " + q.getClass());
        System.out.println("Offer to Queue in order : " + printArray(arr, 2));
        System.out.println("Poll from Queue in order: " + printList(result, 2));
        System.out.println();
    }

    private static void addAndRemoveFromDeque(int[] arr, Deque<Integer> q) {
        for (int i : arr) {
            q.offer(i);
        }
        List<Integer> result = new ArrayList<>(q.size());
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        System.out.println("Deque type              : " + q.getClass());
        System.out.println("Offer to Deque in order : " + printArray(arr, 2));
        System.out.println("Poll from Deque in order: " + printList(result, 2));
        System.out.println();
    }

    private static void offerAndPollFromDeque(int[] arr, Deque<Integer> q) {
        for (int i : arr) {
            q.offer(i);
        }
        List<Integer> result = new ArrayList<>(q.size());
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        System.out.println("Deque type              : " + q.getClass());
        System.out.println("Offer to Deque in order : " + printArray(arr, 2));
        System.out.println("Poll from Deque in order: " + printList(result, 2));
        System.out.println();
    }

    private static void pushAndPollFromDeque(int[] arr, Deque<Integer> q) {
        for (int i : arr) {
            q.push(i);
        }
        List<Integer> result = new ArrayList<>(q.size());
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        System.out.println("Deque type              : " + q.getClass());
        System.out.println("Push to Deque in order  : " + printArray(arr, 2));
        System.out.println("Poll from Deque in order: " + printList(result, 2));
        System.out.println();
    }

    private static void pushAndPopFromDeque(int[] arr, Deque<Integer> q) {
        for (int i : arr) {
            q.push(i);
        }
        List<Integer> result = new ArrayList<>(q.size());
        while (!q.isEmpty()) {
            result.add(q.pop());
        }
        System.out.println("Deque type             : " + q.getClass());
        System.out.println("Push to Deque in order : " + printArray(arr, 2));
        System.out.println("Pop from Deque in order: " + printList(result, 2));
        System.out.println();
    }
}
