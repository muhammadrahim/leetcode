package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSlidingWindow {
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] arr;

    public MaxSlidingWindow(int[] arr, int[] expected, int k) {
        runAndPrint(arr, k, expected);
    }

    private void runAndPrint(int[] arr, int k, int[] expected) {
        int[] actual = maxSlidingWindow(arr, k);
        System.out.printf("actual: %s%n", Arrays.toString(actual));
        System.out.printf("expected: %s%n", Arrays.toString(expected));
    }

    private void clean(int i, int k) {
        if (!deque.isEmpty() && deque.peekFirst() == i - k) {
            deque.removeFirst();
        }

        while (!deque.isEmpty() && arr[i] > arr[deque.getLast()]) {
            deque.removeLast();
        }
    }

    private int[] maxSlidingWindow(int[] arr, int k) {
        // arrange
        this.arr = arr;
        int max = 0;

        // init
        for (int i = 0; i < k; i++) {
            clean(i, k);
            deque.add(i);
            if (arr[i] > arr[max]) max = i;
        }

        int[] res = new int[arr.length - k + 1];
        res[0] = arr[max];

        for (int i = k; i < arr.length; i++) {
            clean(i, k);
            deque.addLast(i);
            res[i - k + 1] = arr[deque.getFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        new MaxSlidingWindow(
                IntStream.of(1, 3, -2, 1, -4, 6).toArray(),
                IntStream.of(3, 3, 1, 6).toArray(),
                3
        );

        new MaxSlidingWindow(
                IntStream.of(7, 2, 4).toArray(),
                IntStream.of(7, 4).toArray(),
                2
        );
        new MaxSlidingWindow(
                IntStream.of(4, -2).toArray(),
                IntStream.of(2).toArray(),
                2
        );
        new MaxSlidingWindow(
                IntStream.of(1,-1).toArray(),
                IntStream.of(1).toArray(),
                2
        );
    }
}
