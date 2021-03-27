package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int[] first = intervals[0];
        list.add(first);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < first[1]) {
                first[1] = Math.max(intervals[i][1], first[1]);
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    
}

/*
cases: {1,3}, {2,4} a[1] > b[0]
 */
