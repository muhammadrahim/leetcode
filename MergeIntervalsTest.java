package leetcode;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.deepEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeIntervalsTest {

    @Test
    void testMergeIntervals() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] actual = mergeIntervals.merge(intervals);
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};

        int[][] intervals1 = {{3,4},{1,5}};
        int[][] actual1 = mergeIntervals.merge(intervals1);
        int[][] expected1 = {{1, 5}};

        int[][] intervals2 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] actual2 = mergeIntervals.merge(intervals2);
        int[][] expected2 = {{1, 6}, {8, 10}, {15, 18}};

        assertTrue(deepEquals(actual, expected));
        assertTrue(deepEquals(actual1, expected1));
        assertTrue(deepEquals(actual2, expected2));
    }
}